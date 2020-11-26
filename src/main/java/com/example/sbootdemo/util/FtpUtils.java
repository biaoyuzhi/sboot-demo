package com.example.sbootdemo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

/**
 * zhwu on 2020/10/17.
 */
public class FtpUtils {
    private static Logger logger = LoggerFactory.getLogger(FtpUtils.class);

    private static final String SECRET_KEY = "xxxx";       //密钥
    private static final String SHORT_UNDER = "_";
    private static final String SUFFIX_ZIP = ".zip.part";

    //ftp服务器地址
    private static String hostname = "192.168.99.100";
    //ftp服务器端口号默认为21
    private static Integer port = 21;
    //ftp登录账号
    private static String username = "tcpuser";
    //ftp登录密码
    private static String password = "tcpuser";
    private static String workPath = "/usr";

    private static FTPClient ftpClient = new FTPClient();

    /**
     * 初始化ftp连接
     */
    private static void initFtp() {
        try {
            ftpClient.connect(hostname, port);          //连接ftp服务器
            ftpClient.login(username, password);        //登录ftp服务器
            int replyCode = ftpClient.getReplyCode();   //是否成功登录服务器
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                logger.error("[initFtp] connect ftp server failed...:" + hostname + ":" + port);
                ftpClient.disconnect();
            }
            ftpClient.setControlEncoding("utf-8");
            ftpClient.enterLocalPassiveMode();  //设置为被动模式(如上传文件夹成功，不能上传文件，注释这行，否则报错refused:connect)
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);    //设置传输方式为流方式，不设置linux环境上传文件可能异常
            ftpClient.setRemoteVerificationEnabled(false);  //ftp关闭远程校验
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);    //设置文件类型，不设置解压时提示文件损坏
            ftpClient.changeWorkingDirectory(workPath);     //进入指定路径
        } catch (IOException ex) {
            logger.error("[initFtp] ftp init fail!", ex);
        }
    }

    /**
     * 关闭ftp连接
     */
    public static void closeFtp() {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException ex) {
                logger.error("[closeFtp] ftp close fail!", ex);
            }
        }
    }

    /**
     * ftp上传文件
     *
     * @param fileName 需要上传的文件名。eg：xxx.zip.part
     * @param partName 上传到ftp的文件名
     */
    public static void upload(String fileName, String partName) throws Exception {
        if (!ftpClient.isConnected()) {
            initFtp();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            ftpClient.storeFile(fileName, fis);
            //上传完后去掉.part后缀
            String zipName = fileName.substring(0, fileName.lastIndexOf("."));
            ftpClient.rename(fileName, zipName);
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成加密的zip压缩文件，后缀为.zip.part
     *
     * @param srcPath eg:"xxx_sale"
     * @param file    eg:"xxx_sale.jl"
     * @return 后缀为.zip.part的压缩文件名称
     */
    public static String generateZip(String srcPath, File file) throws IOException, ZipException {
        /**
         * 拼接文件名
         */
        FileInputStream fileInputStream = new FileInputStream(file);
        //1、获取文件的MD5值，为32个字符
        String fileHex = DigestUtils.md5DigestAsHex(fileInputStream);
        fileInputStream.close();
        //获取拼接后的MD5值
        String dateHex = DigestUtils.md5DigestAsHex((fileHex + SECRET_KEY).getBytes());
        //2、获取最后MD5值的前3个字符+后3个字符作为数据校验码
        String dataCheckCode = dateHex.substring(0, 3) + dateHex.substring(29);
        //3、获取文件名校验码
        String nameHex = DigestUtils.md5DigestAsHex(
                (srcPath + SHORT_UNDER + dataCheckCode + SHORT_UNDER + SECRET_KEY).getBytes());
        //获取MD5值的前4个字符+后2个字符作为文件名校验码
        String nameCheckCode = nameHex.substring(0, 4) + nameHex.substring(30);
        //拼接出最终文件名
        String basePath = srcPath + SHORT_UNDER + dataCheckCode + SHORT_UNDER + nameCheckCode;
        /**
         * zip压缩，并使用密钥加密
         */
        String destPath = basePath + SUFFIX_ZIP;
        File repeatedFile = new File(destPath);
        if (repeatedFile.exists()) {    //删除重复的文件，否则压缩过程会抛空指针异常
            repeatedFile.delete();
        }
        //生成的压缩文件
        ZipFile zipFile = new ZipFile(destPath);
        //设置加密参数
        ZipParameters param = new ZipParameters();
        param.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);        //设置压缩方式
        param.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); //设置压缩级别
        param.setEncryptFiles(true);
        param.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        param.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        param.setPassword(SECRET_KEY);                                  //设置压缩密码
        //执行压缩
        zipFile.addFile(file, param);
        //删除压缩前的.jl文件
        file.delete();
        return destPath;
    }

}

package com.example.sbootdemo.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * zhwu on 2020/10/17.
 */
public class FtpUtils {
    //ftp服务器地址
    private static String hostname = "192.168.99.100";
    //ftp服务器端口号默认为21
    private static Integer port = 21;
    //ftp登录账号
    private static String username = "docker";
    //ftp登录密码
    private static String password = "tcuser";
    private static String workPath = "/usr";

    private static FTPClient ftpClient = new FTPClient();

    /**
     * 初始化ftp连接
     */
    private static void initFtp() {
        try {
            ftpClient.setControlEncoding("utf-8");
            ftpClient.connect(hostname, port);          //连接ftp服务器
            ftpClient.login(username, password);        //登录ftp服务器
            int replyCode = ftpClient.getReplyCode();   //是否成功登录服务器
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.err.println("connect failed...ftp服务器:" + hostname + ":" + port);
                ftpClient.disconnect();
            }
            System.err.println("connect successfu...ftp服务器:" + hostname + ":" + port);
            ftpClient.changeWorkingDirectory(workPath);
        } catch (IOException ex) {
            ex.printStackTrace();
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
                ex.printStackTrace();
            }
        }
    }

    /**
     * ftp上传文件
     *
     * @param fileName 需要上传的文件名。eg：xxx.zip.part
     */
    public static void upload(String fileName) {
        if (!ftpClient.isConnected()) {
            initFtp();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            ftpClient.storeFile(fileName, fis);
            String zipName = fileName.substring(0, fileName.lastIndexOf("."));
            ftpClient.rename(fileName, zipName);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fis !=  null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

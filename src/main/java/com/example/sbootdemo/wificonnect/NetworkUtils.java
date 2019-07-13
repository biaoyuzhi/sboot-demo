package com.example.sbootdemo.wificonnect;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * wifi连接工具类，主要封装cmd命令的执行
 *
 * @Author: wzh
 * @Date: 2019/7/10 0010 下午 7:13
 */
public class NetworkUtils {
    /**
     * 校验WLAN配置文件是否正确
     * <p>
     * 校验步骤为：
     * ---step1 添加配置文件
     * ---step3 连接wifi
     * ---step3 ping校验
     */
    public static synchronized boolean check(String ssid, String password) {
        try {
            if (updateProfile(ssid,password)) {
                if (connect(ssid)) {
                    Thread.sleep(7000);
                    if (ping()) {
                        return true;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 执行器
     *
     * @param cmd   CMD命令
     * @param filePath 需要在哪个目录下执行
     */
    private static List<String> execute(String cmd, String filePath) {
        Process process;
        List<String> result = new ArrayList<String>();
        try {
            if (filePath != null) {
                process = Runtime.getRuntime().exec(cmd, null, new File(filePath));
            } else {
                process = Runtime.getRuntime().exec(cmd);
            }
            BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            String line;
            while ((line = bReader.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 添加配置文件
     *
     * @param profileName 添加配置文件，需带.xml，并在文件同目录下执行cmd命令
     *  eg:     E:\network\CMCC-h999.xml，可以先手动执行cmd命令将该配置文件添加进系统，后面测试wifi密码只需使用更新配置文件操作即可
     *  文件样式如下：
     *  <?xml version="1.0"?>
     * <WLANProfile xmlns="http://www.microsoft.com/networking/WLAN/profile/v1">
     * 	<name>CMCC-h999</name>                              //wifi名
     * 	<SSIDConfig>
     * 		<SSID>
     * 			<hex>434D43432D68393939</hex>               //SSID名的16进制数，字母需大写
     * 			<name>CMCC-h999</name>                      //SSID名
     * 		</SSID>
     * 	</SSIDConfig>
     * 	<connectionType>ESS</connectionType>
     * 	<connectionMode>auto</connectionMode>
     * 	<MSM>
     * 		<security>
     * 			<authEncryption>
     * 				<authentication>WPAPSK</authentication>     //加密类型
     * 				<encryption>AES</encryption>
     * 				<useOneX>false</useOneX>
     * 			</authEncryption>
     * 			<sharedKey>
     * 				<keyType>passPhrase</keyType>
     * 				<protected>false</protected>
     * 				<keyMaterial>jj7s44gj</keyMaterial>         //密码
     * 			</sharedKey>
     * 		</security>
     * 	</MSM>
     * </WLANProfile>
     */
    private static boolean addProfile(String profileName) {
        String cmd = "netsh wlan add profile filename="+profileName;
        List<String> result = execute(cmd, "E:\\network");
        result.forEach(x-> System.out.println(x));
        if (result != null && result.size() > 0) {
            if (result.get(0).contains("添加到接口")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 更新配置文件，主要更新密码，name和SSIDname可以写死
     *
     * @param ssid
     * @param password
     * @return
     */
    private static boolean updateProfile(String ssid, String password) {
        String cmd = "netsh wlan set profileparameter name="+ssid+" SSIDname="+ssid+" keyMaterial="+password;
        List<String> result = execute(cmd, null);
//        result.forEach(x-> System.out.println(x));
        if (result != null && result.size() > 0) {
            if (result.get(1).contains("已成功更新")) {
                return true;
            }
        }
        return false;
    }
    /**
     * 连接wifi
     *
     * @param ssid
     */
    private static boolean connect(String ssid) {
        boolean connected = false;
        String cmd = "netsh wlan connect name="+ssid;
        List<String> result = execute(cmd, null);
//        result.forEach(x-> System.out.println(x));
        if (result != null && result.size() > 0) {
            if (result.get(0).contains("已成功完成")) {
                connected = true;
            }
        }
        return connected;
    }
    /**
     * ping 校验
     */
    private static boolean ping() {
        boolean pinged = false;
        String cmd = "ping www.163.com";
        List<String> result = execute(cmd, null);
        result.forEach(x-> System.out.println(x));
        if (result != null && result.size() > 0) {
            for (String item : result) {
                if (item.contains("来自")) {
                    pinged = true;
                    break;
                }
            }
        }
        return pinged;
    }

    /**
     * 删除配置文件，如果上传的配置文件有误，可以手动执行该cmd命令，删除系统中有误的配置文件
     *
     * @param profileName 配置文件名，不带.xml
     */
    public static void deleteProfile(String profileName) {
        String cmd = "netsh wlan delete profile name="+profileName;
        List<String> result = execute(cmd, null);
        result.forEach(x-> System.out.println(x));
    }

    /**
     * 其他相关的cmd命令
     */
    // 列出所有可用wifi
//    netsh wlan show networks mode=bssid
    // 添加配置文件
//    netsh wlan add profile filename=FILE_NAME
    // 连接wifi
//    netsh wlan connect name=SSID_NAME
    // 导出配置文件
//    netsh wlan export profile key=clear
    // 列出配置文件
//    netsh wlan show profile
    // 删除配置文件
//    netsh wlan delete profile name=FILE_NAME
    // 列出接口
//    netsh wlan show interface
    // 开启接口
//    netsh interface set interface "Interface Name" enabled
}

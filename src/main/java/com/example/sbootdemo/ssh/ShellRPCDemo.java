package com.example.sbootdemo.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by wuzh on 2019/8/7.
 * Describe：使用java代码实现执行本地shell脚本和执行远程linux机器上的shell脚本
 */
public class ShellRPCDemo {
    /**
     * 执行本机上的shell命令，无需多余的第三方依赖
     *
     * @return
     */
    public static String execLocal() throws Exception{
        //本机为linux环境下
        String[] cmds = {"/bin/sh","-c","ls"};
        //本机为windows环境下
//        String[] cmds = {"cmd", "/c", "dir"};
        Process process = Runtime.getRuntime().exec(cmds);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            builder.append(line);
        }
        reader.close();
        return builder.toString();
    }

    /**
     * 使用SSH连接远程机器，再执行远程shell等脚本命令。pom.xml中需要引入ganymed-ssh2依赖
     *
     * @return
     * @throws Exception
     */
    public static String execSSH() throws Exception{
        Connection conn = new Connection("192.168.92.75", 22);
        conn.connect();
        //使用公钥连接远程机器，需要确保远程机器/etc/ssh/sshd_config文件中的PubkeyAuthentication设置为yes
        //需要读取本地保存的.pem公钥文件
        boolean keySuccess = conn.authenticateWithPublicKey("ubuntu", new File("d:/xxx.pem"), null);
        if (keySuccess == false) return null;
        Session session = conn.openSession();
        session.execCommand("kafka_2.12-2.2.0/bin/kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list hadoop75:9092 --topic test-topic --time -1");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new StreamGobbler(session.getStdout()),"gbk"));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            builder.append(line);
        }
        reader.close();
        return builder.toString();
    }

}

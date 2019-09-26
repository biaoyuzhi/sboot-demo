package com.example.sbootdemo.util;

import java.io.File;
import java.util.Scanner;

/**
 * 各种常见方法的归类，作为通用工具类
 * <p>
 * Created by wuzh on 2019/1/30.
 */
public class CommonUtils {

    //人民币消费过程中，解决double精度原因引起的误差。0.1元先转为10分，运算后通过String类型过度，返回double类型的以元为单位的结果
    public static double rmbCent2Round(int cent1, int cent2) {
        double balance = -0.1;
        int cent = cent1 - cent2;
        if (cent < 0) return balance;//余额不足，可以判断返回值balance<0为true，则表示余额不足
        StringBuffer result = new StringBuffer(String.valueOf(cent));
        int length = result.length();
        if (length > 2) {
            result = result.insert(length - 2, ".");
        } else {
            StringBuffer buffer = new StringBuffer("0.");
            switch (length) {
                case 2:
                    result = buffer.append(result);
                    break;
                case 1:
                    result = buffer.append("0").append(result);
                    break;
                default:
                    break;
            }
        }
        balance = Double.parseDouble(result.toString());
        return balance;
    }

    //java代码模拟DOS下的tree命令
    public static void tree(){
        Scanner cin = new Scanner(System.in);
        String path = cin.nextLine();
        File dir = new File(path);
        dfs(dir);
    }
    private static int depth = 0;
    private static void dfs(File parentDir) {
        depth++;
        if (parentDir.isDirectory()) {
            print(parentDir);
            File[] fileArr = parentDir.listFiles();
            for (File f : fileArr) {
                dfs(f);
            }
        }
        if (parentDir.isFile()) {
            print(parentDir);
        }
        depth--;
    }
    private static void print(File f) {
        for (int i = 1; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println("|--" + f.getName());
    }

}

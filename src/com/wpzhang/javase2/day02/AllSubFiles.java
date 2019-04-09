/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase2.day02;

import org.junit.Test;

import java.io.*;

/**
 * @program: Wpzhang
 * @description: TODO 获取子目录及其内容 如何实现换行？在哪个循环中换行
 * @author: wpzhang
 * @create: 2019-04-08 18:53
 **/
public class AllSubFiles {
    public static void main(String[] args) {
     File src = new File("E:/壁纸");
     printName(src);
    }

    private static void printName(File f) {
        String fs = f.toString();
        System.out.println(fs.substring(fs.indexOf("\\")+1));
        if (fs == "\\"){
            System.out.println();
        }
            //递归获取子目录
            if (!f.exists()){
                System.out.println("文件不存在");
                return;
            }else if (f.isDirectory()){
                for (File subs :f.listFiles()){
                    printName(subs);
//                    String fs2 = subs.toString();

                }
            }

    }

}
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
 * @description: 文件的剪切
 * @author: wpzhang
 * @create: 2019-04-08 16:13
 **/
/*
使用FileInputStream类和FileOutputStream类实现文件剪切
 */
public class CutFile {
    /**
     * @return
     * @Param
     * @description 文件复制方法
     * @date 2019/4/8 17:06
     */

    private static void copyFile(File src, File dest) {
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            byte[] bts = new byte[10];
            int len = 0;
            while (-1 != (len = fis.read(bts))) {
                fos.write(bts, 0, len);
            }
            fos.flush();
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件读取失败");
        } catch (IOException e) {
            System.out.println("文件读写失败");
        }
    }

    /**
     * @return
     * @Param
     * @description 文件的剪切方法
     * @date 2019/4/8 17:06
     */

    private static void cutFile(File src, File dest) {
        copyFile(src, dest);
        src.delete();
    }

    public static void main(String[] args) {
        File src = new File("E:/壁纸/123.txt");
        File dest = new File("E:/壁纸/123副本.txt");
        cutFile(src, dest);
    }

}
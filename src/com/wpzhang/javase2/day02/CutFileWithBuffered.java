/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase2.day02;

import java.io.*;

/**
 * @program: Wpzhang
 * @description: 缓冲流剪切文件
 * @author: wpzhang
 * @create: 2019-04-08 17:10
 **/
public class CutFileWithBuffered {
    /*
 使用缓冲流的方式剪切文件
  */
    private static void copyFile(File src, File dest) {
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            //缓冲流进行包装
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] bts = new byte[10];
            int len = 0;
            while (-1 != (len = bis.read(bts))) {
                bos.write(bts, 0, len);
            }
            bos.flush();
            bos.close();
            bis.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("文件读写失败");
        }
    }

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
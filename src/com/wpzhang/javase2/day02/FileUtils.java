/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day02;

import java.io.*;

/**
 * @program: Wpzhang
 * @description: 文件的拷贝
 * @author: wpzhang
 * @create: 2019-04-09 16:43
 **/
public class FileUtils {
    public void CopyFiles(String srcPath, String destPath) {
        CopyFiles(new File(srcPath), new File(destPath));
    }

    public static void CopyFiles(File src, File dest) {
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
            System.out.println("文件读入失败");
        } catch (IOException e) {
            System.out.println("文件读入失败");
        }
    }

    public static void main(String[] args) {
        File src = new File("E:/壁纸/123.txt");
        File dest = new File("E:/壁纸/123副本.txt");
        CopyFiles(src,dest);
    }
}
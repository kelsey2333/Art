/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase1.day07;

import java.io.File;
import java.io.FileFilter;

/**
 * @program: Wpzhang
 * @description: 递归输出子目录
 * @author: wpzhang
 * @create: 2019-04-08 14:51
 **/
public class ListSubFiles {
    public static void main(String[] args) {
        File src = new File("E:\\壁纸");
        printName(src);
    }
    private static void printName(File f) {
        System.out.println(f);
        if (!f.exists()){
            System.out.println("文件不存在");
            return;
        }else if (f.isDirectory()){
            File[] subs = f.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            });
            for (File myFiles:subs){
                printName(myFiles);
            }
        }
    }
}
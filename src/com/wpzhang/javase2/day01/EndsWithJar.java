/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase2.day01;

import java.io.File;
import java.io.FileFilter;

/**
 * @program: Wpzhang
 * @description: 输出以jar结尾的文件及其子目录
 * @author: wpzhang
 * @create: 2019-04-08 15:10
 **/
public class EndsWithJar {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\Administrator\\IdeaProjects\\Wpzhang\\src\\com\\wpzhang\\javase2");
        printName(src);
    }

    private static void printName(File f) {
        String fs = f.toString();
        System.out.println(fs.substring(fs.lastIndexOf("\\")+1));
        if (!f.exists()) {
            System.out.println("该文件不存在");
            return;
        } else if (f.isDirectory()) {
            File[] subs = f.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            });
            for (File myFiles : subs) {
                printName(myFiles);
            }
        }
    }
}
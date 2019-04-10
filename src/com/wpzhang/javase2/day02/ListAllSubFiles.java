/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day02;

import java.io.File;

/**
 * @program: Wpzhang
 * @description: 按级数打印子目录
 * @author: wpzhang
 * @create: 2019-04-09 19:59
 **/
public class ListAllSubFiles {
    /*
    任何一个file文件：
       -先分析级数：打印空格（1级1个空格，2级2个空格，3级3个空格，用循环）
       -打印file名字,暂且不管file是目录还是文件
       -若file是目录，则递归打印子目录
     */
    public static void printFiles(File file , int level){
        //循环打印空格
        for (int i = 1;i < level;i++){
            System.out.print("    ");
        }
        //打印file名字
        System.out.println(file.getName());
        //若file是目录，递归打印子目录
        if (!file.exists()){
            System.out.println("该资源文件不存在");
        }else if (file.isDirectory()){
            for (File subs:file.listFiles()){
                printFiles(subs,level+1);
            }
        }

    }

    public static void main(String[] args) {
        File src = new File("E:/壁纸");
        printFiles(src,1);
    }
}
/**
 * @Author wpzhang
 * @Date 2019/4/4
 * @Description
 */
package com.wpzhang.javase1.Day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: Wpzhang
 * @description: 删除目录
 * @author: wpzhang
 * @create: 2019-04-04 05:53
 **/
public class DeleteDirectory {
    /**
     * 删除空目录
     * dir 将要删除的目录路径
     */
    private static void DeleteEmptyDir(String dir) {
        boolean success = (new File(dir)).delete();
        if (success) {
            System.out.println("删除成功: " + dir);
        } else {
            System.out.println("删除失败: " + dir);
        }
    }

    /**
     * 删除目录下的所有文件及子目录下所有文件
     *  dir 将要删除的文件目录
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            //list转数组
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
    /**
     *测试
     */
    public static void main(String[] args) throws IOException {

        boolean success = deleteDir(new File("demo/a"));
        if (success) {
            System.out.println("删除成功 " );
        } else {
            System.out.println("删除失败" );
        }
    }
}
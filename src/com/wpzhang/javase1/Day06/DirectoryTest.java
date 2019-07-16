/**
 * @Author wpzhang
 * @Date 2019/4/4
 * @Description
 */
package com.wpzhang.javase1.Day06;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @program: Wpzhang
 * @description: 多级目录
 * @author: wpzhang
 * @create: 2019-04-04 05:10
 **/
public class DirectoryTest {
    @Test
    public void  testDirectory() throws FileNotFoundException {
        File file = new File("demo/a/b/c");
        if (file.mkdirs()){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }
        RandomAccessFile word = new RandomAccessFile("abcde","rw");

    }


    /**
     * @Param
     * @description 目录测试
     * @date 2019/4/4 11:49
     * @return  void
     */
    @Test
    public void dirTest(){
        //当前目录
        File file = new File(".");
        //上一级目录
//        File file = new File("..");
        //上上级目录
//        File file = new File("../../")
        //根目录
//        File file = new File("/");
        //getAbsolutePath:获取描述资源的绝对路径
        //获取当前目录下的所有子文件和文件夹
        //listFiles()方法，返回文件夹下所有的子项
        File[] subFiles = file.listFiles();
        for (File sub : subFiles){
            System.out.println(sub);
        }
    }
    /**
     * @Param
     * @description listFiles()方法的重写:对子项的筛选
     * @date 2019/4/4 11:58
     * @return  void
     */
    File file = new File(".");
    File[] subFiles =file.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    })  ;


}
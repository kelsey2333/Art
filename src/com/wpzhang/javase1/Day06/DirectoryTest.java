/**
 * @Author wpzhang
 * @Date 2019/4/4
 * @Description
 */
package com.wpzhang.javase1.Day06;

import org.junit.Test;

import java.io.File;
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
}
/**
 * @Author wpzhang
 * @Date 2019/4/4
 * @Description
 */
package com.wpzhang.javase1.Day06;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: Wpzhang
 * @description: 获取文件字节数
 * @author: wpzhang
 * @create: 2019-04-04 11:14
 **/
public class FileLength {
    @Test
    public void test() throws IOException {
        File file = new File("demo/a/b/c.txt");
        RandomAccessFile r = new RandomAccessFile(file,"rw");
        byte[] buf = "abcdefg134".getBytes();
        r.write(buf);
        int length = r.read(buf);
        System.out.println("实际读取的长度为："+length);
        r.close();

    }
}
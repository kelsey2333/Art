/**
 * @Author wpzhang
 * @Date 2019/4/9
 * @Description
 */
package com.wpzhang.javase2.day02;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: Wpzhang
 * @description: 文件内容平均分配到两个文件中
 * @author: wpzhang
 * @create: 2019-04-09 06:24
 **/
public class EverageCut {
    @Test
    public void test() {
        //创建文件
        File src = new File("E:/壁纸/a.txt");
        RandomAccessFile raf;
        {
            try {
                raf = new RandomAccessFile(src, "rw");
                byte[] bts = "12345678900987654321".getBytes();
                raf.write(bts, 0, bts.length);
                raf.close();
            } catch (FileNotFoundException e) {
                System.out.println("文件不存在");
            } catch (IOException e) {
                System.out.println("文件写出错误");
            }
        }
    }

    File dest = new File("E:/壁纸/b.txt");
    RandomAccessFile destRaf;

    {
        try {
            destRaf = new RandomAccessFile(dest, "rw");
            byte[] bts = "12345678900987654321".getBytes();
            destRaf.write(bts, 0, (bts.length) / 2);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("文件写出错误");
        }
    }


    File dest2 = new File("E:/壁纸/c.txt");
    RandomAccessFile destRaf2;

    {
        try {
            destRaf2 = new RandomAccessFile(dest2, "rw");
            byte[] bts = "12345678900987654321".getBytes();
            destRaf2.write(bts, 10, (bts.length) / 2);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("文件写出错误");
        }
    }
}
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
 * @description:
 * @author: wpzhang
 * @create: 2019-04-04 05:20
 **/
public class RandomAcessFileTest {
@Test
    public void testRaf() throws IOException {
        RandomAccessFile r = new RandomAccessFile("demo/nice.txt","rw");
        byte[] raf = "ABCDEFGHIJKLM".getBytes();
        r.write(raf,4,7);
        r.close();
    }
}
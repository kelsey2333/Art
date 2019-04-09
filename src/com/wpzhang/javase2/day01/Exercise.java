/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase2.day01;

        import org.junit.Test;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.RandomAccessFile;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-08 15:28
 **/
public class Exercise {
    @Test
    public void test() throws IOException {
        File src = new File("E:/壁纸/raf.dat");
        RandomAccessFile raf = new RandomAccessFile(src, "rw");
        byte[] bts = "Welcome,NEWYORK".getBytes();
        raf.write(bts, 0, bts.length);
        RandomAccessFile raf2 = new RandomAccessFile("E:/壁纸/raf.dat", "r");
        raf2.skipBytes(8);
        byte[] buf = new byte[7];
        raf2.read(buf);
        System.out.println(new String(buf));
        raf2.close();
        raf.close();
    }

}
/**
 * @Author wpzhang
 * @Date 2019/4/3
 * @Description
 */
package com.wpzhang.javase1.Day06;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-03 20:23
 **/
public class RefTest {
    /**
     * 随机访问文件类RandomAccessFile:
     *      - 提供了随机对文件内容进行读写的方式
     *          - void write(int i); : 将整形值的低8位写出到文件
     *          - int read(); 读取当前指针位置指向的字节, 将该字节读取, 并保存到int型的第八位返回
     *              - 读取完成之后, 指针向后移动一位, 未下一次读取准备, 如果读到了文件结尾, 返回值为-1
     *
     *          - 写多个字节
     *              - write(byte[] buf);
     *              - write(byte[] buf, int offset, int length);
     *
     *              - int read(byte[] buf): 一次性尝试读取bbuf字节数组长度个字节,
     *                  - 将实际读取的字节数作为方法的返回值
     */

    @Test
    public void testWrite() throws IOException {
        // 创建RandomAccessFile对象
        // RandomAccessFile(File file, String mode)
        // RandomAccessFile(String filepath, String mode)

        File file = new File("demo/raf.txt"); // java12/demo/rad.txt

        /*// 如果文件不存在
        if (!file.exists()) {
            // 创建该文件
            file.createNewFile();
        }*/

        /**
         * 创建读写文件操作类
         *  如果文件不存在, 会自动创建文件, 只在当前的位置上去写内容, 进行覆盖, 其他内容不变
         */

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        // 写入文件内容
        raf.write(66); // 空格
        raf.write(67); // 指针向后移动一位

        // 关闭文件操作类, 释放资源
        raf.close();
    }

    @Test
    public void testRead() throws IOException {
        // 创建RandomAccessFile对象
        File file = new File("demo/raf.txt"); // java12/demo/rad.txt

        RandomAccessFile raf = new RandomAccessFile(file, "r");
        // 读取文件内容
        int cont1 = raf.read(); // 指针向后移动一位
        System.out.println(cont1);
        int cont2 = raf.read();
        System.out.println(cont2);
        int cont3 = raf.read();
        System.out.println(cont3); // 返回-1, 表示文件读取结束
        // 关闭文件操作类, 释放资源
        raf.close();
    }

    @Test
    public void writeTest2() throws Exception {
        /**
         * 一次性写出多个字节
         */
        RandomAccessFile raf = new RandomAccessFile("demo/raf.txt", "rw");

        // 创建字节数组, 将写出的内容保存呢到字节数组中
        byte[] buf = "asdasdjava12".getBytes(); // 将字符串转换成字节数组

//        raf.write(buf); //
        raf.write(buf, 5, 6); //

        raf.close();
    }

    @Test
    public void readTest2() throws Exception {
        /**
         * 一次性读多个字节
         */
        RandomAccessFile raf = new RandomAccessFile("demo/raf.txt", "r");

        // 创建字节数组, 将写出的内容保存呢到字节数组中
        byte[] buf = new byte[10];

        int length = raf.read(buf);

        System.out.println("实际读取的字节长度:" + length);

        // 将读取到的字节内容转换成字符串
        String str = new String(buf, 0, length);
        System.out.println(str);

        raf.close();
    }

    @Test
    public void testPointerPos() throws Exception {
        /**
         * 测试获取文件指针的位置
         *      long getFilePointer();
         */
        RandomAccessFile raf =
                new RandomAccessFile("demo/raf.txt", "rw");

        // 获取当前指针指向的位置
        System.out.println("初始指针位置: " + raf.getFilePointer());

        raf.write(1);

        System.out.println("写入内容后指针位置: " + raf.getFilePointer());

        raf.writeInt(10);
        System.out.println("写入内容后指针位置: " + raf.getFilePointer());

    }
}

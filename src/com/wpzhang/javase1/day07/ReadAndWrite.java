/**
 * @Author wpzhang
 * @Date 2019/4/7
 * @Description
 */
package com.wpzhang.javase1.day07;

import org.junit.Test;

import java.io.*;

/**
 * @program: Wpzhang
 * @description: 读取文件
 * @author: wpzhang
 * @create: 2019-04-07 13:04
 **/
/*
  -建立联系
  -选择流：文件输入流：inputStream   FileInputStream
  -操作(大小):byte[] r = new byte[1024]+read+读取的大小
  -释放资源（关闭）
 */
public class ReadAndWrite {
    @Test
    public void test1() throws Exception {
        //-建立联系 File 对象 源地
        String path = "E://壁纸//123.txt";
        File src = new File(path);
        //-选择流:只要与外面存在联系就会存在异常，抛出异常
        InputStream is = new FileInputStream(src);
        //-操作不断读取：缓冲数组，一次性读多少个字节
        byte[] words = new byte[10];
        //实际读取的大小，最后一次可能读一两个
        int len = 0;
        //循环读取:实际读取的个数不等于-1就循环读取，直到读取个数为-1（为空）
        while (-1 != (len = is.read(words))) {
            //输出：要求字节数组转换为字符串String(byte[],int OffSet,int length)
            String str = new String(words, 0, len);
            System.out.println(str);
        }
        //-释放资源（关闭）
        is.close();
    }

    /**
     * @return
     * @Param
     * @description 写出文件
     * @date 2019/4/7 13:58
     */
    @Test
    public void test2() throws IOException {
        //-建立联系  File对象，目的地
        //-选择流：outputStream  FileOutputStream
        //-操作：write+flush
        //-释放资源（关闭）


        //-建立联系
        String path = "E://壁纸//345.txt";
        File src = new File(path);
        //-选择流：追加文件
        OutputStream os = new FileOutputStream(src, true);
        String str = "I am happy\r\n";
        //写出去的时候要字符串转为字节数组;且与外界产生联系，抛出异常
        os.write(str.getBytes(), 0, str.getBytes().length);
        os.close();
    }
}
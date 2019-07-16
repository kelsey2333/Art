/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase1.day07;

import java.io.*;

/**
 * @program: Wpzhang
 * @description: 文件复制方法的封装
 * @author: wpzhang
 * @create: 2019-04-08 06:16
 **/
public class CopyFiles {
    public static void main(String[] args) throws IOException {
        File srcPath = new File("E:/壁纸/123.txt");
        File destPath = new File("E:/壁纸/123副本.txt");
        CopyFiles(srcPath,destPath);
    }

    public  void CopyFiles(String srcPath, String destPath) throws IOException {
        //建立联系:源地+目的地（可以存在可以不存在）
        CopyFiles(new File(srcPath), new File(destPath));
    }

    /**
     * @return
     * @Param
     * @description 文件的拷贝
     * @Param 源文件的File对象
     * @Param目标文件的File对象
     * @date 2019/4/8 6:25
     */

    //对File对象进行重载,此时建立联系在外部进行建立
    public static void CopyFiles(File src, File dest) throws IOException {
        //选择流
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);
        //操作：循环读，写出
        byte[] bts = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(bts))) {
            os.write(bts, 0, len);
        }
        //强制刷出
        os.flush();
        //关闭
        os.close();
        is.close();
    }
}

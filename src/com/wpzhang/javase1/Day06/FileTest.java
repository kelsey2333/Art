/**
 * @Author wpzhang
 * @Date 2019/4/3
 * @Description
 */
package com.wpzhang.javase1.Day06;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: Wpzhang
 * @description:文件目录测试
 * @author: wpzhang
 * @create: 2019-04-03 15:53
 **/
public class FileTest {
    @Test
    public void testFile() {
        File file = new File("demo" + File.separator + "nice.txt");
        System.out.println(file);
    }

    /**
     * @return
     * @Param
     * @description 判断File文件描述的路径字符串对应的资源文件是否存在
     * @date 2019/4/3 15:58
     */
    @Test
    public void existTest() {
        File file = new File("demo" + File.separator + "nice.txt");
        if (file.exists()) {
            System.out.println("资源文件存在");
        } else {
            System.out.println("资源文件不存在");
        }
    }

    /**
     * @return void
     * @Param
     * @description 判断file描述的资源文件是 目录还是文件
     * @date 2019/4/3 16:03
     */
    @Test
    public void isFile() {
        File file = new File("demo" + File.separator + "nice.txt");
        if (file.isFile()) {
            System.out.println("该资源文件是文件");
        } else {
            System.out.println("该资源文件不是文件或者不存在");
        }
    }

    @Test
    public void isDirectory() {
        File file = new File("demo" + File.separator + "nice.txt");
        if (file.isDirectory()) {
            System.out.println("该资源文件是一个目录");
        } else {
            System.out.println("该资源文件不是目录或者不存在");
        }
    }

    /**
     * @return void
     * @Param
     * @description 创建目录或者文件
     * @date 2019/4/3 16:11
     */
    @Test
    public void creatFile() throws IOException {
        /*
        --当第一次创建已经创建成功以后，第二次再运行程序进行创建时会创建失败
        --当创建的文件所在的目录不存在时，会抛出异常IOexception
         */
        File file = new File("demo/nice.txt");
        if (!file.exists()) {
            boolean isSucc = file.createNewFile();
            if (isSucc) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件创建失败");
            }
        }
    }

    /**
     * @return void
     * @Param
     * @description 创建目录
     *
     * 多级目录 mkdirs
     * @date 2019/4/3 16:15
     */
    @Test
    public void creatDir() {
        File file = new File("demo/NICE");
        if (!file.exists()) {
            boolean isSucc = file.mkdir();
            if (isSucc) {
                System.out.println("目录创建成功");
            } else {
                System.out.println("目录创建失败");
            }
        }
    }
    @Test
    public void size(){
        FileInputStream fis = null;
        try {
            File file = new File("demo/nice.txt");
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }finally {
            if (null != fis){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                finally { }
            }
        }
    }
    @Test
    public void fileLength(){
        /*
        通过file描述的文件，获取该文件所占的字节数的大小
        - length
         */
        File file = new File("demo/hello.txt");
        System.out.println(file.length());
    }
}
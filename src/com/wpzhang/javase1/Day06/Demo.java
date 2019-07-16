/**
 * @Author wpzhang
 * @Date 2019/4/7
 * @Description
 */
package com.wpzhang.javase1.Day06;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * @program: Wpzhang
 * @description: 绝对路径和相对路径创建文件
 * @author: wpzhang
 * @create: 2019-04-07 09:14
 **/
public class Demo  {
    @Test
    public void test() {
        String parentPath = "E://壁纸";
        String name = "myDesktop.jpg";
        //相对路径构造器1
        File src = new File(parentPath, name);
        src = new File(new File(parentPath), name);
        //输出
        System.out.println(src.getPath());
        System.out.println(src.getName());
        //相对路径构造器2
        File src2 = new File("E://壁纸", "myDesktop.jpg");
        System.out.println(src2.getPath());
        System.out.println(src2.getName());

    }

    /**
     * @return void
     * @Param
     * @description 判断文件是否存在
     * @date 2019/4/7 10:23
     */
    @Test
    public void test2() {
        //路径合法所以存在
        String path = "E://壁纸//myDesktop.jpg";
        File src = new File(path);
        System.out.println("文件是否存在：" + src.exists());
        //判断是文件还是文件夹
        if (src.isFile()) {
            System.out.println("文件");
        } else {
            System.out.println("非文件或者文件不存在");
        }
        if (src.isDirectory()) {
            System.out.println("文件夹");
        } else {
            System.out.println("非文件夹或者文件夹不存在");
        }
    }

    /**
     * @return void
     * @Param
     * @description 输出根目录:静态的方法，不能用对象代用，要用类调用
     * @date 2019/4/7 12:09
     */
    @Test
    public void roots() {
        String path = "E://壁纸";
        File src = new File(path);
        File[] root = File.listRoots();
        System.out.println(Arrays.toString(root));
    }
}
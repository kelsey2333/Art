/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase2.day02;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Wpzhang
 * @description:对象序列化：序列化到.obj文件里，只要创建.obj文件就会产生，不用管它是否存在
 * @author: wpzhang
 * @create: 2019-04-08 18:08
 **/
public class EmpList {
    @Test
    public void test() {
        List<Emp> e = new ArrayList<Emp>();
        e.add(new Emp("kelsey", 23, "girl", 4000));
        e.add(new Emp("you", 18, "girl", 3000));
        e.add(new Emp("she", 19, "girl", 3500));
        System.out.println(e);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:/壁纸/a.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(e);
            System.out.println("序列化完毕");
            oos.close();
            fos.close();
        } catch (FileNotFoundException e1) {
            System.out.println("文件不存在");
        } catch (IOException e1) {
            System.out.println("文件写出错误");
        }
    }
}
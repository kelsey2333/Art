/**
 * @Author wpzhang
 * @Date 2019/4/8
 * @Description
 */
package com.wpzhang.javase2.day02;

import org.junit.Test;

import java.io.*;

/**
 * @program: Wpzhang
 * @description: Emp对象的序列化
 * @author: wpzhang
 * @create: 2019-04-08 17:40
 **/
public class Serializable {
    @Test
    public void test() {
        try {
            FileOutputStream fos = new FileOutputStream("emp.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Emp emp = new Emp("kelsey", 23, "girl", 4000);
            oos.writeObject(emp);
            System.out.println("序列化完毕");
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("未找到该文件");
        } catch (IOException e) {
            System.out.println("写出失败");
        }
    }
}
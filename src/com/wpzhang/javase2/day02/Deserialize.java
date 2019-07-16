/**
 * @Author wpzhang
 * @Date 2019/4/10
 * @Description
 */
package com.wpzhang.javase2.day02;

import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @program: Wpzhang
 * @description: 反序列化
 * @author: wpzhang
 * @create: 2019-04-10 19:35
 **/
public class Deserialize {
    @Test
    public void test(){
        try {
            FileInputStream fis = new FileInputStream("emp.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Emp newEmp = (Emp)ois.readObject();
            System.out.println("反序列化成功");
            System.out.println(newEmp);
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
        } catch (IOException e) {
            System.out.println("包装文件字符流失败");
        } catch (ClassNotFoundException e) {
            System.out.println("读取失败");
        }
    }
}
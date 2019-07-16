/**
 * @Author wpzhang
 * @Date 2019/5/30
 * @Description
 */
package com.wpzhang.javase1.Map;
import java.util.*;
/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-05-30 06:29
 **/
public class ArrayList {
        public static void main(String[] args) {
            List<String> list=new java.util.ArrayList<String>();
            list.add("Hello");
            list.add("Java");
            list.add("ArrayList");
            //方法一：使用for或foreach遍历
            for (String str : list) {
                System.out.println("增强for循环结果：" + str);
            }

            //方法二：将集合转化为数组，然后进行for或foreach遍历
            String[] strArray=new String[list.size()];
            list.toArray(strArray);
            for(int i=0;i<strArray.length;i++)
            {
                System.out.println("集合转成数组，普通for循环结果：" + strArray[i]);
            }

            //方法三：使用迭代器器
            Iterator<String> iterator=list.iterator();
            while(iterator.hasNext())//判断下一个元素之后有值
            {
                System.out.println("迭代器遍历结果: " + iterator.next());
            }
        }
    }

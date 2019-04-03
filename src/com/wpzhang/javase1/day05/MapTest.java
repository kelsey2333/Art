/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day05;

//import com.wpzhang.oop.day04.User;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: Wpzhang
 * @description: Put方法
 * @author: wpzhang
 * @create: 2019-04-02 19:33
 **/
public class MapTest {
    @Test
    public void testPut() {
        java.util.Map<String, User> users = new HashMap<String, User>();
        //向map中添加元素：元素包括key value
        users.put("YOU", new User(23));
        users.put("ME", new User(24));
        users.put("HE", new User(25));
        users.put("SHE", new User(27));
        System.out.println(users);
        //取出map中的元素
        User letters = users.get("b");
        System.out.println(letters);
        //判断map中是否包含指定的key值：用containsKey方法
        System.out.println(users.containsKey("c"));
    }
        /**
         * @Param
         * @description 测试keySet
         * @date 2019/4/2 20:14
         * @return void
         */
        @Test
        public void keySet(){
          Map<String , User> users = new HashMap<String,User>();
          //这里离给map接口定义的集合中添加元素get相当于add
          users.put("YOU",new User(24));
          users.put("ME",new User(29));
          users.put("HE",new User(28));
          users.put("SHE",new User(25));
          //获取map中所有的key值
            Set<String> keys = users.keySet();
            //遍历keys集合
            for (String key:keys){
                System.out.println(key);
            }
        }
        /**
         * @Param
         * @description 遍历map中的所有key值
         * @date2019/4/2 20:24
         * @return  void
         */
        public void entrySet(){
            Map<String , User> users = new HashMap<String, User>();
            users.put("YOU",new User(26));
            users.put("ME",new User(25));
            users.put("HE ",new User(24));
            users.put("SHE",new User(23));

        }

}
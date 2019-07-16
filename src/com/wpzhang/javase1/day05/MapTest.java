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
    /**
     * @return void
     * @Param
     * @descriptionMap查找表
     * @date 2019/4/2 20:14
     */

    @Test
    public void testMap() {
        Map<String, User> users = new HashMap<String, User>();
        users.put("YOU", new User(26));
        users.put("ME", new User(25));
        users.put("HE ", new User(24));
        users.put("SHE", new User(23));

        System.out.println(users);
        //取出map集合中的元素
        //V get(Object key)
        User me = users.get("ME");
        System.out.println(me);
        if (users.containsKey("HE")) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }
    }

    /**
     * @return void
     * @Param
     * @description map集合遍历  keySet()
     * @date 2019/4/3 15:12
     */
    @Test
    public void keySet() {
        Map<String, User> users = new HashMap<String, User>();
        users.put("YOU", new User(26));
        users.put("ME", new User(25));
        users.put("HE ", new User(24));
        users.put("SHE", new User(23));
        Set<String> keys = users.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }

    /**
     * @return void
     * @Param
     * @description 遍历map集合   entrySet()
     * @date 2019/4/3 15:22
     */
    @Test
    public void entrySet() {
        Map<String, User> users = new HashMap<String, User>();
        users.put("YOU", new User(26));
        users.put("ME", new User(25));
        users.put("HE ", new User(24));
        users.put("SHE", new User(23));
        Set<Map.Entry<String,User>> entrySet = users.entrySet();
        for (Map.Entry<String,User>entry:entrySet){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * @return
     * @Param
     * @description 遍历key和Value值
     * @date 2019/4/3 15:49
     */

    @Test
    public void value() {
        Map<String, User> users = new HashMap<String, User>();
        users.put("YOU", new User(26));
        users.put("ME", new User(25));
        users.put("HE ", new User(24));
        users.put("SHE", new User(23));
        //遍历String类型的key值
        Set<String>key = users.keySet();
        for (String keys:key){
            System.out.println(keys);
        }
        //遍历Entry集合
        Set<Map.Entry<String,User>>entrySet = users.entrySet();
        for (Map.Entry<String,User>entry:entrySet){
            System.out.println(entry);
        }

    }

}
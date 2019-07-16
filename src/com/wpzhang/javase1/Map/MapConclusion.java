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
 * @create: 2019-05-30 06:39
 **/
public class MapConclusion {
        public static void main(String[] args) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("1", "Hello");
            map.put("2", "Java");
            map.put("3", "Map");

            //方法一：先通过Map.keySet遍历key，再通过key获取value值
            for (String key : map.keySet()) {
                System.out.println("key= "+ key + " and value= " + map.get(key));
            }

            //方法二：通过Map.entrySet使用iterator遍历键值对对象，再通过getKey()和getValue()获取key和value的值
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            }

            //方法三：通过Map.entrySet遍历key和value
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            }

            //方法四：通过Map.values()遍历所有的value，但不能遍历key
            for (String value : map.values()) {
                System.out.println("value= " + value);
            }
        }
    }

/**
 * @Author wpzhang
 * @Date 2019/4/16
 * @Description
 */
package com.wpzhang.javase1.Day06;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Wpzhang
 * @description: 重复字母
 * @author: wpzhang
 * @create: 2019-04-16 11:42
 **/
public class RepetitiveWordsDemo {
    public static void main(String[] args) {
        String str = "good good study,day day up！";
        str = str.replaceAll("[^a-zA-Z]+", "");
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(map);
    }
}
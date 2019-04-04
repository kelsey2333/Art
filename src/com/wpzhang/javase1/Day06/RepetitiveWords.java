/**
 * @Author wpzhang
 * @Date 2019/4/3
 * @Description
 */
package com.wpzhang.javase1.Day06;

import org.junit.Test;

import java.util.*;

/**
 * @program: Wpzhang
 * @description: 重复单词的个数
 * @author: wpzhang
 * @create: 2019-04-03 19:00
 **/
public class RepetitiveWords {
    @Test
    public void testEntry() {
        String str = "I I I am am a a girl";
        //转为单词数组
        String[] words = str.split(" ");
        System.out.println(Arrays.toString(words));
        //数组转queue
        Queue<String> queue = new LinkedList<String>();
        for (String word : words) {
            queue.offer(word);
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        while (queue.size() > 0) {
            //取出首元素。并删除
            String key = queue.poll();
            //如果不包含key,则装入key;并计数为1
            if (!map.containsKey(key)) {
                //返回1
                map.put(key, 1);
            } else {
                //如果已经包含该key则value增加
                map.put(key, map.get(key) + 1);
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> value : entrySet) {
            System.out.println(value.getKey() + "的重复次数为:" + value.getValue());
        }
    }

    /**
     * @return void
     * @Param
     * @description 迭代key的方式遍历集合
     * @date 2019/4/4 9:44
     */
    @Test
    public void testKey() {
        String str = "I I I like like running";
        String[] words = str.split(" ");
        System.out.println(Arrays.toString(words));
        //增强for循环遍历数组，将数组中的元素添加到队列中
        Queue<String> queue = new LinkedList<String>();
        for (String word : words) {
            queue.offer(word);
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        while (queue.size() > 0) {
            String key = queue.poll();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                //获取map中的Value值并加1
                map.put(key, map.get(key) + 1);
            }
        }
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + "的重复次数为：" + map.get(key));
        }

    }
}
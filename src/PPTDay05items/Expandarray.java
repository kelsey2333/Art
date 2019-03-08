/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package PPTDay05items;

import java.util.Arrays;

/**
 * @program: Wpzhang day04
 * @description: 数组扩容
 * @author: wpzhang
 * @create: 2019-03-07 16:17
 **/
public class Expandarray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 65, 67, 65,};
        arr = Arrays.copyOf(arr, arr.length + 1);//扩展后的数组长度总比原先数组长度长一个元素
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }
    }


}
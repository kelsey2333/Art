/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package PPTDay05items;

/**
 * @program: Wpzhang day04
 * @description: 最大值放在最后一个位置
 * @author: wpzhang
 * @create: 2019-03-07 16:36
 **/
public class Maxnumsetlast {
    public static void main(String[] args) {
        //随机产生数组长度
        int j =(int)(Math.random()*6+5);
        int[] arr = new int[j];
        // 对数组元素进行随机赋值

        for (int index= 0;index<arr.length;index++){
            arr[index]=(int)(Math.random()*20);
        }
        // 找出数组最大值
        for (int i=1;i<arr.length;i++) {
            if (arr[i-1]>arr[i]){
                int temp =arr[i-1];
                arr[i-1]= arr[i];
                arr[i]= temp;
            }
        }
        for (int index= 0;index<arr.length;index++){
            System.out.println(arr[index]);
        }
    }
}
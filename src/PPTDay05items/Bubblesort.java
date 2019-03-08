/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package PPTDay05items;

/**
 * @program: Wpzhang day04
 * @description: 冒泡排序
 * @author: wpzhang
 * @create: 2019-03-07 19:05
 **/
public class Bubblesort {
    public static void main(String[] args) {
        int[] arr =new int[]{ 32, 58, 38, 48, 43, 60, 13, 34, 20, 47, 87, 20 };
        //用for循环嵌套实现冒泡排序
        for (int j =11;j>0;j--){
            for (int i = 1;i <=j;i++){
                if (arr[i-1]>arr[i]){
                    int temp = arr[i-1];
                    arr[i-1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        for (int index =0;index <arr.length;index++ ){
            System.out.println(arr[index]);
        }
    }
}
/**
 * @Author wpzhang
 * @Date 2019/3/8
 * @Description
 */
package pptitemsday06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-08 19:06
 **/
public class Review {
//    public static void sayhi(String name){}
//
//    public static void main(String[] args) {
//        sayhi("章吴萍");
//
//    }
    public static int MAX1(int a,int b){

         int maxval = a>b?a:b;
        return maxval;
    }

    public static void main(String[] args) {
        int MAXVAL = MAX1(2,9);
        System.out.println(MAXVAL);
    }
public static int MAX2(int m,int n){//不可以多定义一个变量
    int maxvalue = (m>n?m:n);
    return maxvalue;
};

    public static void main2(String[] args) {
        int maxVAL=MAX2(3,9);
        System.out.println(maxVAL);
    }
public static int[] arr(int length,int range){
    int[] arr = new int[length];
    for (int i= 0;i<arr.length;i++) {
        arr[i]=(int) (Math.random() * (range+1));
    }
    return arr;

    }


}


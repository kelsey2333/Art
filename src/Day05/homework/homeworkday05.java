/**
 * @Author wpzhang
 * @Date 2019/3/7
 * @Description
 */
package Day05.homework;

import java.util.Scanner;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-03-07 20:23
 **/
public class homeworkday05 {
    public static void main(String[] args) {
        //接收用户输入的一个数
        Scanner scan = new Scanner(System.in);
        System.out.println("请你输入一个数：");
        int t = scan.nextInt();
        System.out.println(2);
        for (int i = 3;i<=t;i++){
            for (int p=0;p<=t/10;p += 10){
                System.out.println(i);
            }
        }

    }

}
/**
 * @Author wpzhang
 * @Date 2019/3/6
 * @Description
 */
package Day04;

/**
 * @program: Wpzhang day04
 * @description: 运行结果
 * @author: wpzhang
 * @create: 2019-03-06 19:40
 **/
public class nineplusnien {
    public static void main(String[] args) {
        long sum = 0;
        for (long i = 9; i <= 9999999999l; i = i * 10 + i) {
            sum += i;
        }
        System.out.println("9+99+999+...+9999999999" + "=" + sum);
    }
}
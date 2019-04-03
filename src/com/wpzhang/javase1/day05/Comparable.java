/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: Wpzhang
 * @description: Comparable方法重写前后
 * @author: wpzhang
 * @create: 2019-04-02 10:23
 **/
public class Comparable<E> {
    public void test(){
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(3,5));
        cells.add(new Cell(4,2));
        cells.add(new Cell(1,9));
//        Collections.sort();
    }
}
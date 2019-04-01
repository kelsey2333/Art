/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day04;

import com.wpzhang.oop.tetris.component.Cell;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-01 18:36
 **/
public class testRef {
    @Test
    public void testRef(){
        Collection<Cell2> cell2s = new ArrayList<Cell2>();
        Cell2 c0 = new Cell2(5,6);
        Cell2 c1 = new Cell2(7,9);
        cell2s.add(c0);
        cell2s.add(c1);
        System.out.println(c0 + "," + c1);
        System.out.println(cell2s);
        c0.drop();
        c1.drop();
        System.out.println(c0 + "," + c1);
        System.out.println(cell2s);

    }
}
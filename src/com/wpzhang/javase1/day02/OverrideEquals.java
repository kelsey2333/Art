/**
 * @Author wpzhang
 * @Date 2019/3/29
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Wpzhang
 * @description: 重写equals方法
 * @author: wpzhang
 * @create: 2019-03-29 15:50
 **/
public class OverrideEquals {
    int row;
    int col;

    public OverrideEquals(int row, int col) {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cell) {
            Cell cell = (Cell) obj;

            return cell.row == row && cell.col == col;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        OverrideEquals cell2 = new OverrideEquals(2, 4);
    }
}

/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Wpzhang
 * @description: 重写Equals
 * @author: wpzhang
 * @create: 2019-04-01 08:55
 **/

/**
 * @Param
 * @description 自反性和对称性（涉及空指针异常）
 * @date 2019/4/1 9:02
 * @return
 */

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if (person.getName() == null || name == null) {
                return false;
            } else {
                return name.equals(person.getName());
            }
        }
        return false;
    }

}
/**
 * @Author wpzhang
 * @Date 2019/4/1
 * @Description
 */
package com.wpzhang.javase1.day02;

import org.junit.Test;

/**
 * @program: Wpzhang
 * @description: equals传递性原则
 * @author: wpzhang
 * @create: 2019-04-01 09:45
 **/
public class Employee extends Person {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //继承父类重写其方法
    public Employee(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            return super.equals(obj) && e.getId() == id;
        } else {
            return super.equals(obj);
        }
    }
}

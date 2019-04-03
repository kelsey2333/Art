/**
 * @Author wpzhang
 * @Date 2019/4/2
 * @Description
 */
package com.wpzhang.javase1.day05;


import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @program: Wpzhang
 * @description:
 * @author: wpzhang
 * @create: 2019-04-02 19:13
 **/
public class Comparator {
    public void testConparator(){
        List<Emp> emp = new ArrayList<Emp>();
//        Emp emp = new Emp();
      Emp e1 = new Emp("Terry",25,"m",6000);
       Emp e2 = new Emp("Allen",21,"f",4000);
        Emp e3 = new Emp("Smith",23,"m",3000);

        emp.add(e1);
        emp.add(e2);
        emp.add(e3);

//        Collections.sort(emp);
    }

}
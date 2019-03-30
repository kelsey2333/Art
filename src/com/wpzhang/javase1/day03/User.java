/**
 * @Author wpzhang
 * @Date 2019/3/30
 * @Description
 */
package com.wpzhang.javase1.day03;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: Wpzhang
 * @description: SetGet方法
 * @author: wpzhang
 * @create: 2019-03-30 08:52
 **/
public class User {
    private String username;
    private String password;
    private String gender;
    private Date birthday;
    private String email;

    /**
     * @return
     * @Param
     * @description set get 方法
     * @date 2019/3/30 8:55
     */
    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @Param
     * @description 将生日日期格式化
     * @date 2019/3/30 9:51
     * @return
     */

    @Test
    public void testBirthday() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 1997);
        date.set(Calendar.MONTH, Calendar.JANUARY);
        date.set(Calendar.DATE, 5);
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatDate.format(date.getTime()));
    }
@Test
    public void testSetGet() {
        User user = new User();
        user.setUsername("章吴萍");
        System.out.println(user.getUsername());
        user.setGender("女");
        System.out.println(user.getGender());
        user.setEmail("2390547685@qq.com");
        System.out.println(user.getEmail());
        user.setPassword("************");
        System.out.println(user.getPassword());
    }
}
/**
 * @Author wpzhang
 * @Date 2019/6/11
 * @Description
 */
package com.itek.netctoss.service.impl;

import com.itek.netctoss.service.MenuService;
import dao.AdminDao;
import dao.Impl.AdminDaoImpl;
import domain.Menu;

import java.util.List;

/**
 * @program: netctoss
 * @description: 菜单业务接口实现类
 * @author: wpzhang
 * @create: 2019-06-11 18:49
 **/
public class MenuServiceImpl implements MenuService {
    @Override
    public List<Menu> SelectMenusByUserId(Integer userId) {
        AdminDao adminDao =  new AdminDaoImpl();
       List<Menu> menus =  adminDao.selectMenuById(userId);
       return menus;
    }
}
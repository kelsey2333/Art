/**
 * @Author wpzhang
 * @Date 2019/6/12
 * @Description
 */
package com.itek.netctoss.service.impl;

import com.itek.netctoss.service.AccountService;
import commons.Consts;
import dao.AccountDao;
import dao.Impl.AccountDaoImpl;
import domain.Account;

import java.util.List;

/**
 * @program: netctoss
 * @description: 账务账号接口实现类
 * @author: wpzhang
 * @create: 2019-06-12 08:43
 **/
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> selectAccountInfo(int pageNo, int pageSize, Account account) {
        AccountDao accountDao =  new AccountDaoImpl();
//       List<Account> accounts = accountDao.selectAll();
        List<Account> accounts = accountDao.selectAllByPage(pageNo,pageSize,account);
        return accounts;
    }

    @Override
    public int getAccountEndPage() {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getSelectCount()/ Consts.PAGE_SIZE + accountDao.getSelectCount()%Consts.PAGE_SIZE;
}
}
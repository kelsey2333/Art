package com.itek.netctoss.service;

import domain.Account;

import java.util.List;

public interface AccountService {
 List<Account> selectAccountInfo(int pageNo,int pageSize,Account account);
 int getAccountEndPage();
}

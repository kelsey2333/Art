package dao;

import domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> selectAll();
    List<Account> selectAllByPage(int pageNo ,int pageSize,Account account);
    int getSelectCount();
    int getFuzzyQueryCount(Account account);
}

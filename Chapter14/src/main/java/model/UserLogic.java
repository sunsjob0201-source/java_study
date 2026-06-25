package model;

import dao.AccountsDAO;

public class UserLogic {

    public boolean execute(Account account) {
        AccountsDAO dao = new AccountsDAO();
        return dao.create(account);
    }
}
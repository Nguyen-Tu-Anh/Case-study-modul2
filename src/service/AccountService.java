package service;

import config.ReadAndWriteFile;
import file.Path;
import model.Account;
import model.Movie;
import view.LoginView;

import java.util.List;

public class AccountService {
    public static Account account2 = new Account();
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    private final String PATH_ACC = Path.PATH + "account.txt";
    public List<Account> accounts = readAndWriteFile.readFromFile(PATH_ACC);
    LoginView viewLogin = new LoginView();

    public AccountService() {
    }

    public void addAccount(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName())) {
                String choice = viewLogin.AlertAccountExist();
                if (choice.equals("1")) {
                    addAccount(viewLogin.createAccount());
                    return;
                }
                return;
            }
        }
        accounts.add(account);
        readAndWriteFile.writeToFile(accounts, PATH_ACC);
    }

    public List<Account> findAll() {
        return accounts;
    }

    public boolean login(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName()) && acc.getPassWord().equals(account.getPassWord())) {
                account2 = account;
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(Account account) {
        if ("admin".equals(account.getUserName()) && "admin".equals(account.getPassWord())) {
            return true;
        }
        return false;
    }


}

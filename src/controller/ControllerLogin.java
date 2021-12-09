package controller;

import model.Account;
import service.AccountService;
import view.LoginView;

public class ControllerLogin {
    public static void menuLogin() {
        LoginView viewLogin = new LoginView();
        AccountService accountService = new AccountService();

        while (true) {
            int choice = viewLogin.menuLogin();
            switch (choice) {
                case 1:
                    Account account = viewLogin.createAccount();
                    if (accountService.loginAdmin(account)) {
                        ControllerMovie.menuManageAdmin();
                        break;
                    }
                    if (accountService.login(account)) {
                        viewLogin.signInSuccess();
                        ControllerPlayList.menuManageUser();
                        break;
                    } else {
                        viewLogin.AlertNoAccount();
                        ControllerLogin.menuLogin();
                    }
                    break;
                case 2:
                    accountService.addAccount(viewLogin.createAccount());
                    break;
            }
        }
    }
}
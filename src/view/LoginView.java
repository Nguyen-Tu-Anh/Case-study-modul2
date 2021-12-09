package view;

import model.Account;
import validate.ValidateString;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginView {

    public int menuLogin() {
        Scanner scanner = new Scanner(System.in);
        System.err.println("•๖ۣۜᑎETᖴᒪI᙭.ᑕOᗰッ");
        System.out.println("1. LOG IN");
        System.out.println("2. SIGN UP");

        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                }
            } catch (Exception e) {
                System.err.println("Press 1 or 2");
            }
        }
    }

    public Account createAccount() {
        System.out.println("Enter UserName");
        String userName = ValidateString.validate();
        System.out.println("Enter PassWord");
        String passWord = ValidateString.validate();
        return new Account(userName, passWord);
    }

    public String AlertAccountExist() {
        System.err.println("Account already exists!");
        System.err.println("Press 1 to  Try another username or Press 2 to Log in");
        return ValidateString.validate();
    }

    public void AlertNoAccount() {
        System.err.println("Account does not exist! Please Sign up");
    }

    public void signInSuccess() {
        System.out.println("︵✿LOGIN SUCCESS ✿");
    }
}

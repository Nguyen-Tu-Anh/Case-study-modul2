package validate;

import java.util.Scanner;

public class ValidateString {
    static Scanner scanner = new Scanner(System.in);

    public static String validate() {
        String name;
        while (true) {
            name = scanner.nextLine();
            if (name.trim().equals("")) {
                System.err.println("Can not be empty! Try again");
            } else {
                return name;
            }
        }
    }
}

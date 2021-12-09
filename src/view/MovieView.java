package view;

import config.ReadAndWriteFile;
import file.Path;
import model.Movie;
import service.MovieService;
import validate.ValidateString;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Scanner;

public class MovieView {
    Scanner scanner = new Scanner(System.in);


    public int menuAdmin() {
        System.out.println("                              ꧁༺༒༻꧂  ♠ WELCOME ADMIN ♠  ꧁༺༒༻꧂");
        System.out.println("");
        System.out.println("                    1. Display All Movie" + "                       5. Edit movie by name");
        System.out.println("                    2. Create move" + "                             6. Manage User");
        System.out.println("                    3. Sort move by name" + "                       0. Log out");
        System.out.println("                    4. Delete movie by name");
        System.err.println("ღEᑎTEᖇ ᑕᕼOIᑕEღ➻  ");
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 0) {
                    return choice;
                }
            } catch (Exception e) {
                System.err.println("Press 1 or 2");
            }
        }
    }

    public Movie createMovie() {
        System.out.println("Enter name: ");
        String name = ValidateString.validate();
        System.out.println("Enter producer name: ");
        String prodName = ValidateString.validate();
        return new Movie(name, prodName);
    }

    public String deleteMovie() {
        System.out.println("Enter movie name want to delete: ");
        return ValidateString.validate();
    }

    public String sureToDelete() {
        System.err.println("Are you sure? Press Y / N");
        return ValidateString.validate();
    }

    public String findIndexByName() {
        System.out.println("Enter name: ");
        return ValidateString.validate();
    }

    public String editMovie() {
        System.out.println("Enter new name: ");
        return ValidateString.validate();
    }

    public String alertMovieNotExist() {
        System.err.println("Movie does not Exist!");
        System.err.println("Press 1 to TRY AGAIN or Press 2 to return Menu");
        return ValidateString.validate();
    }

    public String alertSameName() {
        System.err.println("The same name!");
        System.out.println("Press 1 to TRY AGAIN or 2 to return menu");
        return ValidateString.validate();
    }

    public String inputAccountName() {
        System.out.println("Enter User name");
        return ValidateString.validate();
    }


    public String manageAccountView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Display all User account");
        System.out.println("2. Delete User account");
        System.out.println("0. Return");
        System.out.println("Enter choice");
        return ValidateString.validate();
    }
}
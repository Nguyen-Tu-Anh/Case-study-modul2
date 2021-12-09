package view;

import controller.ControllerLogin;
import model.Account;
import model.Movie;
import model.PlayList;
import service.AccountService;
import validate.ValidateString;

import java.util.Scanner;

public class PlaylistView {
    Scanner scanner = new Scanner(System.in);

    public int menuUser() {
        System.out.println("                             ꧁༺༒༻꧂ ♠ WELCOME" + " " + AccountService.account2.getUserName().toUpperCase() + " ♠" + " ꧁༺༒༻꧂");
        System.out.println("");
        System.out.print("            1. Show All Playlist");
        System.out.println("                                 6. Add movie to playlist                                                 ");
        System.out.print("            2. Create Playlist");
        System.out.println("                                   7. Delete movie from playlist");
        System.out.print("            3. Edit Playlist name");
        System.out.println("                                8. Show movie in playlist");
        System.out.print("            4. Delete Playlist");
        System.out.println("                                   9. Show favorite movie in MONTH");
        System.out.print("            5. Search Playlist by name");
        System.out.println("                           0. Log out");
        System.out.println("                                          © Netflix.com ");
        System.out.println("");
        System.err.println("ღEᑎTEᖇ ᑕᕼOIᑕEღ➻  ");
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7 || choice == 8 || choice == 9 || choice == 0) {
                    return choice;
                }
            } catch (Exception e) {
                System.err.println("Press 0 ~ 9");
            }
        }
    }

    public void nonePlaylist() {
        System.err.println("There is NO playlist to display");
    }

    public PlayList createPlaylist() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        return new PlayList(name);
    }

    public String enterPlaylistName() {
        System.out.println("Enter play list name: ");
        return ValidateString.validate();
    }

    public String findMovieToPlaylist() {
        System.out.println("Enter movie name");
        return ValidateString.validate();
    }

    public String alertNameEdit() {
        System.err.println("The Playlist Name is the same!");
        System.err.println("Press 1 to TRY AGAIN or press 2 return Menu");
        return ValidateString.validate();
    }

    public String alertPlaylistNotExist() {
        System.err.println("Playlist does not Exist!");
        System.err.println("Press 1 to TRY AGAIN or press 2 return Menu");
        return ValidateString.validate();
    }

    public String inputNewPlaylistName() {
        System.out.println("Enter new name:");
        return ValidateString.validate();
    }

    public void displayTopMovie(int index) {
        System.out.println("The most favorite movie in MONTH");
        switch (index) {
            case 0: {
                System.out.println("movieName='Spider-Man', producerName='Marvel'");
                break;
            }
            case 1: {
                System.out.println("movieName='Batman', producerName='DC Comics'");
                break;
            }
            case 2: {
                System.out.println("movieName='Avatar', producerName='James Cameron'");
                break;
            }
            case 3: {
                System.out.println("movieName='Iron man', producerName='Marvel'");
                break;
            }
            case 4: {
                System.out.println("movieName='Skytour', producerName='MTP-Entertainment'");
                break;
            }
            case 5: {
                System.out.println("movieName='Nevertheless', producerName='Netflix'");
                break;
            }
            case 6: {
                System.out.println("movieName='Iteawon class', producerName='Netflix'");
                break;
            }
            case 7: {
                System.out.println("'Crash landing on you', producerName='Lee Jung-hyo'");
                break;
            }
            case 8: {
                System.out.println("movieName='Descendants of the Sun', producerName='Lee Eung-bok'");
                break;
            }
            case 9: {
                System.out.println("movieName='Fifty Shades', producerName='Universal Studios'");
                break;
            }
        }
    }
}

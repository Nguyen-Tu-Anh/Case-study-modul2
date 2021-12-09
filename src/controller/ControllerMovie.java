package controller;

import service.MovieService;
import view.MovieView;

import javax.swing.*;
import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Scanner;

public class ControllerMovie {
    public static void menuManageAdmin() {
        MovieView movieView = new MovieView();
        MovieService movieService = new MovieService();

        while (true) {
            int choice = movieView.menuAdmin();
            switch (choice) {
                case 1: {
                    movieService.display();
                    break;
                }
                case 2: {
                    movieService.save(movieView.createMovie());
                    break;
                }
                case 3: {
                    movieService.sortByName();
                    break;
                }
                case 4: {
                    while (true) {
                        String name = movieView.deleteMovie();
                        boolean isMovieExist = movieService.isMovieExist(name);
                        if (isMovieExist) {
                            String choice2 = movieView.sureToDelete();
                            if (choice2.equalsIgnoreCase("y")) {
                                movieService.delete(movieService.findIndexByName(name));
                                break;
                            } else {
                                ControllerMovie.menuManageAdmin();
                            }
                        } else {
                            String choice3 = movieView.alertMovieNotExist();
                            if (choice3.equals("2")) {
                                ControllerMovie.menuManageAdmin();
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    while (true) {
                        String oldName = movieView.findIndexByName();
                        boolean isMovieExist = movieService.isMovieExist(oldName);
                        if (isMovieExist) {
                            String newName = movieView.editMovie();
                            boolean isSameName = movieService.isSameName(oldName, newName);
                            if (isSameName) {
                                String choice2 = movieView.alertSameName();
                                if (choice2.equals("2")) {
                                    ControllerMovie.menuManageAdmin();
                                    break;
                                }
                            } else {
                                movieService.edit(movieService.findIndexByName(oldName), newName);
                                break;
                            }

                        } else {
                            String choice3 = movieView.alertMovieNotExist();
                            if (choice3.equals("2")) {
                                ControllerMovie.menuManageAdmin();
                                break;
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    while (true) {
                        String choice2 = movieView.manageAccountView();
                        if (choice2.equals("1")) {
                            movieService.displayUserAcc();
                            break;
                        }
                        if (choice2.equals("2")) {
                            while (true) {
                                String name = movieView.inputAccountName();
                                boolean isMovieExist = movieService.isMovieExist(name);
                                if (isMovieExist) {
                                    int index = movieService.findIndexAccByName(name);
                                    movieService.deleteUserAcc(index);
                                    break;
                                } else {
                                    String choice3 = movieView.alertMovieNotExist();
                                    if (choice3.equals("2")) {
                                        ControllerMovie.menuManageAdmin();
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                        if (choice2.equalsIgnoreCase("0")) {
                            ControllerMovie.menuManageAdmin();
                            break;
                        }
                    }
                    break;
                }
                case 0: {
                    ControllerLogin.menuLogin();
                    break;
                }
            }
        }
    }
}

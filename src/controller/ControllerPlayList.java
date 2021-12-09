package controller;

import model.Movie;
import model.PlayList;
import service.MovieService;
import service.PlaylistService;
import view.MovieView;
import view.PlaylistView;

public class ControllerPlayList {
    public static void menuManageUser() {
        PlaylistView playlistView = new PlaylistView();
        PlaylistService playlistService = new PlaylistService();
        MovieService movieService = new MovieService();
        MovieView movieView = new MovieView();

        while (true) {
            int choice = playlistView.menuUser();
            switch (choice) {
                case 1:
                    playlistService.display();
                    break;
                case 2:
                    playlistService.save(playlistView.createPlaylist());
                    break;
                case 3:
                    while (true) {
                        String name = playlistView.enterPlaylistName();
                        boolean isPlaylistExist = playlistService.isPlaylistExist(name);

                        if (isPlaylistExist) {
                            while (true) {
                                String newName = playlistView.inputNewPlaylistName();
                                if (name.equals(newName)) {
                                    String choice2 = playlistView.alertNameEdit();
                                    if (choice2.equals("2")) {
                                        ControllerPlayList.menuManageUser();
                                        break;
                                    }
                                } else {
                                    playlistService.edit(playlistService.findIndexByName(name), newName);
                                    break;
                                }
                            }
                            break;
                        } else {
                            String choice3 = playlistView.alertPlaylistNotExist();
                            if (choice3.equals("2")) {
                                ControllerPlayList.menuManageUser();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        String name = playlistView.enterPlaylistName();
                        boolean isPlaylistExist = playlistService.isPlaylistExist(name);
                        if (isPlaylistExist) {
                            playlistService.delete(name);
                            break;
                        } else {
                            String choice2 = playlistView.alertPlaylistNotExist();
                            if (choice2.equals("2")) {
                                ControllerPlayList.menuManageUser();
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    while (true) {
                        String name = playlistView.enterPlaylistName();
                        boolean isPlaylistExist = playlistService.isPlaylistExist(name);
                        if (isPlaylistExist) {
                            playlistService.search(playlistService.findIndexByName(name));
                            break;
                        } else {
                            String choice2 = playlistView.alertPlaylistNotExist();
                            if (choice2.equals("2")) {
                                ControllerPlayList.menuManageUser();
                                break;
                            }
                        }
                    }
                    break;
                case 6:
                    while (true) {
                        String name = playlistView.findMovieToPlaylist();
                        boolean isMovieExist = movieService.isMovieExist(name);
                        if (isMovieExist) {
                            Movie movie = playlistService.getMovie(playlistService.findIndexMovieByName(name));
                            while (true) {
                                String name2 = playlistView.enterPlaylistName();
                                boolean isPlaylistExist = playlistService.isPlaylistExist(name2);
                                if (isPlaylistExist) {
                                    playlistService.addMovieToPlaylist(playlistService.findIndexByName(name2), movie);
                                    break;
                                } else {
                                    String choice2 = playlistView.alertPlaylistNotExist();
                                    if (choice2.equals("2")) {
                                        ControllerPlayList.menuManageUser();
                                        break;
                                    }
                                }
                            }
                            break;
                        } else {
                            String choice3 = movieView.alertMovieNotExist();
                            if (choice3.equals("2")) {
                                ControllerPlayList.menuManageUser();
                                break;
                            }
                        }
                    }
                    break;
                case 7:
                    while (true) {
                        String name = playlistView.enterPlaylistName();
                        boolean isPlaylistExist = playlistService.isPlaylistExist(name);
                        if (isPlaylistExist) {
                            playlistService.search(playlistService.findIndexByName(name));
                            PlayList playList = playlistService.getPlayListsByName(playlistService.findIndexByName(name));
                            while (true) {
                                String name2 = playlistView.findMovieToPlaylist();
                                boolean isMovieExist = movieService.isMovieExist(name2);
                                if (isMovieExist) {
                                    int index = playlistService.findIndexMovieInPlaylist(name2, playList);
                                    playlistService.deleteMovieInPlaylist(playList, index);
                                    break;
                                } else {
                                    String choice2 = movieView.alertMovieNotExist();
                                    if (choice2.equals("2")) {
                                        ControllerPlayList.menuManageUser();
                                        break;
                                    }
                                }
                            }
                            break;
                        } else {
                            String choice3 = playlistView.alertPlaylistNotExist();
                            if (choice3.equals("2")) {
                                ControllerPlayList.menuManageUser();
                                break;
                            }
                        }
                    }
                    break;
                case 8:
                    while (true) {
                        String name = playlistView.enterPlaylistName();
                        boolean isPlaylistExist = playlistService.isPlaylistExist(name);
                        if (isPlaylistExist) {
                            playlistService.displayAllMovie(playlistService.findIndexByName(name));
                            break;
                        } else {
                            String choice3 = playlistView.alertPlaylistNotExist();
                            if (choice3.equals("2")) {
                                ControllerPlayList.menuManageUser();
                                break;
                            }
                        }
                    }
                    break;
                case 9:
                    playlistView.displayTopMovie(playlistService.countHotMovie());
                    break;
                case 0:
                    ControllerLogin.menuLogin();
                    break;
            }
        }
    }
}

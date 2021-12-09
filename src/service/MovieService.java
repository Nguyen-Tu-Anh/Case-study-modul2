package service;

import config.ReadAndWriteFile;
import file.Path;
import model.Account;
import model.Movie;
import model.PlayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    AccountService accountService = new AccountService();
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    private final String PATH_ACC = Path.PATH + "account.txt";
    private final String PATH_MOVIE = Path.PATH + "movie.txt";
    public List<Movie> movies = readAndWriteFile.readFromFile(PATH_MOVIE);

    public List<Movie> findAll() {
        return movies;
    }

    public void display() {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i).toString());
        }
    }

    public void save(Movie movie) {
        movies.add(movie);
        readAndWriteFile.writeToFile(movies, PATH_MOVIE);
    }

    public void sortByName() {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getMovieName().compareTo(o2.getMovieName());
            }
        });
    }

    public void delete(int index) {
        movies.remove(index);
        readAndWriteFile.writeToFile(movies, PATH_MOVIE);
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void search(int index) {
        System.out.println(movies.get(index));
    }

    public void edit(int index, String name) {
        movies.get(index).setMovieName(name);
        readAndWriteFile.writeToFile(movies, PATH_MOVIE);
    }

    public boolean isMovieExist(String name) {
        boolean check = false;
        for (int i = 0; i < movies.size(); i++) {
            if (name.equalsIgnoreCase(movies.get(i).getMovieName())) {
                check = true;
            }
        }
        return check;
    }

    public boolean isSameName(String name1, String name2) {
        boolean check = false;
        if (name1.equalsIgnoreCase(name2)) {
            check = true;
        }
        return check;
    }

    public void displayUserAcc() {
        for (Account a : accountService.accounts) {
            System.out.println(a.toString());
        }
    }

    public void deleteUserAcc(int index) {
        accountService.accounts.remove(index);
        readAndWriteFile.writeToFile(accountService.accounts, PATH_ACC);
    }

    public int findIndexAccByName(String name) {
        for (int i = 0; i < accountService.accounts.size(); i++) {
            if (name.equals(accountService.accounts.get(i).getUserName())) {
                return i;
            }
        }
        return -1;
    }

//    public boolean isMovieExistInPlaylist(String name, PlayList playList) {
//        boolean check = false;
//        for (int i = 0)
//    }

}

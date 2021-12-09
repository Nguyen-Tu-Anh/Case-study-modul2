package service;

import config.ReadAndWriteFile;
import file.Path;
import model.Movie;
import model.PlayList;
import view.PlaylistView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlaylistService {
    PlaylistView playlistView = new PlaylistView();
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    private final String PATH_LIST = Path.PATH + "playlist.txt";
    public List<PlayList> playLists = readAndWriteFile.readFromFile(PATH_LIST);

    public List<Movie> movieList = readAndWriteFile.readFromFile(Path.PATH + "movie.txt");
    List<Integer> countList = new ArrayList<>();
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;
    int count8 = 0;
    int count9 = 0;
    int count10 = 0;

    public List<PlayList> findAll() {
        return playLists;
    }

    public void save(PlayList playList) {
        playLists.add(playList);
        readAndWriteFile.writeToFile(playLists, PATH_LIST);
    }

    public void display() {
        for (PlayList a : playLists) {
            System.out.println(a);
        }
    }

    public void edit(int index, String name) {
        playLists.get(index).setName(name);
        readAndWriteFile.writeToFile(playLists, PATH_LIST);
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < playLists.size(); i++) {
            if (playLists.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findIndexMovieByName(String name) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findIndexMovieInPlaylist(String name, PlayList playList) {
        for (int i = 0; i < playList.getMovieList().size(); i++) {
            if (playList.getMovieList().get(i).getMovieName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }


    public void delete(String name) {
        playLists.remove(findIndexByName(name));
        readAndWriteFile.writeToFile(playLists, PATH_LIST);
    }

    public void search(int index) {
        System.out.println(playLists.get(index));
    }

    public PlayList getPlayListsByName(int index) {
        return playLists.get(index);
    }

    public void deleteMovieInPlaylist(PlayList playList, int index) {
        playList.getMovieList().remove(index);
    }


    public Movie getMovie(int index) {
        return movieList.get(index);
    }

    public void addMovieToPlaylist(int index, Movie movie) {

        if (movie.getMovieName().equalsIgnoreCase("Spider-Man")) {
            count1++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Batman")) {
            count2++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Avatar")) {
            count3++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Iron man")) {
            count4++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Skytour")) {
            count5++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Nevertheless")) {
            count6++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Iteawon class")) {
            count7++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Crash landing on you")) {
            count8++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Descendants of the Sun")) {
            count9++;
        }
        if (movie.getMovieName().equalsIgnoreCase("Fifty Shades")) {
            count10++;
        }
        playLists.get(index).getMovieList().add(movie);
        readAndWriteFile.writeToFile(playLists, PATH_LIST);
    }

    public int countHotMovie() {
        countList.add(count1);
        countList.add(count2);
        countList.add(count3);
        countList.add(count4);
        countList.add(count5);
        countList.add(count6);
        countList.add(count7);
        countList.add(count8);
        countList.add(count9);
        countList.add(count10);
        int max = count1;
        int index = 0;
        for (int i = 0; i < countList.size(); i++) {
            if (max < countList.get(i)) {
                max = countList.get(i);
                index = i;
            }
        }
        System.out.println(countList.get(max));
        return index;

    }

    public void deleteMovieToPlaylist(int index, int index2) {

        playLists.get(index2).getMovieList().remove(index);
        readAndWriteFile.writeToFile(playLists, PATH_LIST);
    }

    public void displayAllMovie(int index) {
        List<Movie> movieList = playLists.get(index).getMovieList();
        for (Movie a : movieList) {
            System.out.println(a);
        }
    }

    public boolean isPlaylistExist(String name) {
        boolean check = false;
        for (int i = 0; i < playLists.size(); i++) {
            if (name.equals(playLists.get(i).getName())) {
                check = true;
            }
        }
        return check;
    }
}

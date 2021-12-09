package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Serializable {
    private String name;
    private List<Movie> movieList = new ArrayList<>();

    public PlayList() {
    }

    public PlayList(String name) {
        this.name = name;
    }

    public PlayList(String name, List<Movie> movieList) {
        this.name = name;
        this.movieList = movieList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", movieList=" + movieList +
                '}';
    }
}

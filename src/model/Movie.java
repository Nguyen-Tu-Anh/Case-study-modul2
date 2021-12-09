package model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String movieName;
    private String producerName;
    private PlayList playList;
    static int idNumber = 1;

    public Movie() {
    }

    public Movie(String movieName, String producerName) {
        this.id = idNumber++;
        this.movieName = movieName;
        this.producerName = producerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public PlayList getCategory() {
        return playList;
    }

    public void setCategory(PlayList playList) {
        this.playList = playList;
    }


    public String toString2() {
        return "Movie{ " +
                "movieName='" + movieName + '\'' +
                ", producerName='" + producerName + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Movie{ " +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", producerName='" + producerName + '\'' +
                '}';
    }
}
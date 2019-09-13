package com.hillel.web.homeLibrary.film;

import java.util.List;

public class Film {

    private int id;
    private String title;
    private List<String> actors;
    private String actor;
    private String director;
    private int releaseDate;
    private String releaseCountry;

    public Film(int id,String title,String director,List<String> actors,int releaseDate,String releaseCountry) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.releaseCountry = releaseCountry;
    }

    public Film(int id,String title,String actor,String director,int releaseDate,String releaseCountry) {
        this.id = id;
        this.title = title;
        this.actor = actor;
        this.director = director;
        this.releaseDate = releaseDate;
        this.releaseCountry = releaseCountry;
    }

    public String getActor() {
        return actor;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getActors() {
        return actors;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getReleaseCountry() {
        return releaseCountry;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseCountry(String releaseCountry) {
        this.releaseCountry = releaseCountry;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate=" + releaseDate +
                ", releaseCountry='" + releaseCountry + '\'' +
                '}';
    }
}

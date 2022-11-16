package com.example.mymovie.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class acteur {

    @ApiModelProperty(notes = "The name of the actor")
    private String name;
    @ApiModelProperty(notes = "The firstname of the actor")
    private String prenom;
    @ApiModelProperty(notes = "The date of the actor")
    private String date_naissance;
    @ApiModelProperty(notes = "The filmography of the actor")
    private String filmographie[];

    public acteur(String name, String prenom, String date_naissance, String[] filmographie) {
        this.name = name;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.filmographie = filmographie;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public String[] getFilmographie() {
        return filmographie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setFilmographie(String[] filmographie) {
        this.filmographie = filmographie;
    }

    public void addMovie(String movie){
        String[] newFilmographie = new String[filmographie.length+1];
        for (int i = 0; i < filmographie.length; i++) {
            newFilmographie[i]=filmographie[i];
        }
        newFilmographie[filmographie.length]=movie;
        filmographie=newFilmographie;
    }

    @Override
    public String toString() {
        return "acteur{" +
                "name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance='" + date_naissance + '\'' +
                ", filmographie=" + filmographie +
                '}';
    }


}

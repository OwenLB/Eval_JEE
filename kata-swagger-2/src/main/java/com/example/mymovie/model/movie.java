package com.example.mymovie.model;

import io.swagger.annotations.ApiModelProperty;

public class movie {
    @ApiModelProperty(notes = "The name of the movie")
    private String name;
    @ApiModelProperty(notes = "The realisator of the movie")
    private String realisateur;
    @ApiModelProperty(notes = "The main actor of the movie")
    private String acteur_principal;
    @ApiModelProperty(notes = "The date of the movie")
    private String date_sortie;

    public movie(String name, String realisateur, String acteur_principal, String date_sortie) {
        this.name = name;
        this.realisateur = realisateur;
        this.acteur_principal = acteur_principal;
        this.date_sortie = date_sortie;
    }

    public String getName() {
        return name;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public String getActeur_principal() {
        return acteur_principal;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setActeur_principal(String acteur_principal) {
        this.acteur_principal = acteur_principal;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    @Override
    public String toString() {
        return "movie{" +
                "name='" + name + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", acteur_principal='" + acteur_principal + '\'' +
                ", date_sortie='" + date_sortie + '\'' +
                '}';
    }
}

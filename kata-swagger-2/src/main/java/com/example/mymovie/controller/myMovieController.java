package com.example.mymovie.controller;

import com.example.mymovie.model.acteur;
import com.example.mymovie.model.movie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;


@Api
@RestController
public class myMovieController {

    //create a list of movies

    public static ArrayList<movie> movies = new ArrayList<movie>();
    //create movies
    static {
        movies.add(new movie("The Godfather", "Francis Ford Coppola", "Marlon Brando", "1972"));
        movies.add(new movie("The Shawshank Redemption", "Frank Darabont", "Tim Robbins", "1994"));
        movies.add(new movie("The Dark Knight", "Christopher Nolan", "Christian Bale", "2008"));
        movies.add(new movie("The Godfather: Part II", "Francis Ford Coppola", "Al Pacino", "1974"));
    }
    //create a list of actors

    public static List<acteur> actors = new ArrayList<acteur>();

    static {
        actors.add(new acteur("Marlon Brando", "1924", "2004", null));
        actors.add(new acteur("Tim Robbins", "Robbins", "1958", null));
        actors.add(new acteur("Christian Bale", "Bale", "1974", null));
        actors.add(new acteur("Al Pacino", "Pacino", "1940", null));
    };

//    static {
//        setFilmography();
//    }
    //set filmography for actors when they are main actors in a movie

    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found")
    })


//    public static void setFilmography() {
//        for (movie movie : movies) {
//            for (acteur actor : actors) {
//                if (movie.getActeur_principal().equals(actor.getName())) {
//                    actor.addMovie(String.valueOf(movie));
//                }
//            }
//        }
//    }




    //get all actors
   @ApiOperation(value = "Get actors", notes = "Get actors")

    @GetMapping("/getActors")
    public List<acteur> getAllActors() {
        if (actors.isEmpty()) {
            return null;
        }
        return actors;
    }

    //get actor by name

   @ApiOperation(value = "Get actor by name", response = acteur.class)
    @GetMapping(value = "/getActor/{name}")
    public acteur getActorByName(@PathVariable String name) {
        for (acteur actor : actors) {
            if (actor.getName().equals(name)) {
                return actor;
            }
        }
        return null;
    }

    //get actor by movie

   @ApiOperation(value = "Get actor by movie", response = acteur.class)
    @GetMapping(value = "/getActorByMovie/{movie}")
    public acteur getActorByMovie(@PathVariable String movie) {
        for (movie movie1 : movies) {
            if (movie1.getName().equals(movie)) {
                return getActorByName(movie1.getActeur_principal());
            }
        }
        return null;
    }

    //get all movies

   @ApiOperation(value = "Get movies", notes = "Get movies")
    @GetMapping("/getMovies")
    public List<movie> getAllMovies() {
        if (movies.isEmpty()) {
            return null;
        }
        return movies;
    }

    //get movie by name
   @ApiOperation(value = "Get movie by name", response = movie.class)
    @GetMapping(value = "/getMovie/{name}")
    public movie getMovieByName(@PathVariable String name) {
        for (movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    //get movie by release year
   @ApiOperation(value = "Get movie by release date", response = movie.class)
    @GetMapping(value = "/getMovieByYear/{date}")
    public movie getMovieByDate(@PathVariable String date) {
        for (movie movie : movies) {
            if (movie.getDate_sortie().equals(date)) {
                return movie;
            }
        }
        return null;
    }

    //delete movie by name
    @ApiOperation(value = "Delete movie by name", response = movie.class)
    @DeleteMapping(value = "/deleteMovie/{name}")
    public movie deleteMovieByName(@PathVariable String name) {
        for (movie movie : movies) {
            if (movie.getName().equals(name)) {
                movies.remove(movie);
                return movie;
            }
        }
        return null;
    }

    //update movie by name
    @ApiOperation(value = "Update movie by name", response = movie.class)
    @PutMapping(value = "/updateMovie/{name}")
    public movie updateMovieByName(@PathVariable String name) {
        for (movie movie : movies) {
            if (movie.getName().equals(name)) {
                movies.remove(movie);
                return movie;
            }
        }
        return null;
    }

    //delete actor by name
    @ApiOperation(value = "Delete actor by name", response = acteur.class)
    @DeleteMapping(value = "/deleteActor/{name}")
    public acteur deleteActorByName(@PathVariable String name) {
        for (acteur actor : actors) {
            if (actor.getName().equals(name)) {
                actors.remove(actor);
                return actor;
            }
        }
        return null;
    }

    //update actor by name
    @ApiOperation(value = "Update actor by name", response = acteur.class)
    @PutMapping(value = "/updateActor/{name}")
    public acteur updateActorByName(@PathVariable String name) {
        for (acteur actor : actors) {
            if (actor.getName().equals(name)) {
                actors.remove(actor);
                return actor;
            }
        }
        return null;
    }














}

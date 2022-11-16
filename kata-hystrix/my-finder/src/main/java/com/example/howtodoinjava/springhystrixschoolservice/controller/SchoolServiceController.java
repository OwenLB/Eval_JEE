package com.example.howtodoinjava.springhystrixschoolservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.howtodoinjava.springhystrixschoolservice.delegate.FinderServiceDelegate;

@RestController
public class SchoolServiceController {
	
	@Autowired
    FinderServiceDelegate studentServiceDelegate;

	@RequestMapping(value = "/view/getMovies", method = RequestMethod.GET)
	public String getMovies() {
		System.out.println("Going to call movie service to get data!");
		return studentServiceDelegate.callGetMovies();
	}

	@RequestMapping(value = "/view/getMovies", method = RequestMethod.GET)
	public String getActors() {
		System.out.println("Going to call movie service to get data!");
		return studentServiceDelegate.callGetActors();
	}
	@RequestMapping(value = "/view/getMovie/{name}", method = RequestMethod.GET)
	public String getMovieByName(@PathVariable String name) {
		System.out.println("Going to call movie service to get data!");
		return studentServiceDelegate.callGetMoviesByName(name);
	}

	@RequestMapping(value = "/view/getActor/{name}", method = RequestMethod.GET)
	public String getActorByName(@PathVariable String name) {
		System.out.println("Going to call movie service to get data!");
		return studentServiceDelegate.callGetActorsByName(name);
	}

	@RequestMapping(value = "/view/getMovieByYear/{date}}", method = RequestMethod.GET)
	public String getMovieByYear(@PathVariable String date) {
		System.out.println("Going to call movie service to get data!");
		return studentServiceDelegate.callGetMoviesByYear(date);
	}

	@RequestMapping(value = "/view/getActorByMovie/{movie}", method = RequestMethod.GET)
	public String GetActorByMovie(@PathVariable String movie) {
		System.out.println("Going to call movie service to get data!");
		return studentServiceDelegate.callGetActorByMovie(movie);
	}

}

package com.example.howtodoinjava.springhystrixschoolservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.howtodoinjava.springhystrixschoolservice.delegate.FinderServiceDelegate;

@Api
@RestController
public class FinderServiceController {

	@Autowired
    FinderServiceDelegate finderServiceDelegate;

	@ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
			@io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
			@io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
			@io.swagger.annotations.ApiResponse(code = 404, message = "Not Found")
	})

	@ApiOperation(value = "getMovies", nickname = "getMoviesDetails")
	@RequestMapping(value = "/view/getMovies", method = RequestMethod.GET)
	public String getMovies() {
		System.out.println("Going to call movie service to get data!");
		return finderServiceDelegate.callGetMovies();
	}


	@RequestMapping(value = "/view/getActors", method = RequestMethod.GET)
	@ApiOperation(value = "getActors", nickname = "getActorsDetails")
	public String getActors() {
		System.out.println("Going to call movie service to get data!");
		return finderServiceDelegate.callGetActors();
	}
	@RequestMapping(value = "/view/getMovie/{name}", method = RequestMethod.GET)
	public String getMovieByName(@PathVariable String name) {
		System.out.println("Going to call movie service to get data!");
		return finderServiceDelegate.callGetMoviesByName(name);
	}

	@RequestMapping(value = "/view/getActor/{name}", method = RequestMethod.GET)
	public String getActorByName(@PathVariable String name) {
		System.out.println("Going to call movie service to get data!");
		return finderServiceDelegate.callGetActorsByName(name);
	}

	@RequestMapping(value = "/view/getMovieByYear/{date}}", method = RequestMethod.GET)
	@ApiOperation(value = "getMovieByYear", nickname = "getMovieByYearDetails")
	public String getMovieByYear(@PathVariable String date) {
		System.out.println("Going to call movie service to get data!");
		return finderServiceDelegate.callGetMoviesByYear(date);
	}

	@RequestMapping(value = "/view/getActorByMovie/{movie}", method = RequestMethod.GET)
	@ApiOperation(value = "getActorByMovie", nickname = "getActorByMovieDetails")
	public String GetActorByMovie(@PathVariable String movie) {
		System.out.println("Going to call movie service to get data!");
		return finderServiceDelegate.callGetActorByMovie(movie);
	}
}

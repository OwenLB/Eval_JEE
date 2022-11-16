package com.example.howtodoinjava.springhystrixschoolservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FinderServiceDelegate {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String callGetMovies() {
		System.out.println("Getting all movies");
		String response = restTemplate
				.exchange("http://localhost:8080/getMovies"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Movie Name -  " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String callGetActors() {
		System.out.println("Getting all actors");
		String response = restTemplate
				.exchange("http://localhost:8080/getActors"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Actor Name -  " + response + " -  " + new Date();
	}
	
	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String callGetMoviesByName(String name) {
		System.out.println("Getting School details for " + name);
		String response = restTemplate
				.exchange("http://localhost:8080/getMovie/{name}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, name).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Movie Name -  " + name + " :::  Movie Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String callGetActorsByName(String name) {
		System.out.println("Getting School details for " + name);
		String response = restTemplate
				.exchange("http://localhost:8080/getActor/{name}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, name).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Actor Name -  " + name + " :::  Actor Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String callGetMoviesByYear(String date) {
		System.out.println("Getting School details for " + date);
		String response = restTemplate
				.exchange("http://localhost:8080/getMovieByYear/{date}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, date).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Movie Date -  " + date + " :::  Movie Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String callGetActorByMovie(String movie) {
		System.out.println("Getting School details for " + movie);
		String response = restTemplate
				.exchange("http://localhost:8080/getActorByMovie/{movie}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, movie).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Actor Movie -  " + movie + " :::  Actor Details " + response + " -  " + new Date();
	}
	private String callMovieServiceAndGetData_Fallback() {
		System.out.println("Movie Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Movie Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

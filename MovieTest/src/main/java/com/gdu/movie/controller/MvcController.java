package com.gdu.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.service.MovieService;

@Controller
public class MvcController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping(value="/list.json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieDTO> list(){
		return movieService.getMovieList();
	}
	
}
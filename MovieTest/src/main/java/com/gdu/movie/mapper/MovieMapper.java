package com.gdu.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.movie.domain.MovieDTO;

@Mapper
public interface MovieMapper {
	public List<MovieDTO> getMovieList();
}

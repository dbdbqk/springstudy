package com.gdu.movie.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDTO {

	private int movieNo;
	private String movieName;
	private String movieContent;
	private Date date;
	private int moviePrice;
	
}

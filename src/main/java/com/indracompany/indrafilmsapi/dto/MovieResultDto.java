package com.indracompany.indrafilmsapi.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "results")
	private List<MovieDto> results;
	
	public MovieResultDto() {
		
	}

	public List<MovieDto> getResults() {
		return results;
	}

	public void setResults(List<MovieDto> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "FilmResultDto [results=" + results + "]";
	}

}

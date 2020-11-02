package com.indracompany.indrafilmsapi.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.indracompany.indrafilmsapi.util.DateFormatUtil;

public class MovieDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "poster_path")
	private String posterPath;
	
	@JsonProperty(value = "title")
	private String title;
	
	@JsonProperty(value = "vote_average")
	private Double voteAverage;
	
	@JsonProperty(value = "overview")
	private String overview;
	
	@JsonProperty(value = "release_date")
	private String releaseDate;
	
	public MovieDto() {
		
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		Date date = DateFormatUtil.formatToDate(releaseDate);
		this.releaseDate = DateFormatUtil.formatToString(date);
	}

	@Override
	public String toString() {
		return "FilmDto [posterPath=" + posterPath + ", title=" + title + ", voteAverage=" + voteAverage + ", overview="
				+ overview + ", releaseDate=" + releaseDate + "]";
	}
	
}

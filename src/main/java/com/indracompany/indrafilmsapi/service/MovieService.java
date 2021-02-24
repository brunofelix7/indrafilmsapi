package com.indracompany.indrafilmsapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.indracompany.indrafilmsapi.dto.MovieDto;
import com.indracompany.indrafilmsapi.dto.MovieResultDto;
import com.indracompany.indrafilmsapi.exception.RestTemplateException;

@Service
public class MovieService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api_key}")
	private String apiKey;
	
	@Value("${moviewdb_url}")
	private String url;
	
	public List<MovieDto> fetchMovies() {
		List<MovieDto> results = new ArrayList<>();
		try {
			ResponseEntity<MovieResultDto> response = restTemplate.getForEntity(url + apiKey, MovieResultDto.class);
			
			results = response.getBody().getResults();
		} catch (RestTemplateException e) {
			e.printStackTrace();
		}
		return results;
	}

}

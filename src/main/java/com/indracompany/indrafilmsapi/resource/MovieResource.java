package com.indracompany.indrafilmsapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.indracompany.indrafilmsapi.dto.MovieDto;
import com.indracompany.indrafilmsapi.dto.MovieResultDto;
import com.indracompany.indrafilmsapi.security.ApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/")
@Api(value = "Filmes")
public class MovieResource {
	
	@Value("${api_key}")
	private String apiKey;
	
	@Value("${moviewdb_url}")
	private String url;

	@GetMapping
	public ResponseEntity<?> home() {
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Welcome to Indra Films API.", null));
	}
	
	@GetMapping(path = "/api/movies")
	@ApiOperation(value = "Retorna os filmes mais populares.")
	public List<MovieDto> films() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MovieResultDto> response = restTemplate.getForEntity(url + apiKey, MovieResultDto.class);
		
		List<MovieDto> results = response.getBody().getResults();
		
		return results;
	}
	
}

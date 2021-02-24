package com.indracompany.indrafilmsapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indracompany.indrafilmsapi.dto.ApiSuccessDto;
import com.indracompany.indrafilmsapi.dto.MovieDto;
import com.indracompany.indrafilmsapi.service.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/")
@Api(value = "Filmes")
public class MovieResource {

	@Autowired
	private MovieService service;

	@GetMapping(path = "/api/movies")
	@ApiOperation(value = "Retorna os filmes mais populares.")
	public ResponseEntity<?> films() {
		return ResponseEntity.ok(new ApiSuccessDto<List<MovieDto>>(
				HttpStatus.OK.value(), 
				"Autenticado com sucesso",
				service.fetchMovies()));
	}

}

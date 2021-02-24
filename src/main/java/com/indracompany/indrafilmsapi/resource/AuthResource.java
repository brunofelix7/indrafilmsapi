package com.indracompany.indrafilmsapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indracompany.indrafilmsapi.dto.ApiErrorDto;
import com.indracompany.indrafilmsapi.dto.ApiSuccessDto;
import com.indracompany.indrafilmsapi.dto.TokenDto;
import com.indracompany.indrafilmsapi.dto.UserDto;
import com.indracompany.indrafilmsapi.security.JwtUtil;
import com.indracompany.indrafilmsapi.security.MyUserDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api")
@Api(value = "Autenticação")
public class AuthResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService service;
	
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(path = "/auth")
	@ApiOperation(value = "Realiza a autenticação do usuário.")
	public ResponseEntity<?> authenticate(@RequestBody UserDto user) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
			);
		} catch (BadCredentialsException e) {
			return ResponseEntity.badRequest().body(new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), "E-mail ou senha inválidos"));
		}
		
		final UserDetails userDetails = service.loadUserByUsername(user.getEmail());
		
		final String token = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new ApiSuccessDto<TokenDto>(HttpStatus.OK.value(), "Autenticado com sucesso", new TokenDto(token)));
	}
	
}

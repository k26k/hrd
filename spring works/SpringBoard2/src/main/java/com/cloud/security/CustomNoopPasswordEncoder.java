package com.cloud.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoopPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		log.info("Before Encode: "+rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		log.info("matches: "+rawPassword+":"+encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}

}

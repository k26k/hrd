package com.boot.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	@Autowired
//	private SecurityUserDetailsService securityUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		http.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/s/**").anonymous()
					.antMatchers("/item/**", "/member/**").hasAnyRole("USER", "ADMIN")
					.antMatchers("/admin/**").hasAnyRole("ADMIN");
		
		http.formLogin()
					.loginPage("/s/in")
					.usernameParameter("email")
					.successHandler(new SrcurityLoginSuccessHandler())
					.failureUrl("/s/signInFail");
		
		http.logout()
					.invalidateHttpSession(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/s/out"))
					.logoutSuccessUrl("/");
		
//		http.userDetailsService(securityUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

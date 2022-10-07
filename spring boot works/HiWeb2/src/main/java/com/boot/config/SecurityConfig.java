package com.boot.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.boot.domain.Role;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
					.antMatchers("/", "/s/**").permitAll()
					.antMatchers("/board/**", "/member/**").hasAnyRole("MEMBER", "ADMIN")
					.antMatchers("/admin/**").hasAnyRole("ADMIN");
		
		httpSecurity.formLogin()
					.loginPage("/s/signIn")
					.defaultSuccessUrl( "/ajax/signInSuccess", true)
					.failureUrl("/ajax/signInFail");
		
		httpSecurity.logout()
					.invalidateHttpSession(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/s/signOut"))
					.logoutSuccessUrl("/");
		
		httpSecurity.userDetailsService(securityUserDetailsService);
	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}

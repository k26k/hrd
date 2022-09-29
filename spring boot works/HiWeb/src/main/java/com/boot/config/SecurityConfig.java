package com.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/member/**").hasAnyRole("MEMBER","ADMIN")
					.antMatchers("/admin/**").hasAnyRole("ADMIN");
		
		
		httpSecurity.formLogin()
					.loginPage("/system/login")
					.defaultSuccessUrl("/getBoardList", true)
					.failureUrl("/system/login?error=1");
		
		
		httpSecurity.logout()
					.logoutUrl("/system/logout")
					.logoutSuccessUrl("/system/login?error=1");
		
		
//		httpSecurity.userDetailsService(securityUserDetailsService);
		
		httpSecurity.csrf().disable();
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		
		String query1 		= "SELECT member_id username, "
							+ "concat('{noop}',password) password,"
							+ "true enabled "
							+ "FROM member WHERE member_id = ?";
		String memberQuery 	= "SELECT member_id username, "
							+ "concat('{noop}',password) password "
							+ "true enabled "
							+ "FROM member WHERE member_id = ?";
		
		String authorityQuery = "SELECT member_id, role FROM member WHERE id=?";
		
		authenticationManagerBuilder.jdbcAuthentication()
									.dataSource(dataSource)
									.usersByUsernameQuery(query1)
									.authoritiesByUsernameQuery(authorityQuery);
		
	}
	
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
}

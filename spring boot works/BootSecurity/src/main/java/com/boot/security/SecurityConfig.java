package com.boot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		
//		모두 접근 가능
//		httpSecurity.authorizeRequests().antMatchers("/").permitAll();
		
//		유저만 접근 가능
//		httpSecurity.authorizeRequests().antMatchers("/member").authenticated();
		
//		빌더 패턴을 사용한 재정의
		httpSecurity.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/member/**").authenticated()
					.antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
					.antMatchers("/admin/**").hasRole("ADMIN");
		
//		security 기본 제공 로그인폼 사용
//		httpSecurity.formLogin();

//		로그인 폼 재정의
		httpSecurity.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/loginSuccess", true);
		
//		로그아웃 정의
		httpSecurity.logout()
					.invalidateHttpSession(true)
					.logoutUrl("/logoutProcess")
					.logoutSuccessUrl("/logoutSuccess");
		
//		접근 권한 없음 페이지 처리
		httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
		
//		기본 UserDetailsService 대신 CustomUserDetailsService 사용
		httpSecurity.userDetailsService(customUserDetailsService);
		
		
//		security csrf 비활성화
		httpSecurity.csrf().disable();
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		
//		db에 저장된 사용자로 인증
//		query1: 인증 - 사용자가 입력한 아이디로 사용자 정보 조회
		String query1 = "SELECT member_id username, "
						+ "concat('{noop}',password) password,"
						+ "true enabled "
						+ "FROM member WHERE member_id = ?";
//		query2: 사용자가 입력한 아이디로 권한 정보 조회
		String query2 = "SELECT member_id, role "
						+ "FROM member WHERE member_id = ?";
		
//		추가 사용자 설정
//		authenticationManagerBuilder 객체 사용
//		jdbcAuthentication 메소드 사용 디비 연동
		authenticationManagerBuilder.jdbcAuthentication()
									.dataSource(dataSource)
									.usersByUsernameQuery(query1)
									.authoritiesByUsernameQuery(query2);
		
		
//		추가 사용자 설정
//		inMemoryAuthentication() 메소드 사용
//		authenticationManagerBuilder.inMemoryAuthentication()
//									.withUser("manager")
//									.password("{noop}manager")
//									.roles("MANAGER");
//		
//		authenticationManagerBuilder.inMemoryAuthentication()
//									.withUser("admin")
//									.password("{noop}admin")
//									.roles("ADMIN");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}

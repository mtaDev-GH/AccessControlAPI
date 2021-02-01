package com.mta_dev.access_control_api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {

		//		inMemoryAuthentication
		//		System.out.print("\n\ntestDebut");
		//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").privileges("ADMIN");
		//		System.out.print("\n\ntestFin");

		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select login as principal, password as credentials, true from users where login = ?")
			.authoritiesByUsernameQuery("SELECT \r\n" + 
					"	users.login as principal, privileges.name as privilege \r\n" + 
					"FROM \r\n" + 
					"	users \r\n" + 
					"	\r\n" + 
					"	INNER JOIN \r\n" + 
					"		users_profiles \r\n" + 
					"		\r\n" + 
					"	ON \r\n" + 
					"		users.id = users_profiles.user_id \r\n" + 
					"		\r\n" + 
					"	INNER JOIN\r\n" + 
					"		profiles_privileges\r\n" + 
					"		\r\n" + 
					"	ON \r\n" + 
					"		users_profiles.profile_id = profiles_privileges.profile_id\r\n" + 
					"		\r\n" + 
					"	INNER JOIN\r\n" + 
					"		privileges\r\n" + 
					"		\r\n" + 
					"	ON \r\n" + 
					"		profiles_privileges.privilege_id = privileges.id	\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"where users.login = ?")
			.rolePrefix("ROLE_");
	}

	protected void configure(HttpSecurity http) throws Exception{
		
		/*
		 * general instructions
		 * csrf().disable() to be able to execute post methodes "see reference below"
		 * sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) is good with restApi
		 * */
		
		
		////	see
		////	https://github.com/spring-projects/spring-security/issues/5222#issuecomment-393869335
		////	i added ".csrf().disable()" to be able to execute poste request without having 403
		//		http
		//			.csrf().disable()
		//			.authorizeRequests()
		//				.anyRequest()
		//					.authenticated();
		
		//		from https://medium.com/@gtommee97/rest-authentication-with-spring-security-and-mongodb-28c06da25fb1
		//	    http
		//	      .csrf().disable()
		//	      .authorizeRequests().anyRequest().authenticated()
		//	      .and().httpBasic()
		//	      .and().sessionManagement().disable();
		
		//		parlty from https://www.baeldung.com/spring-security-session
		
	    http
	      .csrf().disable()
	      .authorizeRequests().anyRequest().authenticated()
	      .and()
	      .httpBasic()
//	      "...This stateless architecture plays well with REST APIs and their Statelessness constraint..."
	      .and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    
		//	    TODO take the following code into account as another way to securise my services
		//	    the code is from : https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
		//	    Begin
		//	    .and()
		//	    .authorizeRequests()
		//	    .antMatchers("/api/foos").authenticated()
		//	    .antMatchers("/api/admin/**").hasRole("ADMIN")
		//	    END
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}
}

package com.tekup.gld.project.elbetta.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Qualifier("userDetailsServiceImpl")
	@Autowired
	// Make sure ti import the spring security interface
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()
	//			.antMatchers("/admin").hasRole("ADMIN")
	//			.antMatchers("/user").hasAnyRole("USER", "ADMIN")
				.antMatchers("**").permitAll()
//				.antMatchers("/api/**").authenticated()
//				.antMatchers("/auth/**").permitAll()
				.and().formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Set your configuration on the auth onject
		auth.userDetailsService(userDetailsService);
	}

	// Spring security is bay default looking for all beans, and if any of them is a password encoder,
	// then it will use it
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//	// The provided password should be hash using bCrypt
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

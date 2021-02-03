package com.tekup.gld.project.elbetta.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@EnableGlobalMethodSecurity(
		prePostEnabled = true,
		securedEnabled = true,
		jsr250Enabled = true)
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
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/user").hasAnyRole("USER", "ADMIN")
//				.antMatchers("**").permitAll()
				.antMatchers("/api/**").authenticated()
				.antMatchers("/auth/**").permitAll()
				.antMatchers("/login/**").permitAll()
				.and().httpBasic();
		http.csrf().disable();
		CorsConfiguration a = new CorsConfiguration().applyPermitDefaultValues();
		a.addAllowedMethod("DELETE");
		http.cors().configurationSource(request -> a);	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Set your configuration on the auth object
		auth.userDetailsService(userDetailsService);
	}


	// Spring security is by default looking for all beans, and if any of them is a password encoder,
	// then it will use it
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//	// The provided password should be hash using bCrypt
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//TODO: This needs to be improved
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}

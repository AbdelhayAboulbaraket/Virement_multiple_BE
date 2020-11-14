package com.adria.configuration.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	UserPrincipalDetailsService service;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		auth.authenticationProvider(provider);
		
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf()
        .disable()
        .formLogin()
        .loginProcessingUrl("/login")
        .and()
        .logout()
        .logoutUrl("/logout")
        .invalidateHttpSession(true)
        .and()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/**").authenticated()
        .anyRequest().permitAll();
	}
	


}

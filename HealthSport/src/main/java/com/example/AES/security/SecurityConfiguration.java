package com.example.AES.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	 protected void configure(HttpSecurity http) throws Exception {

	 //PAGINAS PUBLICAS
	 http.authorizeRequests().antMatchers("/").permitAll();
	 http.authorizeRequests().antMatchers("/login").permitAll();
	 http.authorizeRequests().antMatchers("/loginerror").permitAll();
	 http.authorizeRequests().antMatchers("/quienessomos").permitAll();
	 http.authorizeRequests().antMatchers("/registroGeneral").permitAll();
	 http.authorizeRequests().antMatchers("/registroEntrenador").permitAll();
	 http.authorizeRequests().antMatchers("/registroDeportista").permitAll();
	 //PAGINAS PRIVADAS
	// http.authorizeRequests().anyRequest("/entrenador").authenticated();
	 //http.authorizeRequests().anyRequest("/deportista").authenticated();
	 // Login form
	 http.formLogin().loginPage("/login");
	 http.formLogin().usernameParameter("email");
	 http.formLogin().passwordParameter("pass");
	 http.formLogin().defaultSuccessUrl("/");
	 http.formLogin().failureUrl("/loginerror");
	 // Logout
	 //http.logout().logoutUrl("/logout");
	 http.logout().logoutSuccessUrl("/");

	 // Disable CSRF at the moment
	 http.csrf().disable();
	}
}

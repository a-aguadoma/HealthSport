package com.example.AES.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UsuarioRepositoryAuthProvider authenticationProvider;
	
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
	 http.authorizeRequests().antMatchers("/nuevoEntrenador").permitAll();
	 http.authorizeRequests().antMatchers("/nuevoDeportista").permitAll();
	 //http.authorizeRequests().antMatchers("/equipoEntrenador").permitAll();
	 //http.authorizeRequests().antMatchers("/equipoDeportista").permitAll();

	 //PAGINAS PRIVADAS
	 http.authorizeRequests().antMatchers("/entrenador").hasAnyRole("ENTRENADOR");
	 http.authorizeRequests().antMatchers("/equipoEntrenador").hasAnyRole("ENTRENADOR");
	 http.authorizeRequests().antMatchers("/deportista").hasAnyRole("DEPORTISTA");
	 http.authorizeRequests().antMatchers("/equipoDeportista").hasAnyRole("DEPORTISTA");
	 //http.authorizeRequests().antMatchers("/").hasAnyRole("USER");
	 // Login form
	 http.formLogin().loginPage("/login");
	 http.formLogin().usernameParameter("email");
	 http.formLogin().passwordParameter("pass");
	 http.formLogin().defaultSuccessUrl("/perfil");
	 http.formLogin().failureUrl("/loginerror");
	 // Logout
	 http.logout().logoutUrl("/logout");
	 http.logout().logoutSuccessUrl("/");

	 // Disable CSRF at the moment
	 //http.csrf().disable();
	}
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		 // User
		 auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
		 
		 auth.inMemoryAuthentication().withUser("deportista").password("pass").roles("DEPORTISTA");
		 // Trainer
		 auth.inMemoryAuthentication().withUser("entrenador").password("pass").roles("ENTRENADOR");
		 // Admin 
		// auth.inMemoryAuthentication().withUser("Admin").password("adminpass").roles("CLIENT", "TRAINER", "ADMIN");
		 
		 
		 //Database authentication provider 
		 auth.authenticationProvider(authenticationProvider);
	}
}

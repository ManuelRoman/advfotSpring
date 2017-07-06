package com.advfot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuración sobreescrita de los roles de usuario y el login y logout de Security
 * @author usuario
 *
 */
@Configuration
@EnableWebSecurity //Activa la seguridad web
@EnableGlobalMethodSecurity(prePostEnabled=true) // Permite usar anotaciones para controlar el acceso a los métodos según el nivel de seguridad (Spring Security)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("loginService")
	private UserDetailsService loginService; //declaramos con la interfaz
	
	/**
	 * Método con el que añadimos el UserDetails, creado en el UsuarioServicio 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder()); // .passwordEncoder(new BCryptPasswordEncoder() -> cifra la clave en bbdd
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/*", "/fonts/*", "/js/*", "/fotogramas/*", "/verranking", "/compruebalogin", "/addUsuario", "/testAjax", "/loginDisponible1", "/loginDisponible2").permitAll() //peticiones autorizadas sin necesidad de login
			.anyRequest().authenticated() //las demás peticiones necesitan autentificación
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/logincheck") //indica la url formulario de logue y la url que lo procesa
			.usernameParameter("login").passwordParameter("clave")
			.defaultSuccessUrl("/loginsuccess").permitAll() //Url a la que va si el logueo es correcto y que es perimitidos a todos
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login?salir")
			.permitAll();
		super.configure(http);
	}

}

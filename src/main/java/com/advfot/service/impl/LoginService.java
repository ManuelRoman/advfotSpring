package com.advfot.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.advfot.entity.RolUsuario;
import com.advfot.entity.Usuario;
import com.advfot.repository.UsuarioRepository;

/**
 * Servicio encargado de autentifica al usuario, implementa
 * UserDatailsService de Spring Security
 * @author usuario
 *
 */
@Service("loginService")
public class LoginService implements UserDetailsService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	/**
	 * Método que se encarga de llamar al repositorio, obteniendo una entidad usuario del repositorio
	 * 	Devuleve un UserDetails, que contienen una entidad usuario, con las authorities (roles)
	 */
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);
		List<GrantedAuthority> authorities = buildAuthorities(usuario.getRolUsuario()); //obtenemos el listado de objetos authorities dandole los roles del usuario
		return buildUser(usuario, authorities);
	}

	/**
	 * Método encargado de construir el user de Spring Security
	 * @param usuario entidad
	 * @param authorities objeto de Spring Security, en realidad es la entidad rol
	 * @return objeto user que utiliza Spring Security
	 */
	private User buildUser(Usuario usuario, List<GrantedAuthority> authorities){
		// new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		return new User(usuario.getLogin(), usuario.getClave(), usuario.isActivo(), true, true, true, authorities); //true -> ya que no lo hemos contemplado en bbdd
	}

	/**
	 * Método que convierte los roles entidad a un listado GrantedAuthority, así
	 * Spring Security sabe los reles de usuario autentificado
	 * @param rolUsuario entidad
	 * @return authorities objeto de Spring Security
	 */
	private List<GrantedAuthority> buildAuthorities(Set<RolUsuario> rolUsuarios){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		//Recorremos las lista rolUsuarios
		for(RolUsuario rolUsuario : rolUsuarios){
			// Añadimos en auths el rol correspondiente
			auths.add(new SimpleGrantedAuthority(rolUsuario.getRol()));
		}
		// Devolvemos un ArrayList de GrantedAuthority con las auths
		return new ArrayList<GrantedAuthority>(auths);
	}
	
}

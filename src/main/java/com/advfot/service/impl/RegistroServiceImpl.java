package com.advfot.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.advfot.entity.Concurso;
import com.advfot.entity.Ranking;
import com.advfot.entity.RolUsuario;
import com.advfot.entity.Usuario;
import com.advfot.repository.UsuarioRepository;
import com.advfot.service.RegistroService;

@Service("registroServiceImpl")
public class RegistroServiceImpl implements RegistroService{

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Override
	public boolean existeLogin(String login) {
		boolean existe = false;
		Usuario usuario = usuarioRepository.findByLogin(login);
		if (usuario != null){
			existe = true;
		}
		return existe;
	}

	@Override
	public boolean addUsuario(String login, String clave) {
		boolean registro = true;
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		Usuario usuario = new Usuario(login, pe.encode(clave), true);
		RolUsuario rolUsuario = new RolUsuario(usuario, "ROLE_USER");
		Set<RolUsuario> rolesUsuario = new HashSet<RolUsuario>();
		rolesUsuario.add(rolUsuario);
		Concurso concurso = new Concurso(login);
		Ranking ranking = new Ranking(login, 0);
		usuario.setConcurso(concurso);
		usuario.setRanking(ranking);
		usuario.setRolUsuario(rolesUsuario);
		if (usuarioRepository.save(usuario) == null){
			registro = false;
		}
		return registro;
	}

}

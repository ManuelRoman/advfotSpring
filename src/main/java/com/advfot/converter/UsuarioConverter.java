package com.advfot.converter;

import org.springframework.stereotype.Component;

import com.advfot.entity.Usuario;
import com.advfot.model.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public Usuario ModelToEntity(UsuarioModel usuarioModel){
		Usuario usuario = new Usuario();
		usuario.setLogin(usuarioModel.getLogin());
		usuario.setClave(usuarioModel.getClave());
		return usuario;
	}

	public UsuarioModel EntityToModel(Usuario usuario){
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setLogin(usuario.getLogin());
		usuarioModel.setClave(usuario.getClave());
		return usuarioModel;
	}

}

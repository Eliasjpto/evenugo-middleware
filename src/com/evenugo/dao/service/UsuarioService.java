package com.evenugo.dao.service;

import java.sql.Connection;

import org.apache.commons.mail.EmailException;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.exceptions.MailException;
import com.evenugo.model.Usuario;

public interface UsuarioService {
	public Usuario  findByID(long PK)
			throws DataException;
		
	public Usuario findByEmail (String email)
			throws DataException;
	
//	public void login (String email,String password)
//	throws DataExeception;
	
	 public void update(Usuario o)
			 throws DataException;
	 
	 public Usuario create(Usuario u) 
	 
		    	throws DataException, MailException;
	 
	 public long delete(Long id) 
		    	throws  DataException;
	 //DARSE DE BAJA ... recuperar contraseña ..
}

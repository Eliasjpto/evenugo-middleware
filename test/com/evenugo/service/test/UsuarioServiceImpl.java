package com.evenugo.service.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.evenugo.dao.EventoDao;
import com.evenugo.dao.UsuarioDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.impl.EventoDaoImpl;
import com.evenugo.dao.impl.UsuarioDaoImpl;
import com.evenugo.dao.service.UsuarioService;
import com.evenugo.exceptions.MailException;
import com.evenugo.model.Usuario;
import com.evenugo.util.DBUtils;

public class UsuarioServiceImpl implements UsuarioService {
	private UsuarioDao usuario = null;
	public UsuarioServiceImpl () {
		usuario = new UsuarioDaoImpl(); 
	}
	public Usuario  findByID(long PK)
			throws DataException{
		Connection connection = null;

		try {

			connection = DBUtils.conectar();
			connection.setAutoCommit(true);

			return usuario.findByID(connection, PK);
		} catch (SQLException e){

			throw new DataException(e);
		} finally {
			//		 DBUtils.closeResultSet(resultSet);
			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
			DBUtils.closeConnection(connection);	

		}
		
	}
		
	public Usuario findByEmail (String email)
			throws DataException{
		Connection connection = null;

		try {

			connection = DBUtils.conectar();
			connection.setAutoCommit(true);

			return usuario.findByEmail(connection, email);
		} catch (SQLException e){

			throw new DataException(e);
		} finally {
			//		 DBUtils.closeResultSet(resultSet);
			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
			DBUtils.closeConnection(connection);	

		}
	}


	 public void update(Usuario o)
			 throws DataException{
		 
	 }
	@Override
	public Usuario create(Usuario u) throws DataException, MailException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long delete(Long id) throws DataException {
		// TODO Auto-generated method stub
		return 0;
	}
}
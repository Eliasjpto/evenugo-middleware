package com.evenugo.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.evenugo.dao.EventoDao;
import com.evenugo.dao.UsuarioDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.impl.EventoDaoImpl;
import com.evenugo.dao.impl.UsuarioDaoImpl;
import com.evenugo.service.MailService;
import com.evenugo.service.UsuarioService;
import com.evenugo.exceptions.MailException;
import com.evenugo.model.Usuario;
import com.evenugo.util.DBUtils;
import com.*;

public class UsuarioServiceImpl implements UsuarioService {
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(UsuarioServiceImpl.class.getName());
	private UsuarioDao usuario = null;
	private MailService mailService = null;


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

	@Override
	public Usuario create(Usuario u) 

			throws	 DataException,MailException {


		Connection cn = null;
		boolean commit = false;

		try {

			cn = DBUtils.conectar();
			

			cn.setAutoCommit(false);

			Usuario result =  usuario.create(cn,u);
			mailService.sendMail("Benvido a evenugo", "jjeeje!", u.getEmail());

			commit = true;

			return result;

		} catch (SQLException e) {
			throw new DataException(e);
		//	logger.info("Usuario: ");

		} finally {
			DBUtils.closeConnection(cn, commit);
		}	
	}

	@Override
	public long delete(Long id) throws DataException {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void update(Usuario u)
			throws DataException{
		Connection cn = null;
		boolean commit = false;

		try {

			cn = DBUtils.conectar();

			cn.setTransactionIsolation(
					Connection.TRANSACTION_READ_COMMITTED);

			cn.setAutoCommit(false);

			usuario.update(cn,u);
			commit = true;

		} catch (SQLException e) {
			throw new DataException(e);

		} finally {
			DBUtils.closeConnection(cn, commit);
		}
	}



	//	@Override
	//	public long delete(Long id) throws DataException {
	//		/ Connection connection = null;
	//        boolean commit = false;
	//
	//        try {
	//          
	//            connection = ConnectionManager.getConnection();
	//
	//            connection.setTransactionIsolation(
	//                    Connection.TRANSACTION_READ_COMMITTED);
	//
	//            connection.setAutoCommit(false);
	//
	//            	            long result = dao.delete(connection, id);            
	//            commit = true;            
	//            return result;
	//            
	//        } catch (SQLException e) {
	//            throw new DataException(e);
	//
	//        } finally {
	//        	JDBCUtils.closeConnection(connection, commit);
	//        }		
	//	}
	//	}
}
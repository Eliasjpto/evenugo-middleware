package com.evenugo.dao.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.evenugo.dao.EventoDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.impl.EventoDaoImpl;
import com.evenugo.dao.service.EventoService;
import com.evenugo.model.Evento;
import com.evenugo.model.criteria.EventoCriteria;
import com.evenugo.util.DBUtils;
 
public class EventoServiceImpl implements EventoService  {	
	private EventoDao evento = null;
	public EventoServiceImpl () {
		evento= new EventoDaoImpl(); 
	}

	public Evento findById(Long pk, String idioma)
			throws DataException{

		Connection connection = null;

		try {

			connection = DBUtils.conectar();
			connection.setAutoCommit(true);

			return evento.findById(connection, pk, idioma);
		} catch (SQLException e){

			throw new DataException(e);
		} finally {
			//		 DBUtils.closeResultSet(resultSet);
			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
			DBUtils.closeConnection(connection);	

		}

	}
	public Evento findByNombre(String nombre,String idioma) 
			throws DataException{
		Connection cn = null;

		try {

			cn = DBUtils.conectar();
			cn.setAutoCommit(true);

			return evento.findByNombre(cn, nombre, idioma);
		} catch (SQLException e){

			throw new DataException(e);
		} finally {
			//		 DBUtils.closeResultSet(resultSet);
			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
			DBUtils.closeConnection(cn);	
		}

		
	}
	public List<Evento> findByCriteria(EventoCriteria c,String idioma)
			throws DataException{
		Connection connection = null;

		try {

			connection = DBUtils.conectar();
			connection.setAutoCommit(true);

			return evento.findByCriteria(connection, c, idioma);
		} catch (SQLException e){

			throw new DataException(e);
		} finally {
			//		 DBUtils.closeResultSet(resultSet);
			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
			DBUtils.closeConnection(connection);


		}
	}
//
//
//
//	//public List<Evento> findAll (String idioma);
//	public List<Evento> findByName( String name,String idioma)
//			throws DataException{
//		Connection connection = null;
//
//		try {
//
//			connection = DBUtils.conectar();
//			connection.setAutoCommit(true);
//
//			return evento.findByName(connection, name, idioma);
//		} catch (SQLException e){
//
//			throw new DataException(e);
//		} finally {
//			//		 DBUtils.closeResultSet(resultSet);
//			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
//			DBUtils.closeConnection(connection);
//
//
//		}
//	}
//
//
//
//	public List<Evento> findTipoEvento(long idTipoEvento,String idioma)
//			throws DataException{
//		Connection connection = null;
//
//		try {
//
//			connection = DBUtils.conectar();
//			connection.setAutoCommit(true);
//
//			return evento.findTipoEvento(connection, idTipoEvento, idioma);
//		} catch (SQLException e){
//
//			throw new DataException(e);
//		} finally {
//			//		 DBUtils.closeResultSet(resultSet);
//			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
//			DBUtils.closeConnection(connection);
//
//
//		}
//	}

}




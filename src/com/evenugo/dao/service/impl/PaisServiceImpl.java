package com.evenugo.dao.service.impl;
import java.sql.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evenugo.dao.PaisDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.impl.PaisDaoImpl;
import com.evenugo.dao.service.*;
import com.evenugo.model.Pais;
import com.evenugo.model.Provincia;
import com.evenugo.util.DBUtils;

public class PaisServiceImpl implements PaisService{


	private PaisDao pais = null;
	public PaisServiceImpl () {
		pais = new PaisDaoImpl(); 


	}
	@Override
	public List<Pais> findByIdioma( String idioma)
			throws DataException {
		Connection connection = null;

		try {

			connection = DBUtils.conectar();
			connection.setAutoCommit(true);

			return pais.findByIdioma(connection, idioma);
		} catch (SQLException e){

			throw new DataException(e);
		} finally {
			//		 DBUtils.closeResultSet(resultSet);
			//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
			DBUtils.closeConnection(connection);


		}
	}

	@Override
	public  Pais findByPK(Long PK)
			throws DataException{
			Connection connection = null;

			try {

				connection = DBUtils.conectar();
				connection.setAutoCommit(true);

				return pais.findByPK(connection, PK);
			} catch (SQLException e){

				throw new DataException(e);
			} finally {
				//		 DBUtils.closeResultSet(resultSet);
				//		 DBUtils.closeStatement();  se cierra en el paisdaoimp 
				DBUtils.closeConnection(connection);	

			}
	}
	@Override
	public List<Provincia> findByNombre(String nombre) throws DataException {
//		List <Provincia> provincias = new ArrayList<Provincia>();
//		 Provincia p = new Provincia ();
//		 Provincia e = new Provincia ();
//		 p.getNombre();
//		 
//		e.add("eeeee");
//		
//		
//		
//		
		return null;
	}
}


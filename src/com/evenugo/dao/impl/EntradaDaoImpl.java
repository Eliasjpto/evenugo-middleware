package com.evenugo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.evenugo.dao.EntradaDao;
import com.evenugo.dao.EventoDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.*;
import com.evenugo.util.DBUtils;

public class EntradaDaoImpl implements EntradaDao{

	@Override
	public Entrada findByID(Connection cn,long PK) throws DataException {
		PreparedStatement preparedStatement = null;
		String query = null;
		ResultSet rs = null;
		Entrada e = new Entrada ();  // Pais loquesea = new Pais(); 

		try {
			//Crear una sentencia SQL y Meter en rs el resultado de la query.
			query =  "SELECT P.ID_PAIS,P.ID_IDIOMA"
					+" FROM PAIS P"
					+"INNER JOIN IDIOMA I  ON I.ID_IDIOMA = P.ID_IDIOMA "
					+" WHERE P.ID_IDIOMA = ?";

			preparedStatement = cn.prepareStatement(query);
			System.out.println(query);


			int i = 1;
			preparedStatement.setLong(i++, PK);



			while (rs.next()) {
				e = loadNext(rs);
			}			
			return e ;

		} catch (SQLException er) {
			System.out.println("Problema en la Query.");
			throw new DataException(er);
		}  finally {
			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(preparedStatement);
		}
	}	
	

	@Override
	public List<Entrada> findEvento(Connection cn,long idEvento) throws 
	DataException {
		
		PreparedStatement preparedStatement = null;
		String query = null;
		ResultSet rs = null;
		List<Entrada> entradas = new ArrayList<Entrada>();  // Pais loquesea = new Pais(); 

		try {
			//Crear una sentencia SQL y Meter en rs el resultado de la query.
			query =  "SELECT P.ID_PAIS,P.ID_IDIOMA"
					+" FROM PAIS P"
					+"INNER JOIN IDIOMA I  ON I.ID_IDIOMA = P.ID_IDIOMA "
					+" WHERE P.ID_IDIOMA = ?";

			preparedStatement = cn.prepareStatement(query);
			System.out.println(query);


			int i = 1;
			preparedStatement.setLong(i++, idEvento);



			while (rs.next()) {
				entradas.add(loadNext(rs));
			}			
			return entradas;

		} catch (SQLException e) {
			System.out.println("Problema en la Query.");
			throw new DataException(e);
		}  finally {
			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(preparedStatement);
		}
	}
	

	@Override
	public List<Entrada> findByUsuario(Connection cn,Long idUsuario) throws DataException {
		PreparedStatement preparedStatement = null;
		String query = null;
		ResultSet rs = null;
		List<Entrada> entradas = new ArrayList<Entrada>();  // Pais loquesea = new Pais(); 

		try {
			//Crear una sentencia SQL y Meter en rs el resultado de la query.
			query =  "SELECT P.ID_PAIS,P.ID_IDIOMA"
					+" FROM PAIS P"
					+"INNER JOIN IDIOMA I  ON I.ID_IDIOMA = P.ID_IDIOMA "
					+" WHERE P.ID_IDIOMA = ?";

			preparedStatement = cn.prepareStatement(query);
			System.out.println(query);


			int i = 1;
			preparedStatement.setLong(i++, idUsuario);



			while (rs.next()) {
				entradas.add(loadNext(rs));
			}			
			return entradas;

		} catch (SQLException e) {
			System.out.println("Problema en la Query.");
			throw new DataException(e);
		}  finally {
			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(preparedStatement);
		}
	}
		
		
	
	
	@Override
	public void create(Connection connection,List<Entrada> e) throws DataException {
		// TODO Auto-generated method stub
		
	}

	protected Entrada loadNext(ResultSet rs)
			throws SQLException,DataException {	
		int i = 1;
		Entrada  e = new Entrada ();
		e.setIdEvento(rs.getLong(i++));
		e.setLocalizador(rs.getLong(i++));
		e.setNumero(rs.getInt(i++));
		e.setPrecio(rs.getDouble(i++)); 
		e.setIdUsuario(rs.getLong(i++));
	return e; }
	
}

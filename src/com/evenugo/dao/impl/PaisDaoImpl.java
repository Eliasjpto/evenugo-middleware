package com.evenugo.dao.impl;

import com.evenugo.dao.PaisDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.Evento;
import com.evenugo.model.Pais;
import com.evenugo.model.Usuario;
import com.evenugo.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class PaisDaoImpl implements PaisDao {
	private static Logger logger = LogManager.getLogger(PaisDaoImpl.class.getName());
	
	@Override
	public List<Pais> findByIdioma(Connection cn, String idioma)
			throws DataException{


		PreparedStatement preparedStatement = null;
		String query = null;
		ResultSet rs = null;
		List<Pais> paises = new ArrayList<Pais>();  // Pais loquesea = new Pais(); 

		try {
			//Crear una sentencia SQL y Meter en rs el resultado de la query.
			query = "SELECT pi.ID_PAIS,pi.ID_IDIOMA,NOMBRE"
					+" FROM pais_idioma pi"
					+" WHERE pi.ID_IDIOMA = ? ";

			preparedStatement = cn.prepareStatement(query);
			System.out.println(query);


			int i = 1;
			preparedStatement.setString(i++, idioma);

			rs = preparedStatement.executeQuery();
        // ejecutar query
			while (rs.next()) {
				paises.add(loadNext(rs));
			}			
			return paises;

		} catch (SQLException e) {
			System.out.println("Problema en la Query.");
			throw new DataException(e);
		}  finally {
			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(preparedStatement);
		}
	}

		@Override
		public Pais findByPK(Connection cn,Long PK)
				throws DataException {
			// TODO Auto-generated method stub
			String query = null;
			PreparedStatement preparedStatement = null;
		ResultSet rs = null;
			Pais pais  = null;
			try {
				query =  "SELECT pi.ID_PAIS,pi.ID_IDIOMA,NOMBRE"
						+" FROM pais_idioma pi"
						+" WHere pi.ID_PAIS= ?";

				preparedStatement = cn.prepareStatement(query);
				System.out.println(query);


				int i = 1;
				preparedStatement.setLong(i++, PK);

				rs = preparedStatement.executeQuery();

				while (rs.next()) {
					pais = loadNext(rs);
				}			
				return pais;

			} catch (SQLException e) {
				System.out.println("Problema en la Query.");
				throw new DataException(e);
			}  finally {
				DBUtils.closeResultSet(rs);
				DBUtils.closeStatement(preparedStatement);
			}
		}
	protected Pais loadNext(ResultSet rs)
			throws SQLException {	
		int i = 1;
		Pais p = new Pais ();
		p.setPK(rs.getLong(i++));
		p.setIdioma(rs.getString(i++));
		p.setNombre(rs.getString(i++));
		return p;
	}
}
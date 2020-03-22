package com.evenugo.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.evenugo.dao.EventoDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.Evento;
import com.evenugo.model.TipoEvento;
import com.evenugo.model.criteria.EventoCriteria;
import com.evenugo.util.DBUtils;
import com.evenugo.util.SQLUtils;

public class EventoDaoImpl implements EventoDao {
	private static Logger logger = LogManager.getLogger(EventoDaoImpl.class.getName());

	@Override
	public Evento findById(Connection cn,Long pk,String idioma) 
			throws DataException{
		logger.debug("findById {} {}", pk, idioma);
		Evento evento =null;
		String query = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;


		try {
			cn = DBUtils.conectar();


			query = "select ei.NOMBRE, e.ID_EVENTO, e.FECHA_HORA,e.ID_TIPO_EVENTO,e.ID_PROMOTOR, "
					+ " e.ID_LOCALIDAD, e.AFOROTOTAL,e.DIRECCION,ei.DESCRIPCION, AVG(v.PUNTUACION) "
					+ " from evento e" 
					+ " INNER JOIN  evento_idioma ei ON ei.ID_EVENTO = e.ID_EVENTO "
					+ " INNER JOIN  valoracion v  ON v.ID_EVENTO = e.ID_EVENTO " 					
					+ " where e.ID_EVENTO = ? and ei.ID_IDIOMA = ? " 
					+  " GROUP BY e.ID_EVENTO ";


			preparedStatement = cn.prepareStatement(query);
			logger.info(query);

			int i = 1;
			preparedStatement.setLong(i++, pk);
			preparedStatement.setString(i++, idioma);

			rs = preparedStatement.executeQuery();

			if(rs.next()) {
				evento = loadNext(rs);
			}
		} catch (SQLException e) {
			System.out.println("Problema en la Query.");
			logger.fatal("idEvento :"+pk,"idIdioma : "+idioma);
			throw new DataException(e);
		} finally {
			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(preparedStatement);
		}
		return evento;
	}


	@Override
	public List<Evento> findByCriteria(Connection cn,EventoCriteria c,String idioma)
			throws DataException{

		PreparedStatement preparedStatement = null;
		String query = null;
		ResultSet rs = null;
		List<Evento> eventos = new ArrayList<Evento>();  // Pais loquesea = new Pais(); 
		cn = DBUtils.conectar();
		try {
			//Crear una sentencia SQL y Meter en rs el resultado de la query.
			StringBuilder sb = new StringBuilder(
					"select ei.NOMBRE, e.ID_EVENTO, e.FECHA_HORA,e.ID_TIPO_EVENTO,e.ID_PROMOTOR, "
							+ " e.ID_LOCALIDAD, e.AFOROTOTAL,e.DIRECCION,ei.DESCRIPCION, AVG(v.PUNTUACION) "
							+ " from evento e" 
							+ " INNER JOIN  evento_idioma ei ON ei.ID_EVENTO = e.ID_EVENTO "
							+ " INNER JOIN  valoracion v  ON v.ID_EVENTO = e.ID_EVENTO "); 


			if (c.getIdTipoEvento()!=null) {				
				sb.append(" INNER JOIN   tipo_evento te ON te.ID_TIPO_EVENTO = e.ID_TIPO_EVENTO ");				
			}



			// Siempre va a haber where por idioma
			sb.append(" WHERE ei.ID_IDIOMA = ? ");

			boolean first = false; // porque ya se ha añadido el where por idioma

			first = SQLUtils.addClause(c.getIdTipoEvento(), sb, first," te.ID_TIPO_EVENTO = ? ");
			first = SQLUtils.addClause(c.getIdLocalidad(), sb, first," e.ID_LOCALIDAD = ? ");

			first = SQLUtils.addClause(c.getNombre(), sb, first, " UPPER(ei.NOMBRE) LIKE UPPER (?) ");
			logger.fatal("llegamos c");
			first = SQLUtils.addClause(c.getFechaDesde(), sb, first," e.FECHA_HORA  >= ? ");
			logger.fatal("llegamos c");
			first = SQLUtils.addClause(c.getFechaHasta(), sb, first," e.FECHA_HORA  <= ? ");
			logger.fatal("llegamos c");




			sb.append(" GROUP BY e.ID_EVENTO ");

			if (c.getValoracionMin()!=null) {
				sb.append(" HAVING AVG(v.puntuacion) >= ? ");
			}

			query = sb.toString();
			logger.info("Consulta compuesta en base al criteria:" +query);


			preparedStatement = cn.prepareStatement(query);



			// Set de los valores de los parametros
			int i = 1;

			preparedStatement.setString(i++, idioma);

			if (c.getIdTipoEvento()!=null) {			
				preparedStatement.setLong(i++, c.getIdTipoEvento());
			}

			if (c.getIdLocalidad()!=null) {		 
				preparedStatement.setLong(i++, c.getIdLocalidad());
			}


			if (c.getFechaDesde()!=null) {
				preparedStatement.setDate(i++, new java.sql.Date(c.getFechaDesde().getTime()));
			}
			////
			if (c.getFechaHasta()!=null) {
				preparedStatement.setDate(i++, new java.sql.Date(c.getFechaHasta().getTime()));
			}
			//////
			if (c.getNombre()!=null) {	
				preparedStatement.setString(i++, "%"+c.getNombre()+"%");
				logger.fatal("llegamos");
			}



			if (c.getValoracionMin()!=null) {	
				preparedStatement.setInt(i++, c.getValoracionMin());
			}

			// Ejecuta la query
			rs = preparedStatement.executeQuery();

			// Resultados  el listado de resultados
			while (rs.next()) {
				eventos.add(loadNext(rs));
			}

			logger.info("Encontrados "+eventos.size()+" resultados");
		} catch (SQLException e) {

			logger.fatal("no ah ido bien la query :" );
			throw new DataException(e);
		}
		return eventos;
	}	

	protected Evento loadNext(ResultSet rs)
			throws SQLException,DataException {	
		int i = 1;
		Evento  e = new Evento ();
		e.setNombre(rs.getString(i++));
		e.setPK(rs.getLong(i++)); 
		e.setFecha(rs.getDate(i++));
		e.setIdTipoEvento(rs.getLong(i++));
		e.setIdPromotor(rs.getLong(i++));
		e.setIdLocalidad(rs.getLong(i++));
		e.setAforo(rs.getInt(i++));
		e.setDireccion(rs.getString(i++));
		e.setDescripcion(rs.getString(i++));
		e.setValoracionMedia(rs.getDouble(i++));
		return e;
	}
}


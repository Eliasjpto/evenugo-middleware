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
		//  meterle el id de idioma
		Evento evento =null;
		String query = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;


		try {
			cn = DBUtils.conectar();


			query = "select ei.NOMBRE, e.ID_EVENTO,e.FECHA_HORA,e.ID_TIPO_EVENTO,e.ID_PROMOTOR,e.ID_LOCALIDAD,e.AFOROTOTAL,e.DIRECCION,ei.DESCRIPCION,ei.ID_IDIOMA"
					+ " from evento e" 
					+ " INNER JOIN   evento_idioma ei ON ei.ID_EVENTO = e.ID_EVENTO"
					+ " where e.ID_EVENTO = ? and ei.ID_IDIOMA = ?";


			// en sql puedo sacar evento 1 sin haberlo creado
			preparedStatement = cn.prepareStatement(query);
			System.out.println(query);
			logger.info("aviso");

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
	public Evento findByNombre(Connection cn,String nombre,String idioma) 
			throws DataException{
		//  meterle el id de idioma
		Evento evento =null;
		String query = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;


		try {
			cn = DBUtils.conectar();


			query = "select ei.NOMBRE, e.ID_EVENTO,e.FECHA_HORA,e.ID_TIPO_EVENTO,e.ID_PROMOTOR,e.ID_LOCALIDAD,e.AFOROTOTAL,e.DIRECCION,ei.DESCRIPCION,ei.ID_IDIOMA"
					+ " from evento e" 
					+ " INNER JOIN   evento_idioma ei ON ei.ID_EVENTO = e.ID_EVENTO"
					+ " where ei.NOMBRE like ? and ei.ID_IDIOMA = ?";

			//	where upper(ei.NOMBRE) like upper("%S%") and ei.ID_IDIOMA = "ESP" ;


			// en sql puedo sacar evento 1 sin haberlo creado
			preparedStatement = cn.prepareStatement(query);
			System.out.println(query);
			logger.info("aviso");

			int i = 1;
			preparedStatement.setString(i++, nombre);
			preparedStatement.setString(i++, idioma);

			rs = preparedStatement.executeQuery();

			if(rs.next()) {
				evento = loadNext(rs);
			}
		} catch (SQLException e) {
			System.out.println("Problema en la Query.");
			//	 logger.fatal("idEvento :"+pk,"idIdioma : "+idioma);
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
					"select ei.NOMBRE, e.ID_EVENTO,e.FECHA_HORA,e.ID_TIPO_EVENTO,e.ID_PROMOTOR,e.ID_LOCALIDAD,e.AFOROTOTAL,e.DIRECCION,ei.DESCRIPCION,ei.ID_IDIOMA,e.ID_LOCALIDAD,v. "
							+ " from evento e "
							+ " INNER JOIN   evento_idioma ei ON ei.ID_EVENTO = e.ID_EVENTO "
					);

			if (c.getIdTipoEvento()!=null) {				
				sb.append(" INNER JOIN   tipo_evento te ON te.ID_TIPO_EVENTO = e.ID_TIPO_EVENTO ");				
			}
			//						if (c.getValoracionMin()!=null) {				
			//							sb.append(" AND v.PUNTUACION = ? ");	 	// 		left outerjoin 
			//						}
			// mirar que me salga valoracion yen  id y en criteria  busqueda por id y la valoracion  a�adir en la busqueda por  a�adir sacar valoracion 


			boolean first = true;
			first = SQLUtils.addClause(c.getIdLocalidad(), sb, first," e.ID_LOCALIDAD = ? "
					);  logger.fatal("llegamos ad");
					first = SQLUtils.addClause(c.getNombre(), sb, first, " UPPER(ei.NOMBRE) LIKE UPPER (?) ");
					logger.fatal("llegamos c");
					first = SQLUtils.addClause(c.getFechaDesde(), sb, first,"e.FECHA_HORA  > ? ");
					first = SQLUtils.addClause(c.getFechaHasta(), sb, first,"e.FECHA_HORA  < ? ");
					first = SQLUtils.addClause(c.getIdTipoEvento(), sb, first," te.ID_TIPO_EVENTO = ? ");

					if (c.getValoracionMin()!=null) {			
						sb.append(" GROUP BY e.ID_EVENTO ");
						sb.append(" HAVING AVG(P.VALORACION) > ? "
								+ " where e.ID_EVENTO = ? and ei.ID_IDIOMA = ?" );
					}

					query = sb.toString();
					logger.info("resultado de la consulta :" +query );


					preparedStatement = cn.prepareStatement(query);

					int i = 1;

					if (c.getIdLocalidad()!=null) {		
						//		//		andlocalidad takata 
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
					if (c.getIdTipoEvento()!=null) {			
						preparedStatement.setLong(i++, c.getIdTipoEvento());
					}


					if (c.getValoracionMin()!=null) {	
						preparedStatement.setInt(i++, c.getValoracionMin());
					}

					rs = preparedStatement.executeQuery();
					////
					////
					while (rs.next()) {
						eventos.add(loadNext (rs));
					}
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
		return e;
	}

	//	reparedStatement = cn.prepareStatement(query);

	//		preparedStatement.setDate(i++, new java.sql.Date(fechaDesde.getTime()));
	//		preparedStatement.setDate(i++, new java.sql.Date(fechaHasta.getTime()));
}

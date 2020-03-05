package com.evenugo.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.Evento;
import com.evenugo.model.TipoEvento;
import com.evenugo.model.criteria.EventoCriteria;

public interface EventoDao {

	public Evento findById(Connection connection,Long pk, String idioma)
			throws DataException;//  meterle el id de idioma
	public Evento findByNombre(Connection cn,String nombre,String idioma) 
			throws DataException;

	public List<Evento> findByCriteria(Connection connection,EventoCriteria c,String idioma)
			throws DataException;

//	//public List<Evento> findAll (String idioma);
//	public List<Evento> findByName( Connection connection,String name,String idioma)
//			throws DataException;
//
//	public List<Evento> findTipoEvento(Connection connection,long idTipoEvento,String idioma)
//		throws DataException;


	//	public void create(Evento e);
	//	
	//	public void update(Evento e);
	//	
	//	public void delete(long id);


}


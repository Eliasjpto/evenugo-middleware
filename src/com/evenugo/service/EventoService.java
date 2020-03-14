package com.evenugo.service;

import java.sql.Connection;
import java.util.List;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.Evento;
import com.evenugo.model.criteria.EventoCriteria;

public interface EventoService {
	
	public Evento findById(Long pk, String idioma)
			throws DataException;//  meterle el id de idioma


	public List<Evento> findByCriteria(EventoCriteria c,String idioma)
			throws DataException;

//	//public List<Evento> findAll (String idioma);
//	public List<Evento> findByName( String name,String idioma)
//			throws DataException;

//	public List<Evento> findTipoEvento(long idTipoEvento,String idioma)
//			throws DataException;

}

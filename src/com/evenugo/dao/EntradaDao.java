package com.evenugo.dao;
import java.sql.Connection;
import java.util.List;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.Entrada;
public interface EntradaDao {

// valoraicon usuario y avg ...  star index ,, para paginar count que es de 10 en 10 criterio de relacion ..order by que en paginar
	
	public Entrada findByID(Connection connection,long PK)throws DataException; // generar dependencia sin evento no hay entrada ?
	public List<Entrada> findEvento(Connection connection,long idEvento)throws DataException;
	public List<Entrada> findByUsuario(Connection connection,Long idUsuario)throws DataException;
	
	public void create(Connection connection,List<Entrada> e)throws DataException;
	// update
	// delete
}
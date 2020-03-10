package com.evenugo.dao.service;

import java.sql.Connection;
import java.util.List;
import com.evenugo.dao.*;
import com.evenugo.dao.impl.*;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.Pais;
import com.evenugo.model.Provincia;

public interface PaisService {

	public List<Pais> findByIdioma( String idioma)
			throws DataException;

 	public  Pais findByPK(Long PK)
			throws DataException;
 	public List <Provincia> findByNombre (String nombre) throws DataException;
}

package com.evenugo.dao;
import java.sql.*;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.*;
import java.util.*;
import com.evenugo.util.DBUtils;

public interface PaisDao {


//findbyall añadir.

		public List<Pais> findByIdioma(Connection connection, String idioma)
				throws DataException;

    	public  Pais findByPK(Connection connection,Long PK)
  			throws DataException;

		
}

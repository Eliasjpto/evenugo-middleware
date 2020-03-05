package com.evenugo.dao;
import java.sql.Connection;
import java.util.List;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.model.*;
import com.evenugo.util.DBUtils;

public interface UsuarioDao {
	
public Usuario  findByID(Connection connection,long PK)
		throws DataException;
	
public Usuario findByEmail (Connection connection,String email)
		throws DataException;
//
public  Usuario create(Connection connection, Usuario user) 
		throws  DataException;

 public void update(Connection connection,Usuario o)
		 throws DataException;
 
// public long delete(Connection connection, Long id) 
// 		throws  DataException;

}

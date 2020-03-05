package com.evenugo.dao;
import com.evenugo.model.*;
import java.util.List;
import java.sql.*;
public interface LocalidadDao{

	public List <Localidad> findByIdpProvincia (Connection c,int IDProvincia);
	public List <Localidad> findByNombre (Connection c,String nombre);

}
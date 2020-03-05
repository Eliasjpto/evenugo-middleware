package com.evenugo.dao;

import java.util.List;

import com.evenugo.model.*;

public interface ProvinciaDao {
	public List<Provincia> findByName(String nombre);
	public List<Provincia> findByPais(int Idpais);
}

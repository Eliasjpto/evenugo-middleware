package com.evenugo.service.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import com.evenugo.dao.PaisDao;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.impl.PaisDaoImpl;
import com.evenugo.dao.service.PaisService;
import com.evenugo.dao.service.impl.PaisServiceImpl;
import com.evenugo.model.Pais;

public class PaisServiceTest {
	public static void testFindByIdioma() throws DataException {

		PaisService pa = new PaisServiceImpl();
		List<Pais> paises = pa.findByIdioma("FRA");
		for (Pais p :paises) {
			System.out.println(p);
		}

	}
	public static void testFindById() throws DataException {

		PaisService pa = new PaisServiceImpl();
		Pais p = pa.findByPK((long) 8);
		System.out.println(p);
		}

	


	public static void main(String[] args) throws DataException {
		// TODO Auto-generated method stub
		testFindByIdioma();
		testFindById();
	}

}

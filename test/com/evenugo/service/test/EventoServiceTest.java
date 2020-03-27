package com.evenugo.service.test;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.impl.EventoDaoImpl;
import com.evenugo.service.EventoService;
import com.evenugo.service.impl.EventoServiceImpl;
import com.evenugo.model.Evento;
import com.evenugo.model.criteria.EventoCriteria;
import java.util.Date;
public class EventoServiceTest {
	private static Logger logger = LogManager.getLogger(EventoServiceTest.class.getName());
	
	private EventoService eventoService = null;
	
	public EventoServiceTest() {
		eventoService = new EventoServiceImpl();
	}

	
	public void testFindAll() throws DataException {	
		logger.info("Testing testFindAll...");
		// Sin ninguno criterio, solo el idioma
		EventoCriteria c = new EventoCriteria();		
		List<Evento>results = eventoService.findByCriteria(c, "ENG");
		for (Evento e: results) {
			System.out.println(e);
		}
		logger.info("testFindAll done!");
	}
	

	
	public void testFindById() throws DataException {	
		logger.info("Testing findById...");
		Evento e = eventoService.findById((long) 8, "ENG");
		System.out.println(e);
		logger.info("findById done!");
	}
	
	// Test de cada uno de los criterios, de manera individual
	public void testFindByTipo() throws DataException {
		logger.info("Testing testFindByTipo...");
		EventoCriteria c = new EventoCriteria();
		c.setIdTipoEvento(2L);
		List<Evento>results = eventoService.findByCriteria(c, "ESP");
		for (Evento e: results) {
			System.out.println(e);
		}
		logger.info("testFindByTipo done!");
	}
	
	public void testFindByLocalidad() throws DataException {
		logger.info("Testing testFindByLocalidad...");
		EventoCriteria c = new EventoCriteria();
		c.setIdLocalidad((long) 4);
		List<Evento> results = eventoService.findByCriteria(c, "ESP");	
		for (Evento e: results) {
			System.out.println(e);
		}
		logger.info("testFindByLocalidad done!");
	}
	
	public void testFindByNombre() throws DataException {
		logger.info("Testing testFindByNombre...");
		EventoCriteria c = new EventoCriteria();
		c.setNombre("Ros");
		List<Evento>results = eventoService.findByCriteria(c, "ENG");	
		for (Evento e: results) {
			System.out.println(e);
		}
	}
	


	public void testFindByFechaDesde() throws DataException {
		EventoCriteria c = new EventoCriteria();
		java.util.Date e = new java.util.Date();
		java.sql.Date i = new java.sql.Date((2019-02-01));
		e =i ;
		c.setFechaDesde(e);
	
		 	
		
		List<Evento>results = eventoService.findByCriteria(c, "ESP");	
		for (Evento ee: results) {
			System.out.println(ee);
		}
	}
	public void testFindByFechaHasta() throws DataException {
		EventoCriteria c = new EventoCriteria();
		
		java.util.Date u = new java.util.Date();
		java.sql.Date p = new java.sql.Date((2018-02-01));
		u =p ;
		c.setFechaHasta(u);
		List<Evento>results = eventoService.findByCriteria(c, "ESP");	
		for (Evento ee: results) {
			System.out.println(ee);
		}
		}
	
		
	public void testFindByValoracionMin() throws DataException {
		logger.info("Testing testFindByValoracionMin...");
		EventoCriteria c = new EventoCriteria();
		c.setValoracionMin(4);
		List<Evento> results = eventoService.findByCriteria(c, "ESP");	
		for (Evento e: results) {
			System.out.println(e);
		}
		logger.info("testFindByValoracionMin done!");
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EventoServiceTest test = new EventoServiceTest();
		//	test.testFindAll();
	//		test.testFindById();
	//		test.testFindByTipo();
			test.testFindByLocalidad();
	//		test.testFindByValoracionMin();
	//		 test.testFindByNombre();
	//		test.testFindByFechaDesde(); 
	//		test.testFindByTipo();
		} catch (DataException de) {
			de.printStackTrace();
		}

	}

}

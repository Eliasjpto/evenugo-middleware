package com.evenugo.service.test;
import java.util.List;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.service.EventoService;
import com.evenugo.dao.service.impl.EventoServiceImpl;
import com.evenugo.model.Evento;
import com.evenugo.model.criteria.EventoCriteria;

import java.util.Calendar;
import java.util.Date;
public class EventoServiceTest {
	
	private EventoService eventoService = null;
	
	public EventoServiceTest() {
		eventoService = new EventoServiceImpl();
	}
	
	public void testFindById() throws DataException {		
		Evento e = eventoService.findById((long) 2, "ESP");
		System.out.println(e);
		
	}
	public void testFindByNombre1() throws DataException {		
		Evento e = eventoService.findByNombre("r", "ESP");
		System.out.println(e);
		
	}
	
	public void testFindByLocalidad() throws DataException {
		EventoCriteria c = new EventoCriteria();
		c.setIdLocalidad((long) 4);
		List<Evento> results = eventoService.findByCriteria(c, "ESP");	
		for (Evento e: results) {
			System.out.println(e);
		}
		
	}
	
	public void testFindByNombre() throws DataException {
		EventoCriteria c = new EventoCriteria();
		c.setNombre("Ros");
		List<Evento>results = eventoService.findByCriteria(c, "ESP");	
		for (Evento e: results) {
			System.out.println(e);
		}
}
	public void testFindByTipo() throws DataException {
		EventoCriteria c = new EventoCriteria();
		c.setIdTipoEvento((long) 3);
		List<Evento>results = eventoService.findByCriteria(c, "ESP");	
		for (Evento e: results) {
			System.out.println(e);
		}
	}

	public void testFindByFechaDesde() throws DataException {
		EventoCriteria c = new EventoCriteria();

//		Calendar desde = Calendar.getInstance();
	//	desde.set(calendar.YEAR, 2019);
		
		
		Date fechaDesde = new Date (2019,6,1);
		c.setFechaDesde(fechaDesde);
		
	
		 	
		
		List<Evento>results = eventoService.findByCriteria(c, "ESP");	
		for (Evento ee: results) {
			System.out.println(ee);
		}
	}
	public void testFindByFechaHasta() throws DataException {
		EventoCriteria c = new EventoCriteria();
		
		Date u = new java.util.Date();
		c.setFechaHasta(u);
		List<Evento>results = eventoService.findByCriteria(c, "ESP");	
		for (Evento ee: results) {
			System.out.println(ee);
		}
		}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		EventoServiceTest test = new EventoServiceTest();
	// test.testFind();
//		test.testFindByLocalidad();
 // test.testFindByNombre();
		test.testFindByFechaDesde();  
	//	test.testFindByTipo();
	} catch (DataException de) {
			de.printStackTrace();
		}
		
		
	}

}

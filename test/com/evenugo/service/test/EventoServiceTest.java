package com.evenugo.service.test;
import java.util.List;
import com.evenugo.dao.exceptions.DataException;
import com.evenugo.service.EventoService;
import com.evenugo.service.impl.EventoServiceImpl;
import com.evenugo.model.Evento;
import com.evenugo.model.criteria.EventoCriteria;
import java.util.Date;
public class EventoServiceTest {
	
	private EventoService eventoService = null;
	
	public EventoServiceTest() {
		eventoService = new EventoServiceImpl();
	}
	
	public void testFindById() throws DataException {		
		Evento e = eventoService.findById((long) 8, "ENG");
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
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		EventoServiceTest test = new EventoServiceTest();
	test.testFindById();
//	test.testFindByLocalidad();
  // ntest.testFindByNombre();
	//	test.testFindByFechaHasta();  
	//	test.testFindByTipo();
	} catch (DataException de) {
			de.printStackTrace();
		}
		
		
	}

}

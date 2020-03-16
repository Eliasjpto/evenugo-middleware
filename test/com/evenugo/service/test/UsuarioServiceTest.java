package com.evenugo.service.test;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.service.EventoService;
import com.evenugo.service.PaisService;
import com.evenugo.service.UsuarioService;
import com.evenugo.service.impl.PaisServiceImpl;
import com.evenugo.service.impl.UsuarioServiceImpl;
import com.evenugo.exceptions.MailException;
import com.evenugo.model.Pais;
import com.evenugo.model.Usuario;
import com.evenugo.util.PasswordEncryptionUtil;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioServiceTest {
	private UsuarioService usuarioService = null;
	private static Logger logger = LogManager.getLogger(UsuarioServiceTest.class.getName());
//	public static void usuarioFindByID () throws DataException {
//		
//	Usuario a = s.findByID(3);
//		System.out.println(a);
//		}
//
//	public static void usuarioFindByEmail () throws DataException {
//		UsuarioService s = new UsuarioServiceImpl();
//		Usuario a = s.findByEmail("@");
//		System.out.println(a);
//		}
	public static void createUsuario () throws DataException, MailException {
//		java.util.Date e = new java.util.Date();
//		java.sql.Date i = new java.sql.Date((1999-05-12));
//		e =i ;
	
		UsuarioService s = new UsuarioServiceImpl();
		Usuario a = new Usuario();
		String plainPassword = "chahhyntadino";
		a.setNombre("elias");
		a.setApellidos("tetoros");
		a.setDireccion("lepanto");
		a.setEmail("pineiro520@gmail.com");
		a.setFechaNacimiento(new Date(1996-05-19));
		a.setLocalidad(2);
		a.setPassword(PasswordEncryptionUtil.encryptPassword(plainPassword));
		a.setTelefono("12344445");
		a.setSexo("M");
		try {

			a = s.create(a);

	//		logger. info("Created: " + ToStringUtil.toString(u));

		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
		}
		logger.info("Test created finished.\n");
	}

	public static void updateUsuario () throws DataException, MailException {
//		java.util.Date e = new java.util.Date();
//		java.sql.Date i = new java.sql.Date((1999-05-12));
//		e =i ;
	
		UsuarioService s = new UsuarioServiceImpl();
		Usuario a = new Usuario(); 
	// obtener a  a un  usuario apartir del id y luego hacer el cambio al llamar al dao
		
		
		try {

			a = s.update(a);

	//		logger. info("Created: " + ToStringUtil.toString(u));

		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
		}
		logger.info("Test created finished.\n");
	}


		public static void main(String[] args) throws MailException,DataException {
			// TODO Auto-generated method stub
			try {
				UsuarioServiceTest test = new UsuarioServiceTest();
//				test.testFindById();
		//	test.createUsuario();
           test.updateUsuario();
			} catch (DataException de) {
					de.printStackTrace();
				}
				
				
			}
		}


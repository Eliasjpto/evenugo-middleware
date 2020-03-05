package com.evenugo.service.test;

import com.evenugo.dao.exceptions.DataException;
import com.evenugo.dao.service.EventoService;
import com.evenugo.dao.service.PaisService;
import com.evenugo.dao.service.UsuarioService;
import com.evenugo.dao.service.impl.PaisServiceImpl;
import com.evenugo.dao.service.impl.UsuarioServiceImpl;
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
		String plainPassword = "chantada";
		a.setNombre("elias");
		a.setApellidos("tetoros");
		a.setDireccion("lombardo 1");
		a.setEmail("jpsmra2018@gmail.com");
		a.setFechaNacimiento(new Date(1996-05-12));
		a.setLocalidad(5);
		a.setPassword(PasswordEncryptionUtil.encryptPassword(plainPassword));
		a.setTelefono("123445555");
		a.setSexo("M");
		try {

			a = s.create(a);

	//		logger.info("Created: " + ToStringUtil.toString(u));

		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
		}
		logger.info("Test created finished.\n");
	}

//	 s.create(a);
//	 System.out.println(a.getPK()); xq no y asi y con try y catch y xq date y no como en test de evento cn 2
		


		public static void main(String[] args) throws MailException,DataException {
			// TODO Auto-generated method stub
			try {
				UsuarioServiceTest test = new UsuarioServiceTest();
//				test.testFindById();
			test.createUsuario();

			} catch (DataException de) {
					de.printStackTrace();
				}
				
				
			}
		}


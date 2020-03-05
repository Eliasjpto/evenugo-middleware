package com.evenugo.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.evenugo.dao.exceptions.DataException;

public class DBUtils {




	private static final String CONTROLADOR ="com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/evenugo";
	private static final String USER ="root";
	private static final String PASS ="root123";

	public DBUtils() {
		
	}
	public static Connection conectar() {

		Connection conexion = null;

		try{
			Class.forName(CONTROLADOR);

			conexion = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("Conexion OK!");
		} catch (ClassNotFoundException e){
			System.out.println("Error con el controlador.");
			e.printStackTrace();
		}catch (SQLException e){
			System.out.println("Error en la conexion.");
			e.printStackTrace();
		}
		System.out.println(" ");
		return conexion;

	}

	public static void closeResultSet(ResultSet resultSet)
		throws DataException {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DataException(e);
			}
		}

	}

	
	public static void closeStatement(Statement statement)
		throws DataException {

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DataException(e);
			}
		}

	}

	
	public static void closeConnection(Connection connection)
			throws DataException {
		
		if (connection != null) {
			try {
				// Previene un mal uso 
				if (!connection.getAutoCommit()) {
					throw new DataException("Autocommit disabled. Commit or Rollback should be done explicitly.");
				}			
				
				connection.close();
			} catch (SQLException e) {
				throw new DataException(e);
			}
		}
	}
	
	
	public static void closeConnection(Connection connection, boolean commitOrRollback)
		throws DataException {
        try {
            if (connection != null) {
                if (commitOrRollback) {
                	connection.commit();
                } else {
                	connection.rollback();                        
                }
                connection.close();
            }
        } catch (SQLException e) {
            throw new DataException(e);
        }
	}

}






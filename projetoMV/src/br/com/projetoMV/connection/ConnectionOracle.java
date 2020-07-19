/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoMV.connection;

// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 
// conexão SQL para Java 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// driver de conexão SQL para Java 
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;
// classe para tratamento de exceções 

/**
 *
 * @author sergi
 */
public class ConnectionOracle {
    
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "system";
	private static final String PASS = "2048";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro na conexão: ", ex);
		} 

	}
	
	private static void closedConnection(Connection con) {
		
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				Logger.getLogger(ConnectionOracle.class.getName()).log(Level.SEVERE, null, ex);
			}

	}
	
	private static void closedConnection(Connection con, PreparedStatement stmt) {
		
		closedConnection(con);
		
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionOracle.class.getName()).log(Level.SEVERE, null, ex);
		}

   }
	
	private static void closedConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closedConnection(con, stmt);
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionOracle.class.getName()).log(Level.SEVERE, null, ex);
		}

}
    
}

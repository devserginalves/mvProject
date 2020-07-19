/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoMV.connection;

import java.sql.Connection; 
import java.sql.SQLException; 

/**
 *
 * @author sergi
 */
public class testeConnection {
    public static void main(String[] args) throws SQLException {
         Connection connection = new ConnectionOracle().getConnection();
         System.out.println("Conexão aberta!");
         connection.close();
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoMV.modeldao;

import br.com.projetoMV.connection.ConnectionOracle;
import br.com.projetoMV.model.Pessoa;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class PessoaDAO {
    
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;
    public PessoaDAO(){ 
        this.connection = new ConnectionOracle().getConnection();
    } 
    public void adiciona(Pessoa pessoa){ 
        String sql = "INSERT INTO pessoa(id,nome,telefone,email,sexo) VALUES(pessoa_seq.nextval,?,?,?,?)";
        //String sql2 = "select pessoa_seq.nextval from dual";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            //PreparedStatement stmt2 = connection.prepareStatement(sql2);
            //ResultSet res = stmt2.executeQuery();
            
            /*while (res.next()) {
				pessoa.setId(Integer.parseInt(res.getString(1)));
	    }*/
            //stmt.setInt(1, pessoa.getId());
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getTelefone());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getSexo());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
    
    	public List<Pessoa> read() {

        Connection con = ConnectionOracle.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionOracle.closeConnection(con, stmt, rs);
        }

        return pessoas;

    }
        
    public List<Pessoa> readForDesc(String name) {

        Connection con = ConnectionOracle.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE nome LIKE = ?");
            stmt.setString(1, "%"+name+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setEmail(rs.getString("email"));
                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionOracle.closeConnection(con, stmt, rs);
        }

        return pessoas;

    }
    
    public void delete(Pessoa p) {

        Connection con = ConnectionOracle.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
     public void update(Pessoa p) {

        Connection con = ConnectionOracle.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE pessoa SET nome = ? ,telefone = ?,email = ?, sexo = ? WHERE id = ?");
            
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getSexo());
            stmt.setInt(5, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beatrizoliveira.data;

import br.beatrizoliveira.model.Turma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author Beatriz Oliveira
 */
public class TurmaData extends Conexao {
    public TurmaData()throws Exception{}
    public ArrayList<Turma> listar() throws Exception {
        ArrayList<Turma> listarturmas = new ArrayList<>();
        String sql = "select * from turma";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
         while (rs.next()){
             Turma obj = new Turma(rs.getString("id"), rs.getString("dia"), rs.getString("horario"), 
                     rs.getString("modalidade"));
             
        listarturmas.add(obj);
         }
         return listarturmas;
}
    
    public boolean cadastrar(Turma turma) throws Exception {
        
        //ArrayList<Turma> listarturmass = new ArrayList<>(Al);
        String sqlT = "insert into turma values(?,?,?,?)";
        PreparedStatement psT = getConexao().prepareStatement(sqlT);
        psT.setString(1, turma.getId());
        psT.setString(2, turma.getDia());
        psT.setString(3, turma.getHorario());
        psT.setString(4, turma.getId_modalidade());
        
        
        
         return psT.executeUpdate()>0;
    }
    
    public boolean excluir(String id) throws Exception{
         String deleteTurma = "Delete from turma where id=?";
         PreparedStatement psTurma = getConexao().prepareStatement(deleteTurma);
         
         psTurma.setString(1, id);
         
         return psTurma.executeUpdate()>0;
     }
    
    
    public boolean alterar(Turma turma) throws Exception{
        String sqlT = "Update turma set dia=?, horario=?, id_modalidade=? where id=?";
        PreparedStatement psT = getConexao().prepareStatement(sqlT);
        psT.setString(1, turma.getDia());
        psT.setString(2, turma.getHorario());
        psT.setString(3, turma.getId_modalidade());
       
        
        return psT.executeUpdate()>0;
    }
    
    public ArrayList<Turma> listarTurmas() throws Exception {
        ArrayList<Turma> listarturmas = new ArrayList<>();
        
        String sql = "select id from turma";
        
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
         while (rs.next()){
             Turma obj = new Turma(rs.getString("id"));
             
        listarturmas.add(obj);
         }
         return listarturmas;
}
      public boolean matricular(String cpf, String id) throws Exception {
        
        //ArrayList<Turma> listarturmass = new ArrayList<>(Al);
        String sqlT = "insert into aluno_turma values(?,?)";
        PreparedStatement psT = getConexao().prepareStatement(sqlT);
        psT.setString(1, cpf);
        psT.setString(2, id);
        
        return psT.executeUpdate()>0;
    }
}

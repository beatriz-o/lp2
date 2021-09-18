/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beatrizoliveira.data;

import br.beatrizoliveira.model.Aluno;
import br.beatrizoliveira.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;

/**
 *
 * @author Beatriz Oliveira
 */
public class AlunoData extends Conexao{
    public AlunoData()throws Exception{}
    public ArrayList<Aluno> listar(String pesquisa) throws Exception {
        ArrayList<Aluno> listaralunos = new ArrayList<>();
        
        String sql = "select * from aluno a inner join endereco e on a.cpf = e.cpf_aluno";
        
        if (!pesquisa.equalsIgnoreCase("")){
        sql = "select * from aluno a inner join endereco e on a.cpf = e.cpf_aluno where nome like'"+pesquisa+"%'";
        }
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
         while (rs.next()){
             Aluno obj = new Aluno(rs.getString("cpf"), rs.getString("nome"), rs.getDate("dataNasc"), 
                     rs.getDouble("peso"), rs.getDouble("altura"), 
                     rs.getString("sexo"), rs.getString("telefone"), rs.getString("email"), 
                     rs.getString("profissao"),new  Endereco(rs.getString("rua"),rs.getString("numero"),
                     rs.getString("bairro"),rs.getString("cidade"),rs.getString("estado"),rs.getString("cep")));
             
        listaralunos.add(obj);
         }
         return listaralunos;
    }
    
    public boolean cadastrar(Aluno aluno) throws Exception {
        
        
        String sqlA = "insert into aluno values(?,?,?,?,?,?,?,?,?)";
        String sqlE = "insert into endereco values(?,?,?,?,?,?,?)";
        PreparedStatement psA = getConexao().prepareStatement(sqlA);
        PreparedStatement psE = getConexao().prepareStatement(sqlE);
        java.sql.Date dataNasc = new java.sql.Date(aluno.getDataNasc().getTime());
        psA.setString(1, aluno.getCpf());
        psA.setString(2, aluno.getNome());
        psA.setDate(3,dataNasc);
        psA.setString(4, aluno.getSexo());
        psA.setString(5, aluno.getTelefone());
        psA.setString(6, aluno.getEmail());
        psA.setDouble(7, aluno.getPeso());
        psA.setDouble(8, aluno.getAltura());
        psA.setString(9, aluno.getProfissao());
        
        psE.setString(1, aluno.getCpf());
        psE.setString(2, aluno.getEndereco().getRua());
        psE.setString(3, aluno.getEndereco().getNumero());
        psE.setString(4, aluno.getEndereco().getBairro());
        psE.setString(5, aluno.getEndereco().getCidade());
        psE.setString(6, aluno.getEndereco().getEstado());
        psE.setString(7, aluno.getEndereco().getCep());
        
         return psA.executeUpdate()>0&&psE.executeUpdate()>0;
    }
    
    public boolean excluir(String cpf) throws Exception{
         String deleteEndereco = "Delete from endereco where cpf_aluno=?";
         String deleteAluno = "Delete from aluno where cpf=?";
         PreparedStatement psEndereco = getConexao().prepareStatement(deleteEndereco);
         PreparedStatement psAluno = getConexao().prepareStatement(deleteAluno);
         
         psEndereco.setString(1, cpf);
         psAluno.setString(1, cpf);
         
         return psEndereco.executeUpdate()>0 && psAluno.executeUpdate()>0;
     }
    
    
    public boolean alterar(Aluno aluno) throws Exception{
        
        String sqlA = "Update aluno set datanasc=?, sexo=?, telefone=?, email=?, peso=?, altura=?, profissao=? where cpf=?";
        String sqlE = "Update endereco set rua=?, numero=?, bairro=?, cidade=?, estado=?, cep=? where cpf_aluno=?";
        PreparedStatement psA = getConexao().prepareStatement(sqlA);
        PreparedStatement psE = getConexao().prepareStatement(sqlE);
        java.sql.Date data = new java.sql.Date(aluno.getDataNasc().getTime());
        psA.setDate(1, data);
        psA.setString(2, aluno.getSexo());
        psA.setString(3, aluno.getTelefone());
        psA.setString(4, aluno.getEmail());
        psA.setDouble(5, aluno.getPeso());
        psA.setDouble(6, aluno.getAltura());
        psA.setString(7, aluno.getProfissao());
        psA.setString(8, aluno.getCpf());
        
        psE.setString(1, aluno.getEndereco().getRua());
        psE.setString(2, aluno.getEndereco().getNumero());
        psE.setString(3, aluno.getEndereco().getBairro());
        psE.setString(4, aluno.getEndereco().getCidade());
        psE.setString(5, aluno.getEndereco().getEstado());
        psE.setString(6, aluno.getEndereco().getCep());
        psE.setString(7, aluno.getCpf());
        
        
        
        
        return psA.executeUpdate()>0&&psE.executeUpdate()>0;
    }
     
}

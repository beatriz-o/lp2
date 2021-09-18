/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beatrizoliveira.data;

import java.sql.PreparedStatement;

/**
 *
 * @author Beatriz Oliveira
 */
public class TesteConexao {
    public static void main(String[] args) {
        try {
            Conexao c = new Conexao();
            System.out.println("Conexão ok.");
            String sql="insert into aluno values (\n" +
"	'98765432100',\n" +
"	'Wellinson Gabriel',\n" +
"	'07/04/1995',\n" +
"	85,\n" +
"	1.82,\n" +
"	'masculino',\n" +
"	'17997097580',\n" +
"	'wellinsongabriel@gmail.com',\n" +
"	'estudante',\n" +
"	'Rua São Paulo n 2555 Votuporanga'\n" +
")";
PreparedStatement ps = c.getConexao().prepareStatement(sql);
if(ps.executeUpdate()>0)
System.out.println("Registro salvo com sucesso!");
else
System.out.println("Erro ao salvar.");
        } catch (Exception ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    }
}

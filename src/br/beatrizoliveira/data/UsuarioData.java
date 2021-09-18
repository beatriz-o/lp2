/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beatrizoliveira.data;

import br.beatrizoliveira.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Beatriz Oliveira
 */
public class UsuarioData extends Conexao {
    public UsuarioData()throws Exception{}
    public Usuario autenticar(String usuario, String senha) throws Exception {
        Usuario dadosUsuario = null;
        String sql = "select * from usuario where usuario=? and senha=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, senha);        
        ResultSet rs = ps.executeQuery();
         if (rs.next()){
             dadosUsuario = new Usuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"), 
                     rs.getString("nome_usuario"), rs.getString("tipousuario"));
         }
         return dadosUsuario;
    }
}

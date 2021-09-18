/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beatrizoliveira.model;

/**
 *
 * @author Beatriz Oliveira
 */
public class Usuario {

    public Usuario(int id, String usuario, String senha, String nome, String tipo) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
    }
    public Usuario() {
        id = 0;
        usuario = new String();
        senha = new String();
        nome = new String();
        tipo = new String();
    }
    
    private int id;
    private String usuario;
    private String senha;
    private String nome;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

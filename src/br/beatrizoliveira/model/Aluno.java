/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beatrizoliveira.model;

import java.util.Date;

/**
 *
 * @author Beatriz Oliveira
 */
public class Aluno {
    private String cpf;
    private String nome;
    private Date dataNasc;
    private double peso;
    private double altura;
    private String sexo;
    private String telefone;
    private String email;
    private String profissao;
    private Endereco endereco;

    public Aluno(String cpf, String nome, Date dataNasc, double peso, double altura, String sexo, String telefone, String email, String profissao, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.profissao = profissao;
        this.endereco = endereco;
    }
    
    public Aluno(String cpf, String nome, Date dataNasc,  String sexo,
        String telefone, String email, double peso, double altura, String profissao, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.profissao = profissao;
        this.endereco = endereco;
    }

    public Aluno() {
        cpf = new String();
        nome = new String();
        dataNasc = new Date();
        peso = 0;
        altura = 0;
        sexo = new String();
        telefone = new String();
        email = new String();
        profissao = new String();
        endereco = new Endereco();
    }

    
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataNasc
     */
    public Date getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}

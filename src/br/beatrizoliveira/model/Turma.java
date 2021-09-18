/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beatrizoliveira.model;

import java.sql.Time;



/**
 *
 * @author Beatriz Oliveira
 */
public class Turma {
    private String id;
    private String dia;
    private String horario;
    private String id_modalidade;

    public Turma(String id, String dia, String horario, String id_modalidade) {
        this.id = id;
        this.dia = dia;
        this.horario = horario;
        this.id_modalidade = id_modalidade;
    }
    
    public Turma(String id) {
        this.id = id;
    }
    
    public Turma() {
        id = new String();
        dia = new String();
        horario = new String();
        id_modalidade  = new String();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(String id_modalidade) {
        this.id_modalidade = id_modalidade;
    }
    
}

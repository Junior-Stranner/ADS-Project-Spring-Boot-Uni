package com.br.projetoescola.Model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Avaliacao{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data;
    private String materia;
    private String assunto;

    //Envia os Dados muitos para um para o estudante,
    @ManyToOne(cascade = CascadeType.ALL)
    private Estudante estudante;

    public Avaliacao(){

    }

    public Avaliacao(int id, Date data, String materia, String assunto, Estudante estudante) {
        this.id = id;
        this.data = data;
        this.materia = materia;
        this.assunto = assunto;
        this.estudante = estudante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
    
}
package com.br.projetoescola.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Aula {
    @Id
    // Autoincrement ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String titulo;

    // -------------------------------------------------------------------------//

    /*  mappedBy é usado quando temos um relacionamento bidirecional mapeado
     entre duas classes*/

    /*  FetchType
     Traz todas as entidades que estão relacionadas, ou seja, se a Entidade A
     possui um relacionamento com a Entidade B, então quando consultar a Entidade
     A, também será consultado suas referencias na Entidade B.*/

    @ManyToMany(mappedBy = "aulas", fetch = FetchType.LAZY)
    List<Estudante> estudantes;

    public Aula(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Aula() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

}

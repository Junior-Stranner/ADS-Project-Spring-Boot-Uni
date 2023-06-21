package com.br.projetoescola.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Professor {

    @Id
    // Autoincrement ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nome;

    // -------------------------------------------------------------------------//

    // mappedBy é utilizado quando temos um relacionamento bidirecional mapeado
    // entre duas classes

    // FetchType

    // Traz todas as entidades que estão relacionadas, ou seja, se a Entidade A
    // possui um relacionamento com a Entidade B, então quando consultar a Entidade
    // A, também será consultado suas referencias na Entidade B.

    @ManyToMany(mappedBy = "professores", fetch = FetchType.LAZY)
    List<Estudante> estudantes;

    public int getId() {
        return id;

    }

    public Professor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Professor() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

}

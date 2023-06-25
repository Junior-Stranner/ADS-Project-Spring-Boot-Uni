package com.br.projetoescola.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Estudante {
    @Id
    // Autoincrement ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int cpf;
    private String sobrenome;

    // ManyToMany Este relacionamento informa que muitos registros de uma entidade
    // estão relacionados com muitos registros de outra entidade
    // @JoinTable = Criação de tabela associativa

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "estudante_aula", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "aula_id"))
    List<Aula> aulas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "estudante_professor", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    List<Professor> professores;

    //Envia os dados um Para muitos do Estudante para a Avaliacao
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "estudante")
    List<Avaliacao> avaliacoes;

    public int getId() {
        return id;
    }

    public Estudante() {

    }

    public Estudante(int id, String nome, int cpf, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;

    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    
}
package com.br.projetoescola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projetoescola.Model.Professor;

//Classe ProfessorRepository herda de JpaRepository. Quem instanciar acessa metodos de JpaReps..
//Integer --> Tipo do ID
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Professor findByNome(String professorString);

}

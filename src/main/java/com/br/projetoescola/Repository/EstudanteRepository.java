package com.br.projetoescola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projetoescola.Model.Estudante;

//Classe EstudanteRepository herda de JpaRepository. Quem instanciar acessa metodos de JpaReps..
//Integer --> Tipo do ID
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}

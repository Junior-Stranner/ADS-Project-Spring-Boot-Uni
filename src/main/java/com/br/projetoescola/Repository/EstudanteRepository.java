package com.br.projetoescola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoescola.Model.Estudante;

//Classe EstudanteRepository herda de JpaRepository. Quem instanciar acessa metodos de JpaReps..
//Integer --> Tipo do ID
@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}

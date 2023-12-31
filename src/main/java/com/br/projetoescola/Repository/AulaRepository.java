package com.br.projetoescola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projetoescola.Model.Aula;

//Classe AulaRepository herda de JpaRepository. Quem instanciar acessa metodos de JpaReps..
//Integer --> Tipo do ID
public interface AulaRepository extends JpaRepository<Aula, Integer> {

    Aula findByTitulo(String aulaString);

}

package com.br.projetoescola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoescola.Model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao , Integer>{
    
}

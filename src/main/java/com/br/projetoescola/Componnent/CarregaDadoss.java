package com.br.projetoescola.Componnent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.br.projetoescola.Model.Aula;
import com.br.projetoescola.Repository.AulaRepository;

@Component
public class CarregaDadoss implements CommandLineRunner{

    @Autowired
    AulaRepository aRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
       String[] aulas = {"Desenvolvimento Web","Desenvolvimento Mobile","Redes"};

       for (String aulaString : aulas) {
        Aula aula = aRepository.findByTitulo(aulaString);
      if(aula == null){
        aula = new Aula(0, aulaString);
        aRepository.save(aula);
      }
       }
    }

    
}

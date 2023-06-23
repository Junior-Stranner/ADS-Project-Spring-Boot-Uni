package com.br.projetoescola.Componnent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.br.projetoescola.Model.Professor;
import com.br.projetoescola.Repository.ProfessorRepository;

@Component
public class CarregaDados implements CommandLineRunner{
    
    @Autowired
    ProfessorRepository pRepository;

    @Override
    public void run(String... args) throws Exception {
       String[] professores = {"Jayme","Stélio","Vanessa","Fábio"};

       for (String professorString : professores) {
           Professor professor = pRepository.findByNome(professorString);
           if(professor == null){
            professor = new Professor(0, professorString);
            pRepository.save(professor);
           }
       }
    }

   
}

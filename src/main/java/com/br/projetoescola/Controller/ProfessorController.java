package com.br.projetoescola.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoescola.Model.Estudante;
import com.br.projetoescola.Model.Professor;
import com.br.projetoescola.Repository.EstudanteRepository;
import com.br.projetoescola.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository pRepository;

      @Autowired
    EstudanteRepository eRepository;

    @GetMapping("/homeProfessor")
    public ModelAndView homeProfessor(){
        ModelAndView mv = new ModelAndView("homeProfessor");
        ArrayList<Estudante>estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) eRepository.findAll();
        mv.addObject("estudantes", estudantes);
        return mv;

    }
    
    @PostMapping("/homeProfessor")
    public String salvar(Professor professor){
        pRepository.save(professor);
        return "redirect:/listProfessor";

    }

    
    // Exibir Cadastro
    @GetMapping("/listProfessor")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listProf");
        ArrayList<Professor> professores = new ArrayList<>();
        professores = (ArrayList<Professor>) pRepository.findAll();
        mv.addObject("professores", professores);
        return mv;
    }

     @GetMapping("/editarPsrofessor/{id}")
      public ModelAndView editar(@PathVariable("id") int id) {
      ModelAndView mv = new ModelAndView("homeProfessor");
      Professor professores = new Professor();
      professores = pRepository.findById(id).get();
      mv.addObject("professores", professores);
      
      return mv;
      
      }
    
      @GetMapping("/excluirProfessor/{id}")
      public String excluir(@PathVariable("id") int id) {
      eRepository.deleteById(id);
      return "redirect:/listProfessor";
      
      }
      
}


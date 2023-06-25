package com.br.projetoescola.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoescola.Model.Avaliacao;
import com.br.projetoescola.Model.Estudante;
import com.br.projetoescola.Repository.AvaliacaoRepository;
import com.br.projetoescola.Repository.EstudanteRepository;

@Controller
public class AvaliacaoController {
    
    @Autowired
    AvaliacaoRepository avaRepository;

    @Autowired
    EstudanteRepository eRepository;

    @GetMapping("/homeAvaliacao")
    public ModelAndView homeAvaliacao(){
        ModelAndView mv = new ModelAndView("homeAvaliacao");
         ArrayList<Estudante> estudantes = new ArrayList<>();
         estudantes = (ArrayList<Estudante>) eRepository.findAll();
         mv.addObject("estudantes", estudantes);
        return mv;

    }

    @PostMapping("/homeAvaliacao")
    public String salvar(Avaliacao avaliacao){
        avaRepository.save(avaliacao);
        return "redirect:/listAvaliacao";

    }
    @GetMapping("/listAValiacao")
    public ModelAndView lista(){
    ModelAndView mv = new ModelAndView("listAValiacao")
    ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
    mv.addObject("avaliacoes", avaliacoes);
        return mv;

    }
}

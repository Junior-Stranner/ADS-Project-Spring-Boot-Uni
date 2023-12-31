package com.br.projetoescola.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoescola.Model.Aula;
import com.br.projetoescola.Model.Estudante;
import com.br.projetoescola.Repository.AulaRepository;
import com.br.projetoescola.Repository.EstudanteRepository;

@Controller
public class AulaController {

    // @Autowired é usada para injetar dependências automaticamente em um objeto.
    // Por exemplo, se um objeto precisa de uma instância de um serviço, a anotação
    // @Autowired pode ser usada para injetar essa instância no objeto.

    @Autowired
    AulaRepository aRepository;

    @Autowired
    EstudanteRepository eRepository;

    // Cadastrar
    // @GetMapping: Determina que o método aceitará requisições HTTP do tipo GET.
    @GetMapping("/homeAula")
    public ModelAndView homeAula() {
        ModelAndView mv = new ModelAndView("homeAula");
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) eRepository.findAll();
        mv.addObject("estudantes", estudantes);
        return mv;
    }

    // Cadastrar
    // @PostMapping: Envia os dados do HTML para o Back-0end
    @PostMapping("/homeAula")
    public String salvar(Aula aula) {
        aRepository.save(aula);
        return "redirect:/listAula";
    }

    // Exibir Cadastro
    @GetMapping("/listAula")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listAula");
        ArrayList<Aula> aulas = new ArrayList<>();
        aulas = (ArrayList<Aula>) aRepository.findAll();
        mv.addObject("aulas", aulas);
        return mv;
    }

}

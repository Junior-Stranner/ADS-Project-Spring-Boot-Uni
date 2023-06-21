package com.br.projetoescola.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoescola.Model.Estudante;
import com.br.projetoescola.Model.Professor;
import com.br.projetoescola.Repository.EstudanteRepository;
import com.br.projetoescola.Repository.ProfessorRepository;

public class ProfessorController {

    // @Autowired é usada para injetar dependências automaticamente em um objeto.
    // Por exemplo, se um objeto precisa de uma instância de um serviço, a anotação
    // @Autowired pode ser usada para injetar essa instância no objeto.

    @Autowired
    ProfessorRepository pRepository;

    @Autowired
    EstudanteRepository eRepository;

    // Cadastrar
    @GetMapping("/homeProfessor")
    public ModelAndView homeProfessoer() {
        ModelAndView mv = new ModelAndView("homeProfessor");
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) eRepository.findAll();
        mv.addObject("estudantes", estudantes);

        return mv;
    }

    // Cadastrar
    //  @PostMapping: Envia os dados do HTML para o Back-0end 
    @PostMapping("/homeProfessor")
    public String salvar(Professor professor) {
        pRepository.save(professor);
        return "redirect:/listaEscola";
    }

    // Exibir Cadastro
    // @GetMapping: Determina que o método aceitará requisições HTTP do tipo GET.

    @GetMapping("/listProfessor")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listProfessor");
        ArrayList<Professor> professores = new ArrayList<>();
        professores = (ArrayList<Professor>) pRepository.findAll();
        mv.addObject("professores", professores);
        return mv;
    }
    /*
     * @GetMapping("/excluirProf/{id}")
     * public String excluir(@PathVariable("id") int id) {
     * profRepository.deleteById(id);
     * return "redirect:/listProf";
     * 
     * }
     * 
     * @GetMapping("/editarProf/{id}")
     * public ModelAndView editar(@PathVariable("id") int id) {
     * ModelAndView mv = new ModelAndView("homeProf");
     * Professor professor = new Professor();
     * professor = profRepository.findById(id).get();
     * mv.addObject("professor", professor);
     * 
     * return mv;
     * }
     */
}

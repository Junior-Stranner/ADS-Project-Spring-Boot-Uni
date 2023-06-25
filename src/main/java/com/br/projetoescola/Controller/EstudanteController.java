package com.br.projetoescola.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoescola.Model.Aula;
import com.br.projetoescola.Model.Avaliacao;
import com.br.projetoescola.Model.Estudante;
import com.br.projetoescola.Model.Professor;
import com.br.projetoescola.Repository.AulaRepository;
import com.br.projetoescola.Repository.AvaliacaoRepository;
import com.br.projetoescola.Repository.EstudanteRepository;
import com.br.projetoescola.Repository.ProfessorRepository;

@Controller
public class EstudanteController {

    // @Autowired é usada para injetar dependências automaticamente em um objeto.
    // Por exemplo, se um objeto precisa de uma instância de um serviço, a anotação
    // @Autowired pode ser usada para injetar essa instância no objeto.

    @Autowired
    EstudanteRepository eRepository;

    @Autowired
    AulaRepository aRepository;

    @Autowired
    ProfessorRepository pRepository;

    @Autowired
    AvaliacaoRepository avaRepository;

    // Cadastrar
    // @GetMapping: Determina que o método aceitará requisições HTTP do tipo GET.

    @GetMapping("/homeEstudante")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("homeEstudante");

        ArrayList<Aula> aulas = new ArrayList<>();
        aulas = (ArrayList<Aula>) aRepository.findAll();
        mv.addObject("aulas", aulas);

        ArrayList<Professor> professores = new ArrayList<>();
        professores = (ArrayList<Professor>) pRepository.findAll();
        mv.addObject("professores", professores);

        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        avaliacoes = (ArrayList<Avaliacao>) avaRepository.findAll();
        mv.addObject("avaliacoes", avaliacoes);
        
        return mv;
    }

    // Cadastrar
    // @PostMapping: Determina que o método aceitará requisições HTTP do tipo POST.

  
    @PostMapping("/homeEstudante")
    public String salvar(Estudante estudante ,@RequestParam("aas") List<Integer> aulaId , @RequestParam("pps")  List<Integer> professorId,
     @RequestParam("avas") List<Avaliacao> avaliacaoId) {
        ArrayList<Aula> aulas = new ArrayList<>();
         ArrayList<Professor> professores = new ArrayList<>();
          ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
          // Salva as Aulas e envia Para Estudantes
        for (Integer id : aulaId) {
            aulas.add(aRepository.findById(id).get());
        }
        estudante.setAulas(aulas);
        eRepository.save(estudante);

        //Salva os Professores e envia para Estudantes
        for (Integer id : professorId) {
            professores.add(pRepository.findById(id).get());
        }
        estudante.setProfessores(professores);
        eRepository.save(estudante);

        //Salva as Avaliacoes e envia Para Estudantes
        for (Integer id : avaliacaoId) {
            avaliacoes.add(avaRepository.findById(id).get());
        }
        estudante.setAvaliacoes(avaliacoes);
        eRepository.save(estudante);
        
        return "redirect:/listEstudante";
    }

    // Exibir Cadastro
    @GetMapping("/listEstudante")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listEstudante");
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) eRepository.findAll();
        mv.addObject("estudantes", estudantes);
        return mv;
    }

     @GetMapping("/editarEstudante/{id}")
      public ModelAndView editar(@PathVariable("id") int id) {
      ModelAndView mv = new ModelAndView("homeEstudante");
      Estudante estudante = new Estudante();
      estudante = eRepository.findById(id).get();
      mv.addObject("estudante", estudante);
      
      return mv;
      
      }
    
      @GetMapping("/excluirEstudante/{id}")
      public String excluir(@PathVariable("id") int id) {
      eRepository.deleteById(id);
      return "redirect:/listEstudante";
      
      }
      
     

}

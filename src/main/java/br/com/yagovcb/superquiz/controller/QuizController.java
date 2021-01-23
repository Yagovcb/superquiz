package br.com.yagovcb.superquiz.controller;

import br.com.yagovcb.superquiz.model.Quiz;
import br.com.yagovcb.superquiz.model.Respostas;
import br.com.yagovcb.superquiz.model.dto.QuizDTO;
import br.com.yagovcb.superquiz.service.QuizService;
import br.com.yagovcb.superquiz.service.RespostaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private QuizService servico;

    @GetMapping()
    public ModelAndView getQuiz(){
        ModelAndView mv = new ModelAndView("quiz");
        List<Quiz> quizzes = servico.findAll();
        mv.addObject("quiz", quizzes);
        return mv;
    }

    @GetMapping("/novoQuiz")
    public ModelAndView getQuizForm(){
        ModelAndView mv = new ModelAndView("novoQuiz");
        List<Respostas> listRespostas = montaListaMaximaRespostas();
        Quiz quiz = new Quiz();
        quiz.setRespostas(listRespostas);
        mv.addObject("quiz", quiz);
        mv.addObject("respostas", listRespostas);
        return mv;
    }


    @Valid
    @PostMapping("/novoQuiz")
    public String saveQuiz(@RequestBody Quiz quiz, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/novoPost";
        }
        servico.save(quiz);
        return "redirect:/quiz";
    }

    @GetMapping("/{id}")
    public ModelAndView getDetalhamentoQuiz (@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("detalhamentoQuiz");
        Quiz quiz = servico.findById(id);
        mv.addObject("quiz", quiz);
        return mv;
    }

    private List<Respostas> montaListaMaximaRespostas() {
        List<Respostas> listRespostas = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            listRespostas.add(new Respostas());
        }

        return listRespostas;
    }
}

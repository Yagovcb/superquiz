package br.com.yagovcb.superquiz.model.dto;

import br.com.yagovcb.superquiz.model.Quiz;
import br.com.yagovcb.superquiz.model.Respostas;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class QuizDTO {

    private String enunciado;
    private List<Respostas> respostas;
    private String autor;
    private Boolean isConcluido;

    public Quiz toQuiz(){
        Quiz q = new Quiz();
        q.setRespostas(this.respostas);
        q.setAutor(this.autor);
        q.setEnunciado(this.enunciado);
        q.setIsConcluido(this.isConcluido);
        return q;
    }
}

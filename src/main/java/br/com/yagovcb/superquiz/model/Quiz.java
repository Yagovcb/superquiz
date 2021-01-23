package br.com.yagovcb.superquiz.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Lob
    @Column(name = "enunciado")
    private String enunciado;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Respostas> respostas;

    @Column(name = "autor")
    @NotBlank
    private String autor;

    @Column(name = "is_concluido")
    private Boolean concluido;
}

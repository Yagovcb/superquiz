package br.com.yagovcb.superquiz.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Respostas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "alternativa")
    private String alternativa;

    @NonNull
    @Column(name = "is_certa")
    private Boolean isCerta;
}

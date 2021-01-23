package br.com.yagovcb.superquiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "usuario")
    private String usuario;

    @NonNull
    @Column(name = "nome")
    private String nome;

    @NonNull
    @JsonIgnore
    @Column(name = "senha")
    private String senha;

    @NonNull
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TiposUsuarios> tipo;

    @NonNull
    @Column(name = "estado")
    private String estado;

    @NonNull
    @Column(name = "cidade")
    private String cidade;

    //--------------- Costrutores especificos ----------------
    public Usuario(Usuario usuario) {

    }
}

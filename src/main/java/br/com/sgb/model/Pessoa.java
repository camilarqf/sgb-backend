package br.com.sgb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1751790146106078383L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @CPF(message = "Forneça um CPF válido")
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String telefone;
    @Email(message = "Forneça um e-mail válido")
    @Column(unique = true, nullable = false)
    private String email;
    private String endereco;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Perfis")
    private Set<Integer> perfis = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String senha;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();


}

package br.com.sgb.model;

import br.com.sgb.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1751790146106078383L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;
    @Column(nullable = false)
    protected String nome;
    @CPF(message = "Forneça um CPF válido")
    @Column(unique = true, nullable = false)
    protected String cpf;
    protected String matricula;
    @Column(nullable = false)
    protected String telefone;
    @Email(message = "Forneça um e-mail válido")
    @Column(unique = true, nullable = false)
    protected String email;
    protected String endereco;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Perfis")
    protected Set<Integer> perfis = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    protected String senha;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public Pessoa() {
        addPerfil(Perfil.USUARIO);
    }

    public Pessoa(Integer id, String nome, String cpf, String matricula, String telefone, String email, String endereco,
                  String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
        addPerfil(Perfil.USUARIO);
    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis(){
        return this.perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id) && cpf.equals(pessoa.cpf) && matricula.equals(pessoa.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, matricula);
    }
}

package br.com.sgb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Bibliotecario extends Pessoa{
    private static final long serialVersionUID = -4348948454980699407L;

    public Bibliotecario(Integer id, String nome, String cpf, String matricula, String telefone, String email,
                         String endereco, String senha) {
        super(id, nome, cpf, matricula, telefone, email, endereco, senha);
    }
}

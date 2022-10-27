package br.com.alura.comex.controller.form;

import br.com.alura.comex.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaForm {

    @NotNull @NotEmpty @Length(min = 2)
    private String nome;

    public static Categoria converter(CategoriaForm categoriaForm) {
        return new Categoria(categoriaForm.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

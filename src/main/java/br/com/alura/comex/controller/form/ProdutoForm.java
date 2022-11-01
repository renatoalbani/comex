package br.com.alura.comex.controller.form;

import br.com.alura.comex.config.validation.exception.CategoriaInvalidaException;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static br.com.alura.comex.model.Produto.builder;

public class ProdutoForm {
    @NotBlank
    @Length(min = 2)
    private String nome;
    private String descricao;
    @NotNull @Positive
    private BigDecimal precoUnitario;
    @NotNull
    private Integer quantidadeEstoque;
    @NotNull
    private Long idCategoria;

    public static Produto converter(ProdutoForm form, CategoriaRepository categoriaRepository) {
        return builder()
                .withNome(form.getNome())
                .withDescricao(form.getDescricao())
                .withPrecoUnitario(form.getPrecoUnitario())
                .withQuantidadeEstoque(form.getQuantidadeEstoque())
                .withCategoria(categoriaRepository
                                    .findById(form.getIdCategoria())
                                    .orElseThrow(CategoriaInvalidaException::new))
                .build();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}

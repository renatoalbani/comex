package br.com.alura.comex.controller.dto;

import br.com.alura.comex.model.Produto;

import java.math.BigDecimal;

public class ProdutoDto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private Integer quantidadeEstoque;
    private Long idCategoria;

    public ProdutoDto() {
    }

    public static ProdutoDto converter(Produto produto) {
        return ProdutoDto.builder().withId(produto.getId())
                .withNome(produto.getNome())
                .withDescricao(produto.getDescricao())
                .withPrecoUnitario(produto.getPrecoUnitario())
                .withQuantidadeEstoque(produto.getQuantidadeEstoque())
                .withIdCategoria(produto.getCategoria().getId()).build();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    private ProdutoDto(ProdutoDtoBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.precoUnitario = builder.precoUnitario;
        this.quantidadeEstoque = builder.quantidadeEstoque;
        this.idCategoria = builder.idCategoria;
    }

    public static ProdutoDtoBuilder builder() {
        return new ProdutoDtoBuilder();
    }

    public static final class ProdutoDtoBuilder {
        private Long id;
        private String nome;
        private String descricao;
        private BigDecimal precoUnitario;
        private Integer quantidadeEstoque;

        private Long idCategoria;

        private ProdutoDtoBuilder() {
        }

        public ProdutoDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ProdutoDtoBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public ProdutoDtoBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public ProdutoDtoBuilder withPrecoUnitario(BigDecimal precoUnitario) {
            this.precoUnitario = precoUnitario;
            return this;
        }

        public ProdutoDtoBuilder withQuantidadeEstoque(Integer quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
            return this;
        }

        public ProdutoDtoBuilder withIdCategoria(Long idCategoria) {
            this.idCategoria = idCategoria;
            return this;
        }

        public ProdutoDto build() {
            return new ProdutoDto(this);
        }
    }
}

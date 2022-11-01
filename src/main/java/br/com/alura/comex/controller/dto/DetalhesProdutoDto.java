package br.com.alura.comex.controller.dto;

import br.com.alura.comex.model.Produto;

import java.math.BigDecimal;

public class DetalhesProdutoDto {
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private Integer quantidadeEstoque;
    private DetalhesCategoriaDto categoria;

    public DetalhesProdutoDto() {
    }

    private DetalhesProdutoDto(DetalhesProdutoDtoBuilder builder) {
        this.quantidadeEstoque = builder.quantidadeEstoque;
        this.descricao = builder.descricao;
        this.nome = builder.nome;
        this.preco = builder.preco;
        this.categoria = builder.categoria;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public DetalhesCategoriaDto getCategoria() {
        return categoria;
    }

    public static DetalhesProdutoDtoBuilder builder() {
        return new DetalhesProdutoDtoBuilder();
    }

    public static DetalhesProdutoDto converter(Produto produto) {
        return DetalhesProdutoDto.builder()
                .withNome(produto.getNome())
                .withDescricao(produto.getDescricao())
                .withPreco(produto.getPrecoUnitario())
                .withQuantidadeEstoque(produto.getQuantidadeEstoque())
                .withCategoria(new DetalhesCategoriaDto(produto.getCategoria().getId(), produto.getCategoria().getNome()))
                .build();
    }

    public static final class DetalhesProdutoDtoBuilder {
        private String nome;
        private BigDecimal preco;
        private String descricao;
        private Integer quantidadeEstoque;

        private DetalhesCategoriaDto categoria;

        private DetalhesProdutoDtoBuilder() {
        }

        public DetalhesProdutoDtoBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public DetalhesProdutoDtoBuilder withPreco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public DetalhesProdutoDtoBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public DetalhesProdutoDtoBuilder withQuantidadeEstoque(Integer quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
            return this;
        }

        public DetalhesProdutoDtoBuilder withCategoria(DetalhesCategoriaDto categoria) {
            this.categoria = categoria;
            return this;
        }

        public DetalhesProdutoDto build() {
            return new DetalhesProdutoDto(this);
        }
    }
}

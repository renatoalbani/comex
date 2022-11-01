package br.com.alura.comex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
	@Column(nullable = false)
    private String nome;
 
	private String descricao;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "quantidade_estoque", nullable = false)
    private int quantidadeEstoque;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;

    public Produto(){
    }

	public Produto(ProdutoBuilder builder) {
		this.nome = builder.nome;
		this.descricao = builder.descricao;
		this.precoUnitario = builder.precoUnitario;
		this.quantidadeEstoque = builder.quantidadeEstoque;
		this.categoria = builder.categoria;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public static ProdutoBuilder builder() {
		return new ProdutoBuilder();
	}

	public static final class ProdutoBuilder {
		private String nome;
		private String descricao;
		private BigDecimal precoUnitario;
		private int quantidadeEstoque;

		private Categoria categoria;

		private ProdutoBuilder() {
		}

		public ProdutoBuilder withNome(String nome) {
			this.nome = nome;
			return this;
		}

		public ProdutoBuilder withDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public ProdutoBuilder withPrecoUnitario(BigDecimal precoUnitario) {
			this.precoUnitario = precoUnitario;
			return this;
		}

		public ProdutoBuilder withQuantidadeEstoque(int quantidadeEstoque) {
			this.quantidadeEstoque = quantidadeEstoque;
			return this;
		}

		public ProdutoBuilder withCategoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public Produto build() {
			return new Produto(this);
		}
	}
}
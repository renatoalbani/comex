package br.com.alura.comex.controller.dto;

public class DetalhesCategoriaDto {

    private Long id;
    private String nome;

    public DetalhesCategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}

package br.com.alura.comex.controller.dto;

public class PaginaDto<T> {
     private T items;
     private Long total;
     private Integer pagina;

    public PaginaDto(T items, Long total, Integer pagina) {
        this.items = items;
        this.total = total;
        this.pagina = pagina;
    }

    public T getItems() {
        return items;
    }

    public Long getTotal() {
        return total;
    }

    public Integer getPagina() {
        return pagina;
    }
}

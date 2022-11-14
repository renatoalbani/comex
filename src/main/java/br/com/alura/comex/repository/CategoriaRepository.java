package br.com.alura.comex.repository;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.CategoriaPedidosProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT c.nome, " +
            "COUNT(DISTINCT p.id) as produtos, " +
            "SUM(ip.quantidade) as quantidade  " +
            "FROM categorias c " +
            "JOIN produtos p on p.categoria_id = c.id " +
            "JOIN itens_pedido ip on ip.produto_id = p.id " +
            "GROUP BY c.id" , nativeQuery = true)
    List<CategoriaPedidosProjecao> findCategoriaPedidos();

}

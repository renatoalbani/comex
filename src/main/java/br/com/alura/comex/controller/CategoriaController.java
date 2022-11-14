package br.com.alura.comex.controller;

import br.com.alura.comex.controller.dto.CategoriaDto;
import br.com.alura.comex.controller.form.CategoriaForm;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.CategoriaPedidosProjecao;
import br.com.alura.comex.repository.CategoriaRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder){
        Categoria categoria = categoriaRepository.save(CategoriaForm.converter(categoriaForm));
        URI uri  = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @GetMapping("/pedidos")
    @Cacheable(value = "relatorioPedidos")
    public ResponseEntity<List<CategoriaPedidosProjecao>> listarCategoriaPedidos(){
        return ResponseEntity.ok(categoriaRepository.findCategoriaPedidos());
    }


}

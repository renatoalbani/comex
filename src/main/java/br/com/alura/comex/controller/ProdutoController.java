package br.com.alura.comex.controller;

import br.com.alura.comex.controller.dto.ProdutoDto;
import br.com.alura.comex.controller.form.ProdutoForm;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;

    public ProdutoController(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder){
        Produto produto = ProdutoForm.converter(form, categoriaRepository);
        Produto p = produtoRepository.save(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(ProdutoDto.converter(p));
    }
}

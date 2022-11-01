package br.com.alura.comex.controller;

import br.com.alura.comex.controller.dto.DetalhesProdutoDto;
import br.com.alura.comex.controller.dto.PaginaDto;
import br.com.alura.comex.controller.dto.ProdutoDto;
import br.com.alura.comex.controller.form.ProdutoForm;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @GetMapping
    public ResponseEntity<PaginaDto<List<DetalhesProdutoDto>>> listar(Integer page){
        PageRequest pageReq = PageRequest.of(page == null ? 0 : page, 5, Sort.by(Sort.Order.asc("nome")));
        Page<Produto> produtos = produtoRepository.findAll(pageReq);
        return ResponseEntity.ok(new PaginaDto<>(produtos.map(DetalhesProdutoDto::converter).stream().toList(), produtos.getTotalElements(), produtos.getNumber()));
    }
}

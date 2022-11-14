package br.com.alura.comex.controller.form;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheEvictController {
    @DeleteMapping("/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSB2ZW5kYXM")
    @CacheEvict(value = "relatorioPedidos")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void evictCategoriasPedidos(){
        // Only evict relatorioPedidos cache
    }
}

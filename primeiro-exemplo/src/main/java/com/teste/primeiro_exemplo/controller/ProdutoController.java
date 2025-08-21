package com.teste.primeiro_exemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoRepository produtoService;

  // @GetMapping indica que esse método será chamado quando a rota for acessada
  // via GET
  // ou seja, quando for feita uma requisição para /api/produtos
  @GetMapping
  public List<Produto> obterTodos() {
    return produtoService.obterTodos();
  }

  // @PathVariable indica que o id será passado na url
  // por exemplo: /api/produtos/1
  @GetMapping("/{id}")
  public Produto obterPorId(@PathVariable Integer id) {
    return produtoService.obterPorId(id);
  }

  // requestBody transforma o json que vem na requisição em um objeto do tipo
  // Produto
  @PostMapping
  public Produto adicionar(@RequestBody Produto produto) {
    return produtoService.adicionar(produto);
  }

  // @deleteMapping indica que esse método será chamado quando a rota for acessada
  // via DELETE
  // ou seja, quando for feita uma requisição para /api/produtos

  @DeleteMapping("/{id}")
  public String deletar(@PathVariable Integer id) {
    produtoService.deletar(id);
    // retornando uma mensagem de sucesso
          return "Produto deletado com sucesso! Id:" 
          + id;
  }
}

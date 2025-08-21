package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Produto;

@Repository
public class ProdutoRepository {

  private List<Produto> produtos = new ArrayList<>();
  private Integer ultimoId = 0;

  /**
   * metodo para retornar todos os produtos
   * 
   * @return lista de produtos
   */
  public List<Produto> obterTodos() {
    return produtos;
  }

  /**
   * metodo que retorna o produto pelo id
   * 
   * @param id do produto que será localizado
   * @return retorna o produto localizado ou null caso não exista
   */

  public Produto obterPorId(Integer id) {
    return produtos.stream()
        .filter(produto -> produto.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  /**
   * metodo que adiciona um produto
   * 
   * @param produto que será adicionado
   * @return retorna o produto adicionado com o id atualizado
   */
  public Produto adicionar(Produto produto) {
    ultimoId++;
    produto.setId(ultimoId);
    produtos.add(produto);
    return produto;
  }

  /**
   * metodo que deleta um produto pelo id
   * 
   * @param id do produto que será deletado
   */

  public void deletar(Integer id) {
    produtos.removeIf(produto -> produto.getId().equals(id));
  }

  /**
   * metodo que atualiza um produto
   * 
   * @param produto que será atualizado
   * @return retorna o produto atualizado
   */

  public Produto atualizar(Produto produto) {
    // eu tenho que remover o produto antigo e adicionar o novo

    Produto produtoExistente = obterPorId(produto.getId());


    // se o produto existir, eu removo ele da lista
 if (produtoExistente == null) {
    throw new RuntimeException("Produto não encontrado");
}

    // removo o produto antigo
    deletar(produto.getId());
    // e adiciono o novo produto atualizado na lista
    produtos.add(produto);
    return produto;
  }
}
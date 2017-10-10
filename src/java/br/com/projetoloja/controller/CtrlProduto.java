package br.com.projetoloja.controller;

import br.com.projetoloja.DAO.ProdutoDAO;
import br.com.projetoloja.model.Produto;
import java.util.List;

public class CtrlProduto {

   public void salvar(Produto produto) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        dao.create(produto);
    }
    
    public void alterar(Produto produto) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        dao.edit(produto);
    }

    public List<Produto> listarTodos(String dados) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.findProdutosAll(dados);
    }

    public List<Produto> listar(String dados) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.findProdutos(dados);
    }

    public Produto buscaID(long id) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.findProduto(id);
    }

    public void remover(long id) throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        dao.destroy(id);
    }
    
}

package br.com.projetoloja.controller;

import br.com.projetoloja.DAO.VendaDAO;
import br.com.projetoloja.model.Venda;
import java.util.List;

public class CtrlVenda {

   public void salvar(Venda venda) throws Exception {
        VendaDAO dao = new VendaDAO();
        dao.create(venda);
    }
    
    public void alterar(Venda venda) throws Exception {
        VendaDAO dao = new VendaDAO();
        dao.edit(venda);
    }

    public List<Venda> listarTodos(String dados) throws Exception {
        VendaDAO dao = new VendaDAO();
        return dao.findVendasAll(dados);
    }

    public List<Venda> listar(String dados) throws Exception {
        VendaDAO dao = new VendaDAO();
        return dao.findVendas(dados);
    }

    public Venda buscaID(long id) throws Exception {
        VendaDAO dao = new VendaDAO();
        return dao.findVenda(id);
    }

    public void remover(long id) throws Exception {
        VendaDAO dao = new VendaDAO();
        dao.destroy(id);
    }
    
}

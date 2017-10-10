package br.com.projetoloja.controller;

import br.com.projetoloja.DAO.ItemDAO;
import br.com.projetoloja.model.Item;
import java.util.List;

public class CtrlItem {

    public void salvar(Item item) throws Exception {
        ItemDAO dao = new ItemDAO();
        dao.create(item);
    }

    public void alterar(Item item) throws Exception {
        ItemDAO dao = new ItemDAO();
        dao.edit(item);
    }

    public List<Item> listar(String dados) throws Exception {
        ItemDAO dao = new ItemDAO();
        return dao.findItems(dados);
    }

    public List<Item> listarTodos() throws Exception {
        ItemDAO dao = new ItemDAO();
        return dao.listAll();
    }

    public Item buscaID(long id) throws Exception {
        ItemDAO dao = new ItemDAO();
        return dao.findItem(id);
    }

    public void remover(long id) throws Exception {
        ItemDAO dao = new ItemDAO();
        dao.destroy(id);
    }

}

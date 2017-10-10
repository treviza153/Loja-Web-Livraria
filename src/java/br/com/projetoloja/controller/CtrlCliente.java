package br.com.projetoloja.controller;

import br.com.projetoloja.DAO.ClienteDAO;
import br.com.projetoloja.model.Cliente;
import java.util.List;

public class CtrlCliente {

    public void salvar(Cliente cliente) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        dao.create(cliente);
    }
    
    public void alterar(Cliente cliente) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        dao.edit(cliente);
    }

    public List<Cliente> listar(String dados) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        return dao.findClientes(dados);
    }

    public Cliente buscaID(long id) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        return dao.findCliente(id);
    }

    public void remover(long id) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        dao.destroy(id);
    }
    
    public Cliente login(String email, String pws){
        ClienteDAO dao = new ClienteDAO();
        return dao.findCliente(email, pws);
    }
}

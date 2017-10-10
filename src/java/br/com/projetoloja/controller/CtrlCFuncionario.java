package br.com.projetoloja.controller;

import br.com.projetoloja.DAO.FuncionarioDAO;
import br.com.projetoloja.model.Funcionario;
import java.util.List;

public class CtrlCFuncionario {

    public void salvar(Funcionario funcionario) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.create(funcionario);
    }
    
    public void alterar(Funcionario funcionario) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.edit(funcionario);
    }

    public List<Funcionario> listar(String dados) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.findFuncionarios(dados);
    }

    public Funcionario buscaID(long id) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.findFuncionario(id);
    }

    public void remover(long id) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.destroy(id);
    }
    
    public Funcionario login(String email, String pws){
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.findFuncionario(email, pws);
    }
}

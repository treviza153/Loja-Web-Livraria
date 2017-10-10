package br.com.projetoloja.logica;

import br.com.projetoloja.controller.CtrlCFuncionario;
import br.com.projetoloja.model.Funcionario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FuncionarioLogica implements Logica {

    private static final long serialVersionUID = 1L;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        res.setContentType("text/html;charset=UTF-8");
        //Retorno da Pagina
        String pagina = "indexFunc.jsp";

        //Ação para login 
        //<editor-fold>
        if (req.getParameter("action").equals("log")) {
            try {
                CtrlCFuncionario ctrlCFuncionario = new CtrlCFuncionario();
                Funcionario funcionario = ctrlCFuncionario.login(req.getParameter("email"), req.getParameter("pws"));

                //  if (cliente != null) {
                //req.setAttribute("avisos", "Logado com sucesso.");
                //Chama a session
                HttpSession user = req.getSession();
                //Cria uma variavel de session
                user.setAttribute("id", funcionario.getId());
                user.setAttribute("nome", funcionario.getNome());
                // } else {
                // }
            } catch (Exception e) {
                req.setAttribute("alertas ", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("erros", "Funcionario não encontrado.");
                //Chama a session
                HttpSession user = req.getSession();
                //apaga a variavel de session
                user.removeAttribute("id");
                user.removeAttribute("nome");
                pagina = "index.jsp?p=loginFunc";
            }

        }//</editor-fold>

        //Ação para logoff
        //<editor-fold>
        if (req.getParameter("action").equals("off")) {
            try {
                //Chama a session
                HttpSession user = req.getSession();
                //apaga a variavel de session
                user.invalidate();

            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
            }

        }//</editor-fold>

        //Ação para cadastro
        //<editor-fold>
        if (req.getParameter("action").equals("cad")) {
            Funcionario funcionario = new Funcionario();
            try {
                funcionario.setNome(req.getParameter("nome").trim());
                funcionario.setEmail(req.getParameter("email").trim());
                funcionario.setPws(req.getParameter("pws1").trim());
                if (funcionario.isFuncionario(req.getParameter("pws2").trim())) {
                    CtrlCFuncionario ctrCFuncionario = new CtrlCFuncionario();
                    ctrCFuncionario.salvar(funcionario);
                    req.setAttribute("avisos", funcionario.getNome() + " cadastrado com sucesso.");
                    funcionario = null;
                }
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("cliente", funcionario);
            }
            pagina = "index.jsp?p=cadFuncionario";
        }//</editor-fold>

        //Ação para listar
        //<editor-fold>
        if (req.getParameter("action").equals("list")) {
            try {
                CtrlCFuncionario ctrCFuncionario = new CtrlCFuncionario();
                req.setAttribute("funcionarios", ctrCFuncionario.listar(req.getParameter("busca")));

            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
            }
            pagina = "index.jsp?p=relFuncionario";
        }//</editor-fold>

        /*
        //Ação para apagar
        //<editor-fold>
        if (req.getParameter("action").equals("remove")) {
            Cliente cliente = new Cliente();
            try {
                CtrlCliente ctrCliente = new CtrlCliente();
                ctrCliente.remover(Long.parseLong(req.getParameter("id")));
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("cliente", cliente);
            }
            pagina = "index.jsp?p=reportCliente";
        }//</editor-fold>

      

        //Ação para Editar
        //<editor-fold>
        if (req.getParameter("action").equals("edit")) {
            Cliente cliente = new Cliente();
            try {
                CtrlCliente ctrCliente = new CtrlCliente();
                cliente = ctrCliente.buscaID(Long.parseLong(req.getParameter("id")));
                req.setAttribute("alt", true);
            } catch (Exception e) {
                req.setAttribute("Erros: ", e.getMessage().replace(".\n", ".<br>"));

            }
            req.setAttribute("cliente", cliente);
            pagina = "index.jsp?p=formCliente";
        }//</editor-fold>
        
        
        //Ação para Alterar
        //<editor-fold>
        if (req.getParameter("action").equals("alt")) {
            Cliente cliente = new Cliente();
            try {
                cliente.setId(Long.parseLong(req.getParameter("id").trim()));
                cliente.setNome(req.getParameter("nome").trim());
                cliente.setEmail(req.getParameter("email").trim());
                cliente.setPws(req.getParameter("pws1").trim());
                if (cliente.isCliente(req.getParameter("pws2").trim())) {
                    CtrlCliente ctrCliente = new CtrlCliente();
                    ctrCliente.alterar(cliente);
                    req.setAttribute("avisos", cliente.getNome() + " atualizado com sucesso.");
                    cliente = null;
                }
            } catch (Exception e) {
                req.setAttribute("Erros: ", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("cliente", cliente);

            }
            req.setAttribute("cliente", cliente);
            pagina = "index.jsp?p=formCliente";
        }//</editor-fold>
         */
        //Retorna para a pagina
        return pagina;
    }

}

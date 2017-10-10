package br.com.projetoloja.logica;

import br.com.projetoloja.DAO.ProdutoDAO;
import br.com.projetoloja.controller.CtrlProduto;
import br.com.projetoloja.model.Produto;
import br.com.projetoloja.util.UpFiles;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoLogica implements Logica {
    
    private static final long serialVersionUID = 1L;
    
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        res.setContentType("text/html;charset=UTF-8");
        //Retorno da Pagina
        String pagina = "indexFunc.jsp";

        //Ação para cadastro
        if (req.getParameter("action").equals("cad")) {
            Produto produto = new Produto();
            try {
                produto.setDescricao(req.getParameter("descricao").trim());
                produto.setNome(req.getParameter("nome").trim());

                //Só passa o valor se o paramente do campo number for preenchido
                if (!req.getParameter("quantmin").equals("")) {
                    produto.setQuantMin(Integer.parseInt(req.getParameter("quantmin")));
                }
                if (!req.getParameter("quantmax").equals("")) {
                    produto.setQuantMax(Integer.parseInt(req.getParameter("quantmax")));
                }
                if (!req.getParameter("quantatual").equals("")) {
                    produto.setQuantAtual(Integer.parseInt(req.getParameter("quantatual")));
                }
                if (!req.getParameter("valor").equals("")) {
                    produto.setValor(Double.parseDouble(req.getParameter("valor")));
                }

                //Trata o valor do botão de rádio
                if (req.getParameter("ativo").equals("0")) {
                    produto.setAtivo(false);
                } else {
                    produto.setAtivo(true);
                }

                //Pega o nome do arquivo submetido
                produto.setFoto1(req.getPart("foto1").getSubmittedFileName());
                produto.setFoto2(req.getPart("foto2").getSubmittedFileName());
                produto.setFoto3(req.getPart("foto3").getSubmittedFileName());

                if (produto.isProduto()) {
                    
                    //PARA LINUX
                    //Classe para upload de arquivos fotos JPG
                    /*UpFiles up = new UpFiles();
                    up.setPath("../../web/img/");
                    if (up.send(req, res)) {
                        String fotos[] = up.getFiles();
                        
                        produto.setFoto1(fotos[0]);
                        produto.setFoto2(fotos[1]);
                        produto.setFoto3(fotos[2]);
                        */
                        CtrlProduto ctrlProduto = new CtrlProduto();
                        ctrlProduto.salvar(produto);
                        req.setAttribute("avisos", "Produto cadastrado com sucesso");
                    
                }
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("produto", produto);
            }
            pagina = "indexFunc.jsp?p=cadProduto";
        }

//        //Ação para listar
//        if (req.getParameter("action").equals("list")) {
//            try {
//                ProdutoDAO dao = new ProdutoDAO();
//                req.setAttribute("produtos", dao.findProdutosAll(req.getParameter("busca")));
//                
//            } catch (Exception e) {
//                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
//            }
//            pagina = "index.jsp?p=reportProduto";
//        }
        
        //Ação para listar Form
        if (req.getParameter("action").equals("listProd")) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                req.setAttribute("produtos", dao.findProdutosAll(req.getParameter("nome")));
                
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
            }
            pagina = "index.jsp?p=inicioProd";
        }

        //Ação para apagar
        if (req.getParameter("action").equals("remove")) {
            Produto produto = new Produto();
            try {
                CtrlProduto ctrProduto = new CtrlProduto();
                ctrProduto.remover(Long.parseLong(req.getParameter("id")));
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("produto", produto);
            }
            pagina = "indexFunc.jsp?p=listProd";
        }

        //Ação para Editar
        if (req.getParameter("action").equals("edit")) {
            Produto produto = new Produto();
            try {
                CtrlProduto ctrProduto = new CtrlProduto();
                produto = ctrProduto.buscaID(Long.parseLong(req.getParameter("id")));
                req.setAttribute("alt", true);
            } catch (Exception e) {
                req.setAttribute("Erros: ", e.getMessage().replace(".\n", ".<br>"));
                
            }
            req.setAttribute("produto", produto);
            pagina = "indexFunc.jsp?p=cadProduto";
        }

        //Ação para Alterar
        if (req.getParameter("action").equals("alt")) {
            Produto produto = new Produto();
            try {
                produto.setId(Long.parseLong(req.getParameter("id").trim()));
                produto.setNome(req.getParameter("nome").trim());
                produto.setDescricao(req.getParameter("descricao").trim());
                //Só passa o valor se o paramente do campo number for preenchido
                if (!req.getParameter("quantmin").equals("")) {
                    produto.setQuantMin(Integer.parseInt(req.getParameter("quantmin")));
                }
                if (!req.getParameter("quantmax").equals("")) {
                    produto.setQuantMax(Integer.parseInt(req.getParameter("quantmax")));
                }
                if (!req.getParameter("quantatual").equals("")) {
                    produto.setQuantAtual(Integer.parseInt(req.getParameter("quantatual")));
                }
                if (!req.getParameter("valor").equals("")) {
                    produto.setValor(Double.parseDouble(req.getParameter("valor")));
                }
                //Trata o valor do botão de rádio
                if (req.getParameter("ativo").equals("0")) {
                    produto.setAtivo(false);
                } else {
                    produto.setAtivo(true);
                }

                //Pega o nome do arquivo submetido
                produto.setFoto1(req.getPart("foto1").getSubmittedFileName());
                produto.setFoto2(req.getPart("foto2").getSubmittedFileName());
                produto.setFoto3(req.getPart("foto3").getSubmittedFileName());

                if (produto.isProduto()) {
                    //Classe para upload de arquivos fotos JPG
//                    UpFiles up = new UpFiles();
//                    up.setPath("../../web/img/");
//                    if (up.send(req, res)) {
//                        String fotos[] = up.getFiles();
//                        
//                        produto.setFoto1(fotos[0]);
//                        produto.setFoto2(fotos[1]);
//                        produto.setFoto3(fotos[2]);
                        
                        CtrlProduto ctrlProduto = new CtrlProduto();
                        ctrlProduto.alterar(produto);
                        req.setAttribute("avisos", "Produto alterado com sucesso");
                }
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("produto", produto);
                pagina = "indexFunc.jsp?p=cadProduto";
            }
            req.setAttribute("produto", produto);
        }
        
         if (req.getParameter("action").equals("desc")) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                req.setAttribute("produto", dao.findProduto(Long.parseLong(req.getParameter("id"))));
                
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
            }
        pagina = "index.jsp?p=descProduto";
    }
        //Retorna para a pagina
        return pagina;
    }
    
}

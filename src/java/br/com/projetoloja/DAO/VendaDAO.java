package br.com.projetoloja.DAO;

import br.com.projetoloja.model.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VendaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjetoPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = null;

    //Salvar venda
    public void create(Venda venda) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            em.persist(venda);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {
                re.toString();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Alterar Venda
    public void edit(Venda venda) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            venda = em.merge(venda);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = venda.getId();
                if (findVenda(id) == null) {

                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Apagar venda
    public void destroy(Long id) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            Venda venda = null;
            try {
                venda = em.getReference(Venda.class, id);
                venda.getId();
            } catch (EntityNotFoundException enfe) {

            }
            em.remove(venda);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Busca Venda pelo id
    public Venda findVenda(Long id) {
        try {
            return em.find(Venda.class, id);
        } finally {
            em.close();
        }
    }

    //Buscar todos por nomes
    public List<Venda> findVendasAll(String dados) {
        try {
            Query query = em.createQuery("select p from Venda as p");
            query.setParameter("dados", dados + "%");
            List<Venda> vendas = query.getResultList();
            return vendas;
        } finally {
            em.close();
        }
    }
    
    //Busca todos os vendas ativos
    public List<Venda> findVendas(String dados) {
        try {
            Query query = em.createQuery("select p from Venda as p where p.descricao like :dados and p.ativo = true");
            query.setParameter("dados", dados + "%");
            List<Venda> vendas = query.getResultList();
            return vendas;
        } finally {
            em.close();
        }
    }

}

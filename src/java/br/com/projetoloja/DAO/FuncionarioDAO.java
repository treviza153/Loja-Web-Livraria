package br.com.projetoloja.DAO;

import br.com.projetoloja.model.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FuncionarioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjetoPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = null;

    //Salvar cliente
    public void create(Funcionario funcionario) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            em.persist(funcionario);
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

    //Alterar Cliente
    public void edit(Funcionario funcionario) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            funcionario = em.merge(funcionario);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = funcionario.getId();
                if (findFuncionario(id) == null) {

                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Apagar cliente
    public void destroy(Long id) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            Funcionario funcionario = null;
            try {
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getId();
            } catch (EntityNotFoundException enfe) {

            }
            em.remove(funcionario);
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

    //Busca cliete pelo id
    public Funcionario findFuncionario(Long id) {
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    //Buscar todos por nomes
    public List<Funcionario> findFuncionarios(String dados) {
        try {
            Query query = em.createQuery("select c from Funcionario as c where c.nome like :dados");
            query.setParameter("dados", dados + "%");
            List<Funcionario> funcionarios = query.getResultList();
            return funcionarios;
        } finally {
            em.close();
        }
    }
    
     //Busca cliente pela email e senha
    public Funcionario findFuncionario(String email, String pws) {
        try {
            Query query = em.createQuery(""
                    + "select c from Funcionario as c "
                    + "where c.email = :email and c.pws = :pws");
            query.setParameter("email",email);
            query.setParameter("pws", pws);
            return (Funcionario)query.getSingleResult();        
        } finally {
            em.close();
        }
    }

}

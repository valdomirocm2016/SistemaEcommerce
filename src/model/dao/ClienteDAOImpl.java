/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Cliente;

/**
 *
 * @author Valdomiro
 */
public class ClienteDAOImpl implements ClienteDAO {
    
    @Override
    public void salvarAtualizar(Cliente cliente){
        EntityManager em= Conexao.getEntityManager();
        
        em.getTransaction().begin();
        if(cliente.getCodigo()!=null){
            cliente= em.merge(cliente);
        }
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();    
    }
    @Override
    public void excluir(Cliente cliente){
        EntityManager em= Conexao.getEntityManager();
        em.getTransaction().begin();
        
            cliente= em.merge(cliente);
        
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();    
    }
    @Override
    public List<Cliente> pesquisar(Cliente cliente){
        EntityManager em= Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Cliente c "+"where 1 = 1 ");
        if(cliente.getCodigo() != null){
            sql.append("and c.codigo = :codigo ");
            System.out.println("If 1 "+sql);
        }
        if(cliente.getNome() != null && !cliente.getNome().equals("")){
            sql.append("and c.nome like :nome");
            System.out.println(sql);
        }
        Query query =em.createQuery(sql.toString());
        if(cliente.getCodigo() != null){
            System.out.println("Query 1 "+ cliente.getCodigo());
            query.setParameter("codigo", cliente.getCodigo());
            System.out.println(query);
        }
        if(cliente.getNome() != null && !cliente.getNome().equals("")){
            query.setParameter("nome","%"+ cliente.getNome()+"%");
        }
        return query.getResultList();
    }
}

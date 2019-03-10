/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Produto;

/**
 *
 * @author Valdomiro
 */
public class ProdutoDAOImpl implements ProdutoDAO{

    @Override
    public void excluir(Produto produto) {
        EntityManager em= Conexao.getEntityManager();
        em.getTransaction().begin();
        produto= em.merge(produto);      
        em.remove(produto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Produto> pesquisar(Produto produto) {
        EntityManager em= Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Produto p "+"where 1 = 1 ");
        if(produto.getCodigoprod() != null){
            sql.append("and p.codigoprod = :codigoprod ");
            
        }
        if(produto.getNomeprod() != null && !produto.getNomeprod().equals("")){
            sql.append("and p.nomeprod like :nomeprod");
            
        }
        Query query =em.createQuery(sql.toString());
        if(produto.getCodigoprod() != null){
            
            query.setParameter("codigoprod", produto.getCodigoprod());
            
        }
        if(produto.getNomeprod() != null && !produto.getNomeprod().equals("")){
            query.setParameter("nomeprod","%"+ produto.getNomeprod()+"%");
        }
        return query.getResultList();
    }

    @Override
    public void salvarAtualizar(Produto produto) {
        EntityManager em= Conexao.getEntityManager();
        em.getTransaction().begin();
        if(produto.getCodigoprod()!=null){
            produto= em.merge(produto);
        }
        
        em.persist(produto);
        em.getTransaction().commit();
        em.close(); 
    }
    
}

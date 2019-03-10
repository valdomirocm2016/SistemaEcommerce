/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.dao.ClienteDAO;
import model.dao.ClienteDAOImpl;
import model.dao.ProdutoDAO;
import model.dao.ProdutoDAOImpl;
import model.domain.Produto;

/**
 *
 * @author Valdomiro
 */
public class ServiceLocator {

    public static ClienteDAO getClienteDAO() {
        return new ClienteDAOImpl();
    }
    public static ProdutoDAO getProdutoDAO(){
        return new ProdutoDAOImpl();
    }
    public static Produto getProduto(){
        return new Produto();
    }
    
}

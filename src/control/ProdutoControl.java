/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import model.dao.ProdutoDAO;
import model.domain.Produto;
import model.service.ServiceLocator;
import org.jdesktop.observablecollections.ObservableCollections;
import utili.ValidacaoException;

/**
 *
 * @author Valdomiro
 */
public class ProdutoControl {
     private Produto produtoDigitado;
    private Produto produtoSelecionado;
    private List<Produto> produtoTabela;
    private final ProdutoDAO produtoDAO;
    private final PropertyChangeSupport propertyChangesSupporte = new PropertyChangeSupport(this);
    
    public ProdutoControl(){
        produtoDAO = ServiceLocator.getProdutoDAO();
        produtoTabela= ObservableCollections.observableList(new ArrayList<Produto>());
        novo();
        pesquisar();
    }
    public void salvar() throws ValidacaoException{
        getProdutoDigitado().validarCampoNome();
        produtoDAO.salvarAtualizar(getProdutoDigitado());
        novo();
        pesquisar();
    }
    public void excluir(){
        produtoDAO.excluir(getProdutoDigitado());
        novo();
        pesquisar();
    }
    public void pesquisar(){
        getProdutoTabela().clear();
        getProdutoTabela().addAll(produtoDAO.pesquisar(getProdutoDigitado()));
    }
    public void novo(){
        setProdutoDigitado(new Produto());
    }
    public void setProdutoDigitado(Produto produto){
        Produto oldDigitado = this.produtoDigitado;
        this.produtoDigitado = produto;
        propertyChangesSupporte.firePropertyChange("produtoDigitado",oldDigitado,produtoDigitado);
    }
    public void addPropertyChangeListener(PropertyChangeListener p ){
        propertyChangesSupporte.addPropertyChangeListener(p);
    }
    public void removePropertyChangeListener(PropertyChangeListener p){
        propertyChangesSupporte.removePropertyChangeListener(p);
    }

    /**
     * @return the produtoDigitado
     */
    public Produto getProdutoDigitado() {
        return produtoDigitado;
    }

    /**
     * @return the produtoSelecionado
     */
    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    /**
     * @param produtoSelecionado the produtoSelecionado to set
     */
    public void setProdutoSelecionado(Produto produtoSelecionado) {
        
         this.produtoSelecionado = produtoSelecionado;        
         if(this.produtoSelecionado!=null){
            setProdutoDigitado(produtoSelecionado);
        }
        
    }

    /**
     * @return the produtoTabela
     */
    public List<Produto> getProdutoTabela() {
        return produtoTabela;
    }

    /**
     * @param produtoTabela the produtoTabela to set
     */
    public void setProdutoTabela(List<Produto> produtoTabela) {
        this.produtoTabela = produtoTabela;
    }
}

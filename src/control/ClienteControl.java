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
import model.dao.ClienteDAO;
import model.dao.ClienteDAOImpl;
import model.domain.Cliente;
import model.service.ServiceLocator;
import org.jdesktop.observablecollections.ObservableCollections;
import utili.ValidacaoException;

/**
 *
 * @author Valdomiro
 */
public final class ClienteControl {
    private Cliente clienteDigitado;
    private Cliente clienteSelecionado;
    private List<Cliente> clienteTabela;
    private final ClienteDAO clienteDAO;
    private final PropertyChangeSupport propertyChangesSupporte = new PropertyChangeSupport(this);
    
    public ClienteControl(){
        clienteDAO = ServiceLocator.getClienteDAO();
        clienteTabela= ObservableCollections.observableList(new ArrayList<Cliente>());
        novo();
        pesquisar();
    }

    public void novo() {
        setClienteDigitado(new Cliente());
    }

    public void pesquisar() {
        
        getClienteTabela().clear();
        getClienteTabela().addAll(clienteDAO.pesquisar(getClienteDigitado()));
    }
    public void salvar() throws ValidacaoException{
        
        getClienteDigitado().validar();
        clienteDAO.salvarAtualizar(getClienteDigitado());
        novo();
        pesquisar();
    }
    public void excluir(){
        clienteDAO.excluir(getClienteDigitado());
        novo();
        pesquisar();
        
    }
    public Cliente getClienteDigitado() {
        return clienteDigitado;
    }

    public void setClienteDigitado(Cliente clienteDigitado) {
        Cliente oldDigitado = this.clienteDigitado;
        this.clienteDigitado = clienteDigitado;
        propertyChangesSupporte.firePropertyChange("clienteDigitado",oldDigitado,clienteDigitado);
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
        if(this.clienteSelecionado!=null){
            setClienteDigitado(clienteSelecionado);
        }
    }

    public List<Cliente> getClienteTabela() {
        return clienteTabela;
    }

    public void setClienteTabela(List<Cliente> clienteTabela) {
        this.clienteTabela = clienteTabela;
    }
    public void addPropertyChangeListener(PropertyChangeListener p ){
        propertyChangesSupporte.addPropertyChangeListener(p);
    }
    public void removePropertyChangeListener(PropertyChangeListener p){
        propertyChangesSupporte.removePropertyChangeListener(p);
    }
    
}

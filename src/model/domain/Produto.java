/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import utili.ValidacaoException;

/**
 *
 * @author Valdomiro
 */
@Entity
@Table(name="TB_PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_PRODUTO") 
    private Integer codigoprod;
    @Column(name="NM_PRODUTO",length=255,nullable=false)
    private String nomeprod;
    @Column(name="VL_PRODUTO")
    private Double valorprod;
    @Column(name="QTD_PRODUTO") 
    private Integer qtdgoprod;
    @Column(name="FN_PRODUTO",length=255,nullable=false)
    private String fornecedorprod;
    
    public Produto(){
        
    }

    /**
     * @return the codigoprod
     */
    public Integer getCodigoprod() {
        return codigoprod;
    }

    /**
     * @param codigoprod the codigoprod to set
     */
    public void setCodigoprod(Integer codigoprod) {
        this.codigoprod = codigoprod;
    }

    /**
     * @return the nomeprod
     */
    public String getNomeprod() {
        return nomeprod;
    }

    /**
     * @param nomeprod the nomeprod to set
     */
    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    /**
     * @return the valorprod
     */
    public Double getValorprod() {
        return valorprod;
    }

    /**
     * @param valorprod the valorprod to set
     */
    public void setValorprod(Double valorprod) {
        this.valorprod = valorprod;
    }

    /**
     * @return the qtdgoprod
     */
    public Integer getQtdgoprod() {
        return qtdgoprod;
    }

    /**
     * @param qtdgoprod the qtdgoprod to set
     */
    public void setQtdgoprod(Integer qtdgoprod) {
        this.qtdgoprod = qtdgoprod;
    }

    /**
     * @return the fornecedorprod
     */
    public String getFornecedorprod() {
        return fornecedorprod;
    }

    /**
     * @param fornecedorprod the fornecedorprod to set
     */
    public void setFornecedorprod(String fornecedorprod) {
        this.fornecedorprod = fornecedorprod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoprod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.codigoprod, other.codigoprod)) {
            return false;
        }
        return true;
    }
    public void validarCampoNome() throws ValidacaoException{
        if(this.nomeprod ==  null || this.nomeprod.equals("") || this.fornecedorprod == null || this.fornecedorprod.equals("")){
            
            throw new ValidacaoException("Campo(s) nome não preenchido(s)");
        }
    }
    public void validarCampoValor() throws ValidacaoException{
        if(this.valorprod == null ){
            throw new ValidacaoException("Campo nome não preenchido");
        }
    }
    public void validarCampoQuantidade() throws ValidacaoException{
        if(this.qtdgoprod== null)
        throw new ValidacaoException("Campo nome não preenchido");
    }
   
            
    
    
}

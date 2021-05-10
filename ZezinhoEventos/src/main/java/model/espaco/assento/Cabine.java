/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.espaco.assento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import model.cliente.Cliente;
import model.espaco.Espaco;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cabine.findAll", query = "SELECT c FROM Cabine c"),
    @NamedQuery(name = "Cabine.findByIdCabine", query = "SELECT c FROM Cabine c WHERE c.idCabine = :idCabine"),
    @NamedQuery(name = "Cabine.findByDescricao", query = "SELECT c FROM Cabine c WHERE c.descricao = :descricao")})
public class Cabine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idCabine;
    @Size(max = 4)
    @Column(length = 4)
    private String descricao;
    @JoinColumn(name = "cliente", referencedColumnName = "cpf")
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "espaco", referencedColumnName = "idespaco")
    @ManyToOne
    private Espaco espaco;

    public Cabine() {
    }

    //
    public Cabine(Integer idCabine, String descricao, Cliente cliente, Espaco espaco) {
        this.idCabine = idCabine;
        this.descricao = descricao;
        this.cliente = cliente;
        this.espaco = espaco;
    }
    //
    
    public Cabine(Integer idCabine) {
        this.idCabine = idCabine;
    }

    public Integer getIdCabine() {
        return idCabine;
    }

    public void setIdCabine(Integer idCabine) {
        this.idCabine = idCabine;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCabine != null ? idCabine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabine)) {
            return false;
        }
        Cabine other = (Cabine) object;
        if ((this.idCabine == null && other.idCabine != null) || (this.idCabine != null && !this.idCabine.equals(other.idCabine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.cliente.Cabine[ idCabine=" + idCabine + " ]";
    }
    
}

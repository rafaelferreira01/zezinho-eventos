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
    @NamedQuery(name = "VagaEspecial.findAll", query = "SELECT v FROM VagaEspecial v"),
    @NamedQuery(name = "VagaEspecial.findByIdVagaEspecial", query = "SELECT v FROM VagaEspecial v WHERE v.idVagaEspecial = :idVagaEspecial"),
    @NamedQuery(name = "VagaEspecial.findByDescricao", query = "SELECT v FROM VagaEspecial v WHERE v.descricao = :descricao")})
public class VagaEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idVagaEspecial;
    @Size(max = 4)
    @Column(length = 4)
    private String descricao;
    @JoinColumn(name = "cliente", referencedColumnName = "cpf")
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "espaco", referencedColumnName = "idespaco")
    @ManyToOne
    private Espaco espaco;

    public VagaEspecial() {
    }

    //
    public VagaEspecial(Integer idVagaEspecial, String descricao, Cliente cliente, Espaco espaco) {
        this.idVagaEspecial = idVagaEspecial;
        this.descricao = descricao;
        this.cliente = cliente;
        this.espaco = espaco;
    }
    
    //

    public VagaEspecial(Integer idVagaEspecial) {
        this.idVagaEspecial = idVagaEspecial;
    }

    public Integer getIdVagaEspecial() {
        return idVagaEspecial;
    }

    public void setIdVagaEspecial(Integer idVagaEspecial) {
        this.idVagaEspecial = idVagaEspecial;
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
        hash += (idVagaEspecial != null ? idVagaEspecial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VagaEspecial)) {
            return false;
        }
        VagaEspecial other = (VagaEspecial) object;
        if ((this.idVagaEspecial == null && other.idVagaEspecial != null) || (this.idVagaEspecial != null && !this.idVagaEspecial.equals(other.idVagaEspecial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.cliente.VagaEspecial[ idVagaEspecial=" + idVagaEspecial + " ]";
    }
    
}

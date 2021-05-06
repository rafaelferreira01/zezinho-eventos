/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.espaco.assento;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import model.cliente.Cliente;
import model.espaco.Espaco;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cadeira.findAll", query = "SELECT c FROM Cadeira c"),
    @NamedQuery(name = "Cadeira.findByIdCadeira", query = "SELECT c FROM Cadeira c WHERE c.idCadeira = :idCadeira"),
    @NamedQuery(name = "Cadeira.findByValor", query = "SELECT c FROM Cadeira c WHERE c.valor = :valor")})
public class Cadeira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idCadeira;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double valor;
    @OneToMany(mappedBy = "cadeira")
    private List<Cliente> clienteList;
    @JoinColumn(name = "espaco", referencedColumnName = "idespaco")
    @ManyToOne
    private Espaco espaco;

    public Cadeira() {
    }

    public Cadeira(Integer idCadeira) {
        this.idCadeira = idCadeira;
    }

    public Cadeira(Integer idCadeira, double valor) {
        this.idCadeira = idCadeira;
        this.valor = valor;
    }

    public Integer getIdCadeira() {
        return idCadeira;
    }

    public void setIdCadeira(Integer idCadeira) {
        this.idCadeira = idCadeira;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
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
        hash += (idCadeira != null ? idCadeira.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadeira)) {
            return false;
        }
        Cadeira other = (Cadeira) object;
        if ((this.idCadeira == null && other.idCadeira != null) || (this.idCadeira != null && !this.idCadeira.equals(other.idCadeira))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "roda.testes.banco.Cadeira[ idCadeira=" + idCadeira + " ]";
    }
    
}

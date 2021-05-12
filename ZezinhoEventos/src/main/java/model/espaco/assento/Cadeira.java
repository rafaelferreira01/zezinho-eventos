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
    @NamedQuery(name = "Cadeira.findAll", query = "SELECT c FROM Cadeira c"),
    @NamedQuery(name = "Cadeira.findByIdCadeira", query = "SELECT c FROM Cadeira c WHERE c.idCadeira = :idCadeira"),
    @NamedQuery(name = "Cadeira.findByDescricao", query = "SELECT c FROM Cadeira c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Cadeira.findByEhpgalimento", query = "SELECT c FROM Cadeira c WHERE c.ehpgalimento = :ehpgalimento"),
    @NamedQuery(name = "Cadeira.findByEhmeiaentrada", query = "SELECT c FROM Cadeira c WHERE c.ehmeiaentrada = :ehmeiaentrada")})
public class Cadeira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idCadeira;
    @Size(max = 4)
    @Column(length = 4)
    private String descricao;
    private Boolean ehpgalimento;
    private Boolean ehmeiaentrada;
    @JoinColumn(name = "cliente", referencedColumnName = "cpf")
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "espaco", referencedColumnName = "idespaco")
    @ManyToOne
    private Espaco espaco;

    public Cadeira() {
    }
    
    //
    public Cadeira(Integer idCadeira, String descricao, Cliente cliente, Espaco espaco) {
        this.idCadeira = idCadeira;
        this.descricao = descricao;
        this.cliente = cliente;
        this.espaco = espaco;
    }

    public Cadeira(Integer idCadeira, String descricao, Boolean ehpgalimento, Boolean ehmeiaentrada, Cliente cliente, Espaco espaco) {
        this.idCadeira = idCadeira;
        this.descricao = descricao;
        this.ehpgalimento = ehpgalimento;
        this.ehmeiaentrada = ehmeiaentrada;
        this.cliente = cliente;
        this.espaco = espaco;
    }

      
    public Cadeira(Integer idCadeira, String descricao) {
        this.idCadeira = idCadeira;
        this.descricao = descricao;
    }

    public Boolean getEhpgalimento() {
        return ehpgalimento;
    }

    public void setEhpgalimento(Boolean ehpgalimento) {
        this.ehpgalimento = ehpgalimento;
    }

    public Boolean getEhmeiaentrada() {
        return ehmeiaentrada;
    }

    public void setEhmeiaentrada(Boolean ehmeiaentrada) {
        this.ehmeiaentrada = ehmeiaentrada;
    }
    
    
    
    //

    public Cadeira(Integer idCadeira) {
        this.idCadeira = idCadeira;
    }

    public Integer getIdCadeira() {
        return idCadeira;
    }

    public void setIdCadeira(Integer idCadeira) {
        this.idCadeira = idCadeira;
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
        return "model.cliente.Cadeira[ idCadeira=" + idCadeira + " ]";
    }
    
}

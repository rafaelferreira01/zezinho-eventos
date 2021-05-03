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
import model.espaco.Espaco;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cadeira.findAll", query = "SELECT c FROM Cadeira c"),
    @NamedQuery(name = "Cadeira.findByIdCadeira", query = "SELECT c FROM Cadeira c WHERE c.idCadeira = :idCadeira")})
public class Cadeira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idCadeira;
    @JoinColumn(name = "espaco", referencedColumnName = "idespaco", nullable = false)
    @ManyToOne(optional = false)
    private Espaco espaco;

    public Cadeira() {
    }

    public Cadeira(Integer idCadeira) {
        this.idCadeira = idCadeira;
    }

    public Integer getIdCadeira() {
        return idCadeira;
    }

    public void setIdCadeira(Integer idCadeira) {
        this.idCadeira = idCadeira;
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
        return "model.Cadeira[ idCadeira=" + idCadeira + " ]";
    }
    
}

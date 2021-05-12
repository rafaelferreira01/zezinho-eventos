/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.espaco;

import model.espaco.Espaco;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoEspaco.findAll", query = "SELECT t FROM TipoEspaco t"),
    @NamedQuery(name = "TipoEspaco.findByIdTipoEspaco", query = "SELECT t FROM TipoEspaco t WHERE t.idTipoEspaco = :idTipoEspaco"),
    @NamedQuery(name = "TipoEspaco.findByDescricaoEspaco", query = "SELECT t FROM TipoEspaco t WHERE t.descricaoEspaco = :descricaoEspaco")})
public class TipoEspaco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idTipoEspaco;
    @Size(max = 45)
    @Column(length = 45)
    private String descricaoEspaco;
    @OneToMany(mappedBy = "tipoespaco")
    private List<Espaco> espacoList;

    public TipoEspaco() {
    }

    public TipoEspaco(Integer idTipoEspaco) {
        this.idTipoEspaco = idTipoEspaco;
    }

    public Integer getIdTipoEspaco() {
        return idTipoEspaco;
    }

    public void setIdTipoEspaco(Integer idTipoEspaco) {
        this.idTipoEspaco = idTipoEspaco;
    }

    public String getDescricaoEspaco() {
        return descricaoEspaco;
    }

    public void setDescricaoEspaco(String descricaoEspaco) {
        this.descricaoEspaco = descricaoEspaco;
    }

    public List<Espaco> getEspacoList() {
        return espacoList;
    }

    public void setEspacoList(List<Espaco> espacoList) {
        this.espacoList = espacoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEspaco != null ? idTipoEspaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEspaco)) {
            return false;
        }
        TipoEspaco other = (TipoEspaco) object;
        if ((this.idTipoEspaco == null && other.idTipoEspaco != null) || (this.idTipoEspaco != null && !this.idTipoEspaco.equals(other.idTipoEspaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.cliente.TipoEspaco[ idTipoEspaco=" + idTipoEspaco + " ]";
    }
    
}

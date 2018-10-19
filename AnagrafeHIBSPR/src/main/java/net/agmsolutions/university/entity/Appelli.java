/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.agmsolutions.university.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "appelli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appelli.findAll", query = "SELECT a FROM Appelli a")
    , @NamedQuery(name = "Appelli.findByIdappelli", query = "SELECT a FROM Appelli a WHERE a.idappelli = :idappelli")
    , @NamedQuery(name = "Appelli.findByData", query = "SELECT a FROM Appelli a WHERE a.data = :data")})
public class Appelli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Basic(optional = false)
    @Column(name = "idappelli",unique=true, nullable = false)
    private Integer idappelli;
    @Size(max = 45)
    @Column(name = "Data")
    private String data;
    @JoinColumn(name = "corsi_idcorsi", referencedColumnName = "idcorsi")
    @ManyToOne(optional = false)
    private Corsi corsiIdcorsi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appelliIdappelli")
    private List<Prenotazioni> prenotazioniList;

    public Appelli() {
    }

    public Appelli(Integer idappelli) {
        this.idappelli = idappelli;
    }

    public Integer getIdappelli() {
        return idappelli;
    }

    public void setIdappelli(Integer idappelli) {
        this.idappelli = idappelli;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Corsi getCorsiIdcorsi() {
        return corsiIdcorsi;
    }

    public void setCorsiIdcorsi(Corsi corsiIdcorsi) {
        this.corsiIdcorsi = corsiIdcorsi;
    }

    @XmlTransient
    public List<Prenotazioni> getPrenotazioniList() {
        return prenotazioniList;
    }

    public void setPrenotazioniList(List<Prenotazioni> prenotazioniList) {
        this.prenotazioniList = prenotazioniList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idappelli != null ? idappelli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appelli)) {
            return false;
        }
        Appelli other = (Appelli) object;
        if ((this.idappelli == null && other.idappelli != null) || (this.idappelli != null && !this.idappelli.equals(other.idappelli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.agmsolutions.university.entity.Appelli[ idappelli=" + idappelli + " ]";
    }
    
}

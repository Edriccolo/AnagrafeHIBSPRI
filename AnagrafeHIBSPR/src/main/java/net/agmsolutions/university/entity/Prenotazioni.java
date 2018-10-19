/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.agmsolutions.university.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "prenotazioni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prenotazioni.findAll", query = "SELECT p FROM Prenotazioni p")
    , @NamedQuery(name = "Prenotazioni.findByIdprenotazioni", query = "SELECT p FROM Prenotazioni p WHERE p.idprenotazioni = :idprenotazioni")})
public class Prenotazioni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprenotazioni",unique=true, nullable = false)
    private Integer idprenotazioni;
    @JoinColumn(name = "appelli_idappelli", referencedColumnName = "idappelli")
    @ManyToOne(optional = false)
    private Appelli appelliIdappelli;
    @JoinColumn(name = "studenti_idstudenti", referencedColumnName = "idstudenti")
    @ManyToOne(optional = false)
    private Studenti studentiIdstudenti;

    public Prenotazioni() {
    }

    public Prenotazioni(Integer idprenotazioni) {
        this.idprenotazioni = idprenotazioni;
    }

    public Integer getIdprenotazioni() {
        return idprenotazioni;
    }

    public void setIdprenotazioni(Integer idprenotazioni) {
        this.idprenotazioni = idprenotazioni;
    }

    public Appelli getAppelliIdappelli() {
        return appelliIdappelli;
    }

    public void setAppelliIdappelli(Appelli appelliIdappelli) {
        this.appelliIdappelli = appelliIdappelli;
    }

    public Studenti getStudentiIdstudenti() {
        return studentiIdstudenti;
    }

    public void setStudentiIdstudenti(Studenti studentiIdstudenti) {
        this.studentiIdstudenti = studentiIdstudenti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprenotazioni != null ? idprenotazioni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prenotazioni)) {
            return false;
        }
        Prenotazioni other = (Prenotazioni) object;
        if ((this.idprenotazioni == null && other.idprenotazioni != null) || (this.idprenotazioni != null && !this.idprenotazioni.equals(other.idprenotazioni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.agmsolutions.university.entity.Prenotazioni[ idprenotazioni=" + idprenotazioni + " ]";
    }
    
}

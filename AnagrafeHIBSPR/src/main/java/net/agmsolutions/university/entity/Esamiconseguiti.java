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
@Table(name = "esamiconseguiti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esamiconseguiti.findAll", query = "SELECT e FROM Esamiconseguiti e")
    , @NamedQuery(name = "Esamiconseguiti.findByIdesamiConseguiti", query = "SELECT e FROM Esamiconseguiti e WHERE e.idesamiConseguiti = :idesamiConseguiti")
    , @NamedQuery(name = "Esamiconseguiti.findByVoto", query = "SELECT e FROM Esamiconseguiti e WHERE e.voto = :voto")})
public class Esamiconseguiti implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = IDENTITY)
    @Basic(optional = false)
    @Column(name = "idesamiConseguiti",unique=true, nullable = false)
    private Integer idesamiConseguiti;
    @Column(name = "Voto")
    private Integer voto;
    @JoinColumn(name = "corsi_idcorsi", referencedColumnName = "idcorsi")
    @ManyToOne(optional = false)
    private Corsi corsiIdcorsi;
    @JoinColumn(name = "studenti_idstudenti", referencedColumnName = "idstudenti")
    @ManyToOne(optional = false)
    private Studenti studentiIdstudenti;

    public Esamiconseguiti() {
    }

    public Esamiconseguiti(Integer idesamiConseguiti) {
        this.idesamiConseguiti = idesamiConseguiti;
    }

    public Integer getIdesamiConseguiti() {
        return idesamiConseguiti;
    }

    public void setIdesamiConseguiti(Integer idesamiConseguiti) {
        this.idesamiConseguiti = idesamiConseguiti;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public Corsi getCorsiIdcorsi() {
        return corsiIdcorsi;
    }

    public void setCorsiIdcorsi(Corsi corsiIdcorsi) {
        this.corsiIdcorsi = corsiIdcorsi;
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
        hash += (idesamiConseguiti != null ? idesamiConseguiti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esamiconseguiti)) {
            return false;
        }
        Esamiconseguiti other = (Esamiconseguiti) object;
        if ((this.idesamiConseguiti == null && other.idesamiConseguiti != null) || (this.idesamiConseguiti != null && !this.idesamiConseguiti.equals(other.idesamiConseguiti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.agmsolutions.university.entity.Esamiconseguiti[ idesamiConseguiti=" + idesamiConseguiti + " ]";
    }
    
}

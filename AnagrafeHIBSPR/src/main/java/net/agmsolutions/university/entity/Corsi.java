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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "corsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corsi.findAll", query = "SELECT c FROM Corsi c")
    , @NamedQuery(name = "Corsi.findByIdcorsi", query = "SELECT c FROM Corsi c WHERE c.idcorsi = :idcorsi")
    , @NamedQuery(name = "Corsi.findByNome", query = "SELECT c FROM Corsi c WHERE c.nome = :nome")})
public class Corsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcorsi")
    private Integer idcorsi;
    @Size(max = 45)
    @Column(name = "Nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corsiIdcorsi")
    private List<Appelli> appelliList;
    @JoinColumn(name = "professori_idprofessori", referencedColumnName = "idprofessori")
    @ManyToOne(optional = false)
    private Professori professoriIdprofessori;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corsiIdcorsi")
    private List<Esamiconseguiti> esamiconseguitiList;

    public Corsi() {
    }

    public Corsi(Integer idcorsi) {
        this.idcorsi = idcorsi;
    }

    public Integer getIdcorsi() {
        return idcorsi;
    }

    public void setIdcorsi(Integer idcorsi) {
        this.idcorsi = idcorsi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Appelli> getAppelliList() {
        return appelliList;
    }

    public void setAppelliList(List<Appelli> appelliList) {
        this.appelliList = appelliList;
    }

    public Professori getProfessoriIdprofessori() {
        return professoriIdprofessori;
    }

    public void setProfessoriIdprofessori(Professori professoriIdprofessori) {
        this.professoriIdprofessori = professoriIdprofessori;
    }

    @XmlTransient
    public List<Esamiconseguiti> getEsamiconseguitiList() {
        return esamiconseguitiList;
    }

    public void setEsamiconseguitiList(List<Esamiconseguiti> esamiconseguitiList) {
        this.esamiconseguitiList = esamiconseguitiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcorsi != null ? idcorsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corsi)) {
            return false;
        }
        Corsi other = (Corsi) object;
        if ((this.idcorsi == null && other.idcorsi != null) || (this.idcorsi != null && !this.idcorsi.equals(other.idcorsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.agmsolutions.university.entity.Corsi[ idcorsi=" + idcorsi + " ]";
    }
    
}

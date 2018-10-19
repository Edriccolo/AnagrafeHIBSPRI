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
@Table(name = "professori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professori.findAll", query = "SELECT p FROM Professori p")
    , @NamedQuery(name = "Professori.findByIdprofessori", query = "SELECT p FROM Professori p WHERE p.idprofessori = :idprofessori")
    , @NamedQuery(name = "Professori.findByNome", query = "SELECT p FROM Professori p WHERE p.nome = :nome")
    , @NamedQuery(name = "Professori.findByPassword", query = "SELECT p FROM Professori p WHERE p.password = :password")})
public class Professori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofessori")
    private Integer idprofessori;
    @Size(max = 45)
    @Column(name = "Nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professoriIdprofessori")
    private List<Corsi> corsiList;

    public Professori() {
    }

    public Professori(Integer idprofessori) {
        this.idprofessori = idprofessori;
    }

    public Integer getIdprofessori() {
        return idprofessori;
    }

    public void setIdprofessori(Integer idprofessori) {
        this.idprofessori = idprofessori;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Corsi> getCorsiList() {
        return corsiList;
    }

    public void setCorsiList(List<Corsi> corsiList) {
        this.corsiList = corsiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofessori != null ? idprofessori.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professori)) {
            return false;
        }
        Professori other = (Professori) object;
        if ((this.idprofessori == null && other.idprofessori != null) || (this.idprofessori != null && !this.idprofessori.equals(other.idprofessori))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.agmsolutions.university.entity.Professori[ idprofessori=" + idprofessori + " ]";
    }
    
}

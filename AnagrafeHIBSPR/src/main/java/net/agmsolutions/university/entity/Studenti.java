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
@Table(name = "studenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studenti.findAll", query = "SELECT s FROM Studenti s")
    , @NamedQuery(name = "Studenti.findByIdstudenti", query = "SELECT s FROM Studenti s WHERE s.idstudenti = :idstudenti")
    , @NamedQuery(name = "Studenti.findByNome", query = "SELECT s FROM Studenti s WHERE s.nome = :nome")
    , @NamedQuery(name = "Studenti.findByPassword", query = "SELECT s FROM Studenti s WHERE s.password = :password")})
public class Studenti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstudenti")
    private Integer idstudenti;
    @Size(max = 45)
    @Column(name = "Nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentiIdstudenti")
    private List<Esamiconseguiti> esamiconseguitiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentiIdstudenti")
    private List<Prenotazioni> prenotazioniList;

    public Studenti() {
    }

    public Studenti(Integer idstudenti) {
        this.idstudenti = idstudenti;
    }

    public Integer getIdstudenti() {
        return idstudenti;
    }

    public void setIdstudenti(Integer idstudenti) {
        this.idstudenti = idstudenti;
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
    public List<Esamiconseguiti> getEsamiconseguitiList() {
        return esamiconseguitiList;
    }

    public void setEsamiconseguitiList(List<Esamiconseguiti> esamiconseguitiList) {
        this.esamiconseguitiList = esamiconseguitiList;
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
        hash += (idstudenti != null ? idstudenti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studenti)) {
            return false;
        }
        Studenti other = (Studenti) object;
        if ((this.idstudenti == null && other.idstudenti != null) || (this.idstudenti != null && !this.idstudenti.equals(other.idstudenti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.agmsolutions.university.entity.Studenti[ idstudenti=" + idstudenti + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ghizlane
 */
@Entity
@Table(name = "info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i"),
    @NamedQuery(name = "Info.findByNom", query = "SELECT i FROM Info i WHERE i.nom = :nom"),
    @NamedQuery(name = "Info.findByPrenom", query = "SELECT i FROM Info i WHERE i.prenom = :prenom"),
    @NamedQuery(name = "Info.findByAge", query = "SELECT i FROM Info i WHERE i.age = :age"),
    @NamedQuery(name = "Info.findById", query = "SELECT i FROM Info i WHERE i.id = :id")})
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    public Info() {
    }

    public Info(Integer id) {
        this.id = id;
    }
    public Info(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    public Info(Integer id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Info[ id=" + id + " ]";
    }
    
}

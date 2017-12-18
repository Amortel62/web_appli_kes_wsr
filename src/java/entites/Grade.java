
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Grade implements Serializable {

    @Id
    @XmlTransient    // non sérialisé en XML
    private Long    code;
     
    @XmlAttribute(name="id")
    private String  libelle;
   
    private Float   tauxHoraire;
    
    //<editor-fold defaultstate="collapsed" desc="Getters et Setters">
    
    public Float getTauxHoraire() {
        return tauxHoraire;
    }
    
    public void setTauxHoraire(Float tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    
    
    
    public Long getCode() {
        return code;
    }
    
    public void setCode(Long code) {
        this.code = code;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="HashCode et Equals">
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.code != null ? this.code.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grade other = (Grade) obj;
        if (this.code != other.code && (this.code == null || !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }
    //</editor-fold>
    
}

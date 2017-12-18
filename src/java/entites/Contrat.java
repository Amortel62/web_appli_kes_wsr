package entites;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import static utilitaires.UtilDate.*;
import web.services.xml.adaptateurs.DateAdaptateur;


@Entity
@SequenceGenerator(name = "SequenceIdCont", sequenceName = "SEQ_ID_CONT")

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"dateCont","leClient",
                    "montantContrat","coutTotalContrat",
                    "ecart","lesInterventions"})

public class Contrat implements Serializable {
    
    @Id
    @GeneratedValue(generator = "SequenceIdCont")
    @XmlAttribute(name="id")
    private Long numero;
   
    @ManyToOne
    @XmlElement(name="client")
    private Client leClient;
    
    private Float    montantContrat;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @XmlJavaTypeAdapter(DateAdaptateur.class)
    @XmlElement(name="dateContrat")
    private  Date dateCont;
     
    @Transient     // non stocké dans la base de données
    @XmlElement(name="ecart")
    private Float ecart; 
    
    @Transient    // non stocké dans la base de données
    @XmlElement(name="cout")
    private Float coutTotalContrat; 
   
    @OneToMany(mappedBy = "leContrat")
    @XmlElement(name="intervention")
    private List<Intervention> lesInterventions;
    
    public Float              ecart(){
        
        return this.montantContrat-coutTotalContrat(); 
    
    }
    public Float              coutTotalContrat() {
        
        Float totalIntervs=0f;
        
        for (Intervention interv : lesInterventions){
            
            if (annee(interv.getDateInterv()) == anneeCourante()){
                
                totalIntervs+=interv.coutInterv();
            }    
        }
        return totalIntervs;
    }
    public List<Intervention> getInterventionsAnneeCourante(){
    
       return getInterventionsAnnee(utilitaires.UtilDate.anneeCourante()) ;       
    }
    public List<Intervention> getInterventionsAnnee(int pAnnee){
    
     List<Intervention> lesIntervs= new LinkedList();
     
     for (Intervention interv : this.lesInterventions){ 
         
          if ( annee(interv.getDateInterv())== pAnnee) lesIntervs.add(interv);
             
     }
     return lesIntervs;
      
    }
 
    //<editor-fold defaultstate="collapsed" desc="Getters et Setters">

    
    public Float getCoutTotalContrat() {
        return coutTotalContrat;
    }

    public void setCoutTotalContrat(Float coutTotalContrat) {
        this.coutTotalContrat = coutTotalContrat;
    }
    
    
    public Float getMontantContrat() {
        return montantContrat;
    }

    
     
    public Float getEcart() {
        return ecart;
    }

    public void setEcart(Float ecart) {
        this.ecart = ecart;
    }

    public void setMontantContrat(Float montantContrat) {
        this.montantContrat = montantContrat;
    }
   
    public Client getLeClient() {
        return leClient;
    }
    
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }
   
    
    public Long getNumero() {
        return numero;
    }
    
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    
    
    public List<Intervention> getLesInterventions() {
        return lesInterventions;
    }

    public void setLesInterventions(List<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }
    
    public Date getDateCont() {
        return dateCont;
    }

    public void setDateCont(Date dateCont) {
        this.dateCont = dateCont;
    }
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="HashCode et Equals">
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.numero != null ? this.numero.hashCode() : 0);
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
        final Contrat other = (Contrat) obj;
        if (this.numero != other.numero && (this.numero == null || !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    //</editor-fold>   
}
   

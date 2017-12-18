package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DtoTechnicien {
 
    private Long   numero;
    private String nom;
    private String dateEmbauche;
    private Float  coutHoraireTechnicien;
    private String libelleGrade;
    private Float  tauxHoraire;

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    
    /**
     * @return the numero
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    /**
     * @return the dateEmbauche
     */
    public String getDateEmbauche() {
        return dateEmbauche;
    }

    /**
     * @param dateEmbauche the dateEmbauche to set
     */
    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    /**
     * @return the coutHoraireTechnicien
     */
    public Float getCoutHoraireTechnicien() {
        return coutHoraireTechnicien;
    }

    /**
     * @param coutHoraireTechnicien the coutHoraireTechnicien to set
     */
    public void setCoutHoraireTechnicien(Float coutHoraireTechnicien) {
        this.coutHoraireTechnicien = coutHoraireTechnicien;
    }
      /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
      /**
     * @return the libelleGrade
     */
    public String getLibelleGrade() {
        return libelleGrade;
    }

    /**
     * @param libelleGrade the libelleGrade to set
     */
    public void setLibelleGrade(String libelleGrade) {
        this.libelleGrade = libelleGrade;
    }

    /**
     * @return the tauxHoraire
     */
    public Float getTauxHoraire() {
        return tauxHoraire;
    }

    /**
     * @param tauxHoraire the tauxHoraire to set
     */
    public void setTauxHoraire(Float tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

     //</editor-fold> 

  
  
    
    
    
}


package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DtoInterventionDunTechnicien {

    private Long     numero;
    private Long     numInterv;
    private String   dateInterv;
    private int      duree;
    private Float    coutMO;
    private Float    coutKM;
    private Float    coutInterv;
    private Long     numcont;

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
     * @return the numInterv
     */
    public Long getNumInterv() {
        return numInterv;
    }

    /**
     * @param numInterv the numInterv to set
     */
    public void setNumInterv(Long numInterv) {
        this.numInterv = numInterv;
    }

    /**
     * @return the dateInterv
     */
    public String getDateInterv() {
        return dateInterv;
    }

    /**
     * @param dateInterv the dateInterv to set
     */
    public void setDateInterv(String dateInterv) {
        this.dateInterv = dateInterv;
    }

    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return the coutMO
     */
    public Float getCoutMO() {
        return coutMO;
    }

    /**
     * @param coutMO the coutMO to set
     */
    public void setCoutMO(Float coutMO) {
        this.coutMO = coutMO;
    }

    /**
     * @return the coutKM
     */
    public Float getCoutKM() {
        return coutKM;
    }

    /**
     * @param coutKM the coutKM to set
     */
    public void setCoutKM(Float coutKM) {
        this.coutKM = coutKM;
    }

    /**
     * @return the coutInterv
     */
    public Float getCoutInterv() {
        return coutInterv;
    }

    /**
     * @param coutInterv the coutInterv to set
     */
    public void setCoutInterv(Float coutInterv) {
        this.coutInterv = coutInterv;
    }

    /**
     * @return the numcont
     */
    public Long getNumcont() {
        return numcont;
    }

    /**
     * @param numcont the numcont to set
     */
    public void setNumcont(Long numcont) {
        this.numcont = numcont;
    }
  
    
       
}


package web.services.modeles;

import dto.DtoContrat;
import dto.DtoInterventionDunContrat;
import dto.DtoInterventionDunTechnicien;
import dto.DtoTechnicien;
import entites.Client;
import entites.Contrat;
import entites.Intervention;
import entites.Technicien;
import entites.Grade;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import utilitaires.UtilDate;

public class MethodesWeb {
 
    @Inject dao.consultation.contrat.DaoContrat daoCont;
    @Inject dao.consultation.technicien.DaoTechnicien daoTech;
    @Inject dao.maj.DaoMaj                      daomaj;
    
    public DtoContrat getLeDtoContrat(Long numcont) {
       
        DtoContrat dtoContrat= new DtoContrat();
        
        Contrat    cont=daoCont.getLeContrat(numcont);
        
        dtoContrat.setNumcont(numcont);
        dtoContrat.setDateCont(UtilDate.format(cont.getDateCont()));
        dtoContrat.setNomclient(cont.getLeClient().getNom());
        dtoContrat.setAdrclient(cont.getLeClient().getAdresse());
        dtoContrat.setDistanceKM(cont.getLeClient().getDistanceKM());
        dtoContrat.setMontantContrat(cont.getMontantContrat());
        dtoContrat.setCoutAnnuelContrat(cont.coutTotalContrat());
        dtoContrat.setEcart(cont.ecart()); 
        
        return dtoContrat;  
    }
    public DtoTechnicien getLeDtoTechnicien(Long numero) {
       
        DtoTechnicien dtoTechnicien= new DtoTechnicien();
        
        Technicien tech =daoTech.getLeTechnicien(numero);
        
        dtoTechnicien.setNumero(numero);
        dtoTechnicien.setNom(tech.getNom());
        dtoTechnicien.setDateEmbauche(UtilDate.format(tech.getDateEmbauche()));
        dtoTechnicien.setCoutHoraireTechnicien(tech.coutHoraireTechnicien());
        dtoTechnicien.setLibelleGrade(tech.getLeGrade().getLibelle());
        dtoTechnicien.setTauxHoraire(tech.getLeGrade().getTauxHoraire());

        return dtoTechnicien;  
    }
    
    public List<DtoInterventionDunContrat> getLesDtoInterventionContrat(Long numcont) {
        
        List<DtoInterventionDunContrat> resultat= new LinkedList();
        
        for(Intervention interv : daoCont.getLeContrat(numcont).getInterventionsAnneeCourante()){
        
            DtoInterventionDunContrat dto=new DtoInterventionDunContrat();
            
            dto.setNumcont(numcont);
            dto.setNumInterv(interv.getNumero());
            dto.setDateInterv(UtilDate.format(interv.getDateInterv()));
            dto.setDuree(interv.getDuree());
            dto.setCoutInterv(interv.coutInterv());
            dto.setNomTech(interv.getLeTechnicien().getNom());
            dto.setCoutMO(interv.fraisMO());
            dto.setCoutKM(interv.fraisKM());
            resultat.add(dto);
        }
        return resultat;
    }
    
    public List<DtoInterventionDunTechnicien> getLesDtoInterventionTechnicien(Long numero) {
        
        List<DtoInterventionDunTechnicien> resultat= new LinkedList();
        
        for(Intervention interv : daoTech.getLeTechnicien(numero).getLesInterventions()){
        
            DtoInterventionDunTechnicien dto=new DtoInterventionDunTechnicien();
            
            dto.setNumero(numero);
            dto.setNumInterv(interv.getNumero());
            dto.setCoutMO(interv.fraisMO());
            dto.setCoutKM(interv.fraisKM());
            dto.setCoutInterv(interv.coutInterv());
            dto.setDateInterv(UtilDate.format(interv.getDateInterv()));
            dto.setDuree(interv.getDuree());
            dto.setNumcont(interv.getLeContrat().getNumero());
            
            resultat.add(dto);
        }
        return resultat;
    }
    
    public Contrat getArbreContrat(Long numcont){
       
       Contrat contrat= daoCont.getLeContrat(numcont); 
        
       daomaj.detacherEntite(contrat);
       Client client= contrat.getLeClient();
       daomaj.detacherEntite(client);
       client.setLesContrats(null);
       for (Intervention interv : contrat.getLesInterventions()){
       
             daomaj.detacherEntite(interv);
             interv.setLeContrat(null);
             Technicien tech= interv.getLeTechnicien();
             daomaj.detacherEntite(tech);
             tech.setLesInterventions(null);
       }
        
      return contrat;
    }
    
    public Technicien getArbreTechnicien(Long numero){
       
       Technicien technicien= daoTech.getLeTechnicien(numero); 
        
      
  
       for (Intervention interv : technicien.getLesInterventions()){
       
             daomaj.detacherEntite(interv);
             interv.setLeTechnicien(null);
            
       }
        
      return technicien;
    }
    
}

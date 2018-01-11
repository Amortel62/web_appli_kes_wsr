package web.services.rest;

import dto.DtoContrat;
import dto.DtoInterventionDunContrat;
import entites.Client;
import entites.Contrat;
import entites.Intervention;
import entites.Technicien;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("contrat")
public class WebServRestContrat {
    
    @Inject web.services.modeles.MethodesWeb mw;
    @Inject dao.maj.DaoMaj daomaj;
    @Inject dao.consultation.contrat.DaoContrat daoCont;
    
    @GET
    @Path("infos/{numcont}")
    @Produces({"application/xml","application/json"})
    public DtoContrat getLeContrat(@PathParam("numcont")Long numcont) {
       
        return mw.getLeDtoContrat(numcont);
    }
    
    @GET
    @Path("interventions/{numcont}")
    @Produces({"application/xml","application/json"})
    public List<DtoInterventionDunContrat> getInterventionsContrat(@PathParam("numcont") Long numcont) {
         
        return mw.getLesDtoInterventionContrat(numcont);
        
    }  
   
     
    @GET
    @Path("arbrecontrat/{numcont}")
    @Produces({"application/xml","application/json"})
    public Contrat getArbreContrat(@PathParam("numcont") Long numcont) {
        
       Contrat contrat= daoCont.getLeContrat(numcont); 
   
       Float ecart=contrat.ecart();
       contrat.setEcart(ecart);
       
       Float cout=contrat.coutTotalContrat();
       contrat.setCoutTotalContrat(cout);
    
       //daomaj.detacherEntite(contrat);
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
    
}

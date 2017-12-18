package web.services.rest;

import dto.DtoTechnicien;
import dto.DtoInterventionDunContrat;
import entites.Client;
import entites.Contrat;
import entites.Intervention;
import entites.Technicien;
import entites.Grade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("technicien")
public class WebServRestTechnicien {
    
    @Inject web.services.modeles.MethodesWeb mw;
    @Inject dao.maj.DaoMaj daomaj;
    @Inject dao.consultation.technicien.DaoTechnicien daoTech;
    
    @GET
    @Path("infos/{numero}")
    @Produces({"application/xml","application/json"})
    public DtoTechnicien getLeTechnicien(@PathParam("numero")Long numero) {
       
        return mw.getLeDtoTechnicien(numero);
    
    
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame.service;

import OnlineGame.Gameinstance;
import OnlineGame.GameinstancePK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author AKA
 */
@javax.ejb.Stateless
@Path("onlinegame.gameinstance")
public class GameinstanceFacadeREST extends AbstractFacade<Gameinstance> {
    @PersistenceContext(unitName = "backendPU")
    private EntityManager em;

    private GameinstancePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;gameInstanceId=gameInstanceIdValue;initiatingUser=initiatingUserValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        OnlineGame.GameinstancePK key = new OnlineGame.GameinstancePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> gameInstanceId = map.get("gameInstanceId");
        if (gameInstanceId != null && !gameInstanceId.isEmpty()) {
            key.setGameInstanceId(new java.lang.Integer(gameInstanceId.get(0)));
        }
        java.util.List<String> initiatingUser = map.get("initiatingUser");
        if (initiatingUser != null && !initiatingUser.isEmpty()) {
            key.setInitiatingUser(new java.lang.Integer(initiatingUser.get(0)));
        }
        return key;
    }

    public GameinstanceFacadeREST() {
        super(Gameinstance.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Gameinstance entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Gameinstance entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        OnlineGame.GameinstancePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Gameinstance find(@PathParam("id") PathSegment id) {
        OnlineGame.GameinstancePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Gameinstance> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Gameinstance> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

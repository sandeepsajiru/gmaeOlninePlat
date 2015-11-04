/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinegaming.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import onlinegaming.dblayer.*;

@Path("gameInstances")
public class GameInstanceRoutes {

    @GET
    @Produces("application/json")
    public List<GameInstance> getAllGameInstances() {
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        return dbLayer.getAllGameInstances();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public GameInstance getGameInstance(@PathParam("id") int id) {
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        return dbLayer.getGameInstance(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public String updateGameStatus(@PathParam("id") int id, GameInstance gi) {
        JsonResponse response = new JsonResponse();
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        String s = gi.getStatus();
        if (s.equals("InProgress") || s.equals("Finished") || s.equals("Aborted") || s.equals("Waiting")) {
            dbLayer.updateGameStatus(id, s);
            if (s.equals("Finished") || s.equals("Aborted")) {
                dbLayer.updateGameEndTime(id);
            }
            response.addProperty("success", "true");
        } else {
            response.addProperty("success", "false");
            response.addProperty("msg", "Status must be InProgress, Finished, Waiting or Aborted");
        }
        return response.toString();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String startGame(GameInstance gi) {
        JsonResponse response = new JsonResponse();
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        if (dbLayer.startGame(gi.getGameId(), gi.getInitiatingUser())) {
            response.addProperty("success", "true");
        } else {
            response.addProperty("success", "false");
        }
        return response.toString();
    }

}

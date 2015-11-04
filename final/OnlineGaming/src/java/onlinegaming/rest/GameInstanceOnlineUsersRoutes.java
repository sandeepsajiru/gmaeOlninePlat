package onlinegaming.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import onlinegaming.dblayer.*;

@Path("gameInstancesOnlineUsers")
public class GameInstanceOnlineUsersRoutes {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String joinGameByUser(GameInstanceOnlineUsers giou) {
        JsonResponse response = new JsonResponse();
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        if (dbLayer.joinGameByUser(giou.getGameInstanceId(), giou.getUserId())) {
            response.addProperty("success", "true");
        } else {
            response.addProperty("success", "false");
        }
        return response.toString();
    }

    @PUT
    @Path("/score")
    @Consumes("application/json")
    @Produces("application/json")
    public String updateScore(GameInstanceOnlineUsers giou) {
        JsonResponse response = new JsonResponse();
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        if (dbLayer.updateUserScore(giou.getGameInstanceId(), giou.getUserId(), giou.getUserScore())) {
            response.addProperty("success", "true");
        } else {
            response.addProperty("success", "false");
        }
        return response.toString();
    }

    @PUT
    @Path("/endGame")
    @Consumes("application/json")
    @Produces("application/json")
    public String endGameByUser(GameInstanceOnlineUsers giou) {
        JsonResponse response = new JsonResponse();
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        if (dbLayer.endGameByUser(giou.getGameInstanceId(), giou.getUserId(), giou.getUserGameStatus())) {
            response.addProperty("success", "true");
        } else {
            response.addProperty("success", "false");
        }
        return response.toString();
    }

}

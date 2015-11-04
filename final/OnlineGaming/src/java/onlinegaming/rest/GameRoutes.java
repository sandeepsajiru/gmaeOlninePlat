package onlinegaming.rest;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import onlinegaming.dblayer.*;

@Path("games")
public class GameRoutes {

    public GameRoutes() {
    }

    @GET
    @Produces("application/json")
    public List<Game> getAllGames() {
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        return dbLayer.getAllGames();
    }
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Game getGame(@PathParam("id") int id) {
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        return dbLayer.getGame(id);
    }

}

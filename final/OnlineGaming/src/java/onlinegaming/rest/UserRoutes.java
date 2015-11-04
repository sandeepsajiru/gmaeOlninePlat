/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinegaming.rest;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MultivaluedMap;
import onlinegaming.dblayer.*;

@Path("users")
public class UserRoutes {

    public UserRoutes() {
    }

    @GET
    @Produces("application/json")
    public List<User> getAllUsers() {
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        return dbLayer.getAllUsers();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) {
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        return dbLayer.getUser(id);
    }

    @POST
    @Produces("application/json")
    public String registerUser(MultivaluedMap<String, String> formParams) {
        JsonResponse response = new JsonResponse();
        String name = formParams.getFirst("name");
        String email = formParams.getFirst("email");
        String password = formParams.getFirst("password");
        String nickname = formParams.getFirst("nickname");
        String avatarImgPath = formParams.getFirst("avatarImgPath");
        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        if (!dbLayer.isAlreadyRegistered(email)) {
            if (dbLayer.registerUser(name, email, password, nickname, avatarImgPath, 0)) {
                response.addProperty("success", "true");
            } else {
                response.addProperty("success", "false");
                response.addProperty("msg", "Registration failed, try again");
            }
        } else {
            response.addProperty("success", "false");
            response.addProperty("msg", "User already registered with given email");
        }
        return response.toString();
    }

    @POST
    @Produces("application/json")
    @Path("/login")
    public String doLogin(MultivaluedMap<String, String> formParams) {
        JsonResponse response = new JsonResponse();
        String email = formParams.getFirst("email");
        String password = formParams.getFirst("password");

        OnilneGameDBLayer dbLayer = new OnilneGameDBLayer();
        if (dbLayer.isUserValid(email, password)) {
            response.addProperty("success", "true");
        } else {
            response.addProperty("success", "false");
        }
        return response.toString();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author AKA
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(OnlineGame.service.GameFacadeREST.class);
        resources.add(OnlineGame.service.GameinstanceFacadeREST.class);
        resources.add(OnlineGame.service.GameinstanseonlineusersFacadeREST.class);
        resources.add(OnlineGame.service.OnlineusersFacadeREST.class);
        resources.add(OnlineGame.service.RunninggameFacadeREST.class);
        resources.add(OnlineGame.service.UserFacadeREST.class);
    }
    
}

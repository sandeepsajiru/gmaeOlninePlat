/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinegaming.dblayer.unittests;

import onlinegaming.dblayer.OnilneGameDBLayer;



/**
 *
 * @author sandy
 */
public class UserUnitTests {
    
    public static void main(String[] args) {
        
        OnilneGameDBLayer ogdbl = new OnilneGameDBLayer();
        //ogdbl.registerUser("dummy", "test", "testPWD", "nick", "",  1);
        ogdbl.setUserOnline(0, "test");
        System.out.println(ogdbl.isAlreadyRegistered("test"));
        System.out.println(ogdbl.isUserValid("test", "testPWD"));
    }
}

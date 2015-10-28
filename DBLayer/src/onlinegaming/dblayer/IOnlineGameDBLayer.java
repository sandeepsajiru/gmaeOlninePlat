/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinegaming.dblayer;

import java.util.HashMap;

/**
 *
 * @author sandy
 */
public interface IOnlineGameDBLayer {
 
    boolean isUserValid(String userEmail, String pwd);
    boolean isAlreadyRegistered(String userEmail);
    boolean registerUser(String name, String email, String pwd, String nickName, String avatarImagePath, Integer isOnline);
    boolean isUserOnline(String userEmail);
    void setUserOnline(Integer isOnline, String userEmail);
    
}

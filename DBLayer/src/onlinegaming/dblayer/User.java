/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinegaming.dblayer;

/**
 *
 * @author sandy
 */
public class User {

    Integer id;
    String name;
    String email;
    String pwd;
    String nickName;
    String avatarImagePath;
    Integer isOnline;

    public User(Integer id, String name, String email, String pwd, String nickName, String avatarImagePath, Integer isOnline) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.nickName = nickName;
        this.avatarImagePath = avatarImagePath;
        this.isOnline = isOnline;
    }

    
}

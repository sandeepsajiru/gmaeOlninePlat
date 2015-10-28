/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinegaming.dblayer;

import java.sql.ResultSet;

/**
 *
 * @author sandy
 */
public class OnilneGameDBLayer implements IOnlineGameDBLayer{
    
    DBManager dbManager;
    public static final String USER_TABLE = "user";
    public static final String USER_VALID_QUERY = "select * from user where Email=? and Password=?";   
    public static final String USER_ALREADY_THERE_QUERY = "select * from user where Email=?";
    public static final String USER_ONLINE_QUERY = "select * from user where OnlineStatus=?";
    public static final String REGISTER_USER_QUERY = "INSERT INTO USER (NAME, Email, Password, NickName, AvatarImgPath, OnlineStatus) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_ONLINE_STATUS = "UPDATE User SET OnlineStatus = ? WHERE Email = ?";

    public OnilneGameDBLayer() {
        
        dbManager = new DBManager();
    }

    @Override
    public boolean isUserValid(String userEmail, String pwd) {
        ResultSet rs = dbManager.runSelectQuery(USER_VALID_QUERY, userEmail, pwd);
        return dbManager.getRowCount(rs)==1;
    }

    @Override
    public boolean isAlreadyRegistered(String userEmail) {
        ResultSet rs = dbManager.runSelectQuery(USER_ALREADY_THERE_QUERY, userEmail);
        return dbManager.getRowCount(rs)>0;   
    }

    @Override
    public boolean registerUser(String name, String email, String pwd, String nickName, String avatarImagePath, Integer isOnline) {
        int rc = dbManager.runRegisterUserQuery(REGISTER_USER_QUERY, name, email, pwd, nickName, avatarImagePath, isOnline);
        return rc==1;
        
    }

    @Override
    public boolean isUserOnline(String userEmail) {
        ResultSet rs = dbManager.runSelectQuery(USER_ONLINE_QUERY, userEmail);
        return dbManager.getRowCount(rs)==1;
    }

    @Override
    public void setUserOnline(Integer isOnline, String userEmail) {
        int rc = dbManager.runUpdateOnlineStatusQuery(UPDATE_ONLINE_STATUS, isOnline, userEmail);
        if(rc==0)
            throw new RuntimeException("Failed to Update");
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinegaming.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandy
 */
public class DBManager {

    String dbName = "onlineGaming";
    String dbUserName = "root";
    String dbPwd = "root";
    String loginTable = "user";
    Connection con;
    PreparedStatement ps;

    DBManager() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, dbUserName, dbPwd);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DBManager(String dbName, String userName, String password) {
        this.dbName = dbName;
        this.dbUserName = userName;
        this.dbPwd = password;
    }

    public ResultSet runSelectQuery(String query, String... params) {

        ResultSet rs = null;
        try {
            //ps = con.prepareStatement("select * from " + loginTable + " where Email=? and Password=?");
            ps = con.prepareStatement(query);

            for (int i = 1; i <= params.length; i++) {
                ps.setString(i, params[i]);
            }

            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet runSelectQuery(String query) {
        ResultSet rs = null;
        try {
            //ps = con.prepareStatement("select * from " + loginTable + " where Email=? and Password=?");
            Statement st = con.createStatement();

            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int getRowCount(ResultSet rs) {
        try {
            if (rs.last()) {
                return rs.getRow();
            }
        } catch (Exception ex) {

        }
        return 0;
    }

    Map<String, Object> getDBRow(String tableName, String query) {
        return null;
    }

    List<Object> getDBColumn(String tableName, String query) {
        return null;
    }

    int runRegisterUserQuery(String query, String name, String email, String pwd, String nickName, String avatarImagePath, Integer online) {
        try {
            ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pwd);
            ps.setString(4, nickName);
            ps.setString(5, avatarImagePath);
            ps.setInt(6, online);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    int runUpdateOnlineStatusQuery(String query, Integer online, String email) {
        try {
            ps = con.prepareStatement(query);

            ps.setInt(1, online);
            ps.setString(2, email);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

package onlinegaming.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {

    String dbName = "mydb";
    String dbUserName = "root";
    String dbPwd = "111_aaaa";
    String loginTable = "user";
    Connection con;
    PreparedStatement ps;

    DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, dbUserName, dbPwd);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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

            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
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

    public ResultSet runGetUserQuery(String query, Integer userId) {

        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet runGetGameQuery(String query, Integer gameId) {

        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, gameId);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    int runStartGameQuery(String query, Integer gameId, String status, Date start, Integer userId) {
        try {
            ps = con.prepareStatement(query);

            ps.setInt(1, gameId);
            ps.setString(2, status);
            ps.setTimestamp(3, new java.sql.Timestamp(start.getTime()));
            ps.setInt(4, userId);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    int runUpdateGameStatusQuery(String query, String status, int gameId) {
        try {
            ps = con.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, gameId);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    int runUpdateGameEndTime(String query, int gameId) {
        try {
            ps = con.prepareStatement(query);

            Date currentTime = new Date();
            ps.setTimestamp(1, new java.sql.Timestamp(currentTime.getTime()));
            ps.setInt(2, gameId);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    ResultSet runGetGameInstanceQuery(String query, int id) {
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    int runJoinGameQuery(String query, Integer gameInstanceId, Integer userId, int userGameStatus, Timestamp userJoiningTime) {
        try {
            ps = con.prepareStatement(query);

            ps.setInt(1, gameInstanceId);
            ps.setInt(2, userId);
            ps.setInt(3, userGameStatus);
            ps.setTimestamp(4, userJoiningTime);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    int runUpdateUserScoreQuery(String query, Integer gameInstanceId, Integer userId, int score) {
        try {
            ps = con.prepareStatement(query);

            ps.setInt(1, score);
            ps.setInt(2, gameInstanceId);
            ps.setInt(3, userId);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    int endGameByUserQuery(String query, Integer gameInstanceId, Integer userId, int userGameStatus, Timestamp userLeavingTime) {
        try {
            ps = con.prepareStatement(query);

            ps.setInt(1, userGameStatus);
            ps.setTimestamp(2, userLeavingTime);
            ps.setInt(3, gameInstanceId);
            ps.setInt(4, userId);

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}

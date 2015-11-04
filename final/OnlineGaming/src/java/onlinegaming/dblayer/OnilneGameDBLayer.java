package onlinegaming.dblayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnilneGameDBLayer implements IOnlineGameDBLayer {

    DBManager dbManager;
    public static final String USER_TABLE = "user";
    public static final String USER_VALID_QUERY = "select * from user where Email=? and Password=?";
    public static final String USER_ALREADY_THERE_QUERY = "select * from user where Email=?";
    public static final String USER_ONLINE_QUERY = "select * from user where OnlineStatus=?";
    public static final String REGISTER_USER_QUERY = "INSERT INTO USER (NAME, Email, Password, NickName, AvatarImgPath, OnlineStatus) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_ONLINE_STATUS = "UPDATE User SET OnlineStatus = ? WHERE Email = ?";
    public static final String GET_USER_QUERY = "select * from user where UserId=?";
    public static final String GET_ALL_USERS_QUERY = "select * from user";
    public static final String GET_ALL_GAMES_QUERY = "select * from game";
    public static final String GET_GAME_QUERY = "select * from game where GameId=?";
    public static final String START_GAME_QUERY = "INSERT INTO GameInstance (GameId, Status, StartTime, InitiatingUser) VALUES (?,?,?,?)";
    public static final String UPDATE_GAMEINSTANCE_STATUS = "UPDATE GameInstance SET Status = ? WHERE GameInstanceId = ?";
    public static final String UPDATE_GAMEINSTANCE_ENDTIME = "UPDATE GameInstance SET EndTime = ? WHERE GameInstanceId = ?";
    public static final String GET_ALL_GAMEINSTANCES_QUERY = "select * from GameInstance";
    public static final String GET_GAMEINSTANCE_QUERY = "select * from GameInstance where GameInstanceId = ?";
    public static final String JOIN_GAME_QUERY = "INSERT INTO GameInstanseOnlineUsers (GameInstanceId, UserId, UserGameStatus, UserJoiningTime) VALUES (?,?,?,?)";
    public static final String UPDATE_USER_SCORE_QUERY = "UPDATE GameInstanseOnlineUsers SET UserScore = ? WHERE GameInstanceId = ? and UserId = ?";
    public static final String END_GAME_QUERY = "UPDATE GameInstanseOnlineUsers SET UserGameStatus = ?, UserLeavingTime = ? WHERE GameInstanceId = ? and UserId = ?";
    
    public OnilneGameDBLayer() {

        dbManager = new DBManager();
    }

    @Override
    public boolean isUserValid(String userEmail, String pwd) {
        ResultSet rs = dbManager.runSelectQuery(USER_VALID_QUERY, userEmail, pwd);
        return dbManager.getRowCount(rs) == 1;
    }

    @Override
    public boolean isAlreadyRegistered(String userEmail) {
        ResultSet rs = dbManager.runSelectQuery(USER_ALREADY_THERE_QUERY, userEmail);
        return dbManager.getRowCount(rs) > 0;
    }

    @Override
    public boolean registerUser(String name, String email, String pwd, String nickName, String avatarImagePath, Integer isOnline) {
        int rc = dbManager.runRegisterUserQuery(REGISTER_USER_QUERY, name, email, pwd, nickName, avatarImagePath, isOnline);
        return rc == 1;
    }

    @Override
    public boolean isUserOnline(String userEmail) {
        ResultSet rs = dbManager.runSelectQuery(USER_ONLINE_QUERY, userEmail);
        return dbManager.getRowCount(rs) == 1;
    }

    @Override
    public void setUserOnline(Integer isOnline, String userEmail) {
        int rc = dbManager.runUpdateOnlineStatusQuery(UPDATE_ONLINE_STATUS, isOnline, userEmail);
        if (rc == 0) {
            throw new RuntimeException("Failed to Update");
        }
    }

    @Override
    public User getUser(Integer userId) {
        User u = null;
        try {
            ResultSet rs = dbManager.runGetUserQuery(GET_USER_QUERY, userId);
            if (rs.next()) {
                u = new User();
                u.setUserId(rs.getInt("UserId"));
                u.setName(rs.getString("Name"));
                u.setEmail(rs.getString("Email"));
                u.setPassword(rs.getString("Password"));
                u.setNickname(rs.getString("Nickname"));
                u.setAvatarImgPath(rs.getString("AvatarImgPath"));
                u.setOnlineStatus(rs.getInt("OnlineStatus"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnilneGameDBLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet rs = dbManager.runSelectQuery(GET_ALL_USERS_QUERY);
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("UserId"));
                u.setName(rs.getString("Name"));
                u.setEmail(rs.getString("Email"));
                u.setPassword(rs.getString("Password"));
                u.setNickname(rs.getString("Nickname"));
                u.setAvatarImgPath(rs.getString("AvatarImgPath"));
                u.setOnlineStatus(rs.getInt("OnlineStatus"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnilneGameDBLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        try {
            ResultSet rs = dbManager.runSelectQuery(GET_ALL_GAMES_QUERY);
            while (rs.next()) {
                Game g = new Game();
                g.setGameId(rs.getInt("GameId"));
                g.setDesc(rs.getString("Desc"));
                g.setHelp(rs.getString("Help"));
                g.setName(rs.getString("Name"));
                g.setImgPath(rs.getString("ImgPath"));
                g.setMaxUsers(rs.getInt("MaxUsers"));
                g.setMinUsers(rs.getInt("MinUsers"));
                games.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnilneGameDBLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return games;
    }

    @Override
    public Game getGame(int gameId) {
        Game g = null;
        try {
            ResultSet rs = dbManager.runGetGameQuery(GET_GAME_QUERY, gameId);
            if (rs.next()) {
                g = new Game();
                g.setGameId(rs.getInt("GameId"));
                g.setDesc(rs.getString("Desc"));
                g.setHelp(rs.getString("Help"));
                g.setName(rs.getString("Name"));
                g.setImgPath(rs.getString("ImgPath"));
                g.setMaxUsers(rs.getInt("MaxUsers"));
                g.setMinUsers(rs.getInt("MinUsers"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnilneGameDBLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    public boolean startGame(int gameId, int userId) {
        int rc = dbManager.runStartGameQuery(START_GAME_QUERY, gameId, "Waiting", new Date(), userId);
        return rc == 1;
    }

    public boolean updateGameStatus(int gameId, String status) {
        int rc = dbManager.runUpdateGameStatusQuery(UPDATE_GAMEINSTANCE_STATUS, status, gameId);
        return rc == 1;
    }

    public boolean updateGameEndTime(int gameId) {
        int rc = dbManager.runUpdateGameEndTime(UPDATE_GAMEINSTANCE_ENDTIME, gameId);
        return rc == 1;
    }

    public List<GameInstance> getAllGameInstances() {
        List<GameInstance> instances = new ArrayList<>();
        try {
            ResultSet rs = dbManager.runSelectQuery(GET_ALL_GAMEINSTANCES_QUERY);
            while (rs.next()) {
                GameInstance gi = new GameInstance();
                gi.setGameInstanceId(rs.getInt("GameInstanceId"));
                gi.setGameId(rs.getInt("GameId"));
                gi.setStatus(rs.getString("Status"));
                gi.setStartTime(rs.getTimestamp("StartTime"));
                gi.setEndTime(rs.getTimestamp("EndTime"));
                gi.setInitiatingUser(rs.getInt("InitiatingUser"));
                instances.add(gi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnilneGameDBLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instances;
    }

    public GameInstance getGameInstance(int id) {
        try {
            ResultSet rs = dbManager.runGetGameInstanceQuery(GET_GAMEINSTANCE_QUERY, id);
            if (rs.next()) {
                GameInstance gi = new GameInstance();
                gi.setGameInstanceId(rs.getInt("GameInstanceId"));
                gi.setGameId(rs.getInt("GameId"));
                gi.setStatus(rs.getString("Status"));
                gi.setStartTime(rs.getTimestamp("StartTime"));
                gi.setEndTime(rs.getTimestamp("EndTime"));
                gi.setInitiatingUser(rs.getInt("InitiatingUser"));
                return gi;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnilneGameDBLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean joinGameByUser(Integer gameInstanceId, Integer userId) {
        Date currentTime = new Date();
        int rc = dbManager.runJoinGameQuery(JOIN_GAME_QUERY, gameInstanceId, userId, 0, new java.sql.Timestamp(currentTime.getTime()));
        return rc == 1;
    }

    public boolean updateUserScore(Integer gameInstanceId, Integer userId, int score) {
        int rc = dbManager.runUpdateUserScoreQuery(UPDATE_USER_SCORE_QUERY, gameInstanceId, userId, score);
        return rc == 1;
    }

    public boolean endGameByUser(Integer gameInstanceId, Integer userId, Integer userGameStatus) {
        Date currentTime = new Date();
        int rc = dbManager.endGameByUserQuery(END_GAME_QUERY, gameInstanceId, userId, userGameStatus, new java.sql.Timestamp(currentTime.getTime()));
        return rc == 1;
    }
}

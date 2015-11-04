package onlinegaming.dblayer;

import java.util.Date;

public class GameInstanceOnlineUsers {

    private Integer gameInstanceId;
    private Integer userId;
    private Integer userScore;
    private Integer userGameStatus;
    private Date userJoiningTime;
    private Date userLeavingTime;

    public GameInstanceOnlineUsers() {
    }

    public GameInstanceOnlineUsers(Integer gameInstanceId, Integer userId, Integer userScore, Integer userGameStatus, Date userJoiningTime, Date userLeavingTime) {
        this.gameInstanceId = gameInstanceId;
        this.userId = userId;
        this.userScore = userScore;
        this.userGameStatus = userGameStatus;
        this.userJoiningTime = userJoiningTime;
        this.userLeavingTime = userLeavingTime;
    }

    public Integer getGameInstanceId() {
        return gameInstanceId;
    }

    public void setGameInstanceId(Integer gameInstanceId) {
        this.gameInstanceId = gameInstanceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Integer getUserGameStatus() {
        return userGameStatus;
    }

    public void setUserGameStatus(Integer userGameStatus) {
        this.userGameStatus = userGameStatus;
    }

    public Date getUserJoiningTime() {
        return userJoiningTime;
    }

    public void setUserJoiningTime(Date userJoiningTime) {
        this.userJoiningTime = userJoiningTime;
    }

    public Date getUserLeavingTime() {
        return userLeavingTime;
    }

    public void setUserLeavingTime(Date userLeavingTime) {
        this.userLeavingTime = userLeavingTime;
    }
}

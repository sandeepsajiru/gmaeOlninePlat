package onlinegaming.dblayer;

import java.util.Date;

public class GameInstance {

    private Integer gameInstanceId;
    private Integer gameId;
    private String status;
    private Date startTime;
    private Date endTime;
    private Integer initiatingUser;

    public GameInstance() {
    } 

    public GameInstance(Integer gameInstanceId, Integer gameId, String status, Date startTime, Date endTime, Integer initiatingUser) {
        this.gameInstanceId = gameInstanceId;
        this.gameId = gameId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.initiatingUser = initiatingUser;
    }

    public Integer getGameInstanceId() {
        return gameInstanceId;
    }

    public void setGameInstanceId(Integer gameInstanceId) {
        this.gameInstanceId = gameInstanceId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getInitiatingUser() {
        return initiatingUser;
    }

    public void setInitiatingUser(Integer initiatingUser) {
        this.initiatingUser = initiatingUser;
    }

}

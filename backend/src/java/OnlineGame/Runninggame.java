/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AKA
 */
@Entity
@Table(name = "runninggame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Runninggame.findAll", query = "SELECT r FROM Runninggame r"),
    @NamedQuery(name = "Runninggame.findByGameInstanceId", query = "SELECT r FROM Runninggame r WHERE r.gameInstanceId = :gameInstanceId"),
    @NamedQuery(name = "Runninggame.findByGameId", query = "SELECT r FROM Runninggame r WHERE r.gameId = :gameId"),
    @NamedQuery(name = "Runninggame.findByStatus", query = "SELECT r FROM Runninggame r WHERE r.status = :status"),
    @NamedQuery(name = "Runninggame.findByStartTime", query = "SELECT r FROM Runninggame r WHERE r.startTime = :startTime"),
    @NamedQuery(name = "Runninggame.findByEndTime", query = "SELECT r FROM Runninggame r WHERE r.endTime = :endTime"),
    @NamedQuery(name = "Runninggame.findByInitiatingUser", query = "SELECT r FROM Runninggame r WHERE r.initiatingUser = :initiatingUser")})
public class Runninggame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "GameInstanceId")
    private int gameInstanceId;
    @Basic(optional = false)
    @Column(name = "GameId")
    private int gameId;
    @Column(name = "Status")
    private String status;
    @Column(name = "StartTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "EndTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "InitiatingUser")
    private int initiatingUser;

    public Runninggame() {
    }

    public int getGameInstanceId() {
        return gameInstanceId;
    }

    public void setGameInstanceId(int gameInstanceId) {
        this.gameInstanceId = gameInstanceId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
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

    public int getInitiatingUser() {
        return initiatingUser;
    }

    public void setInitiatingUser(int initiatingUser) {
        this.initiatingUser = initiatingUser;
    }
    
}

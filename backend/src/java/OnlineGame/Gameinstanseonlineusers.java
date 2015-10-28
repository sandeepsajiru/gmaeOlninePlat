/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gameinstanseonlineusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gameinstanseonlineusers.findAll", query = "SELECT g FROM Gameinstanseonlineusers g"),
    @NamedQuery(name = "Gameinstanseonlineusers.findByGameInstanceId", query = "SELECT g FROM Gameinstanseonlineusers g WHERE g.gameinstanseonlineusersPK.gameInstanceId = :gameInstanceId"),
    @NamedQuery(name = "Gameinstanseonlineusers.findByUserId", query = "SELECT g FROM Gameinstanseonlineusers g WHERE g.gameinstanseonlineusersPK.userId = :userId"),
    @NamedQuery(name = "Gameinstanseonlineusers.findByUserScore", query = "SELECT g FROM Gameinstanseonlineusers g WHERE g.userScore = :userScore"),
    @NamedQuery(name = "Gameinstanseonlineusers.findByUserGameStatus", query = "SELECT g FROM Gameinstanseonlineusers g WHERE g.userGameStatus = :userGameStatus"),
    @NamedQuery(name = "Gameinstanseonlineusers.findByUserJoiningTime", query = "SELECT g FROM Gameinstanseonlineusers g WHERE g.userJoiningTime = :userJoiningTime"),
    @NamedQuery(name = "Gameinstanseonlineusers.findByUserLeavingTime", query = "SELECT g FROM Gameinstanseonlineusers g WHERE g.userLeavingTime = :userLeavingTime")})
public class Gameinstanseonlineusers implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GameinstanseonlineusersPK gameinstanseonlineusersPK;
    @Column(name = "UserScore")
    private Integer userScore;
    @Column(name = "UserGameStatus")
    private Integer userGameStatus;
    @Column(name = "UserJoiningTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userJoiningTime;
    @Column(name = "UserLeavingTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userLeavingTime;
    @JoinColumn(name = "GameInstanceId", referencedColumnName = "GameInstanceId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Gameinstance gameinstance;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Gameinstanseonlineusers() {
    }

    public Gameinstanseonlineusers(GameinstanseonlineusersPK gameinstanseonlineusersPK) {
        this.gameinstanseonlineusersPK = gameinstanseonlineusersPK;
    }

    public Gameinstanseonlineusers(int gameInstanceId, int userId) {
        this.gameinstanseonlineusersPK = new GameinstanseonlineusersPK(gameInstanceId, userId);
    }

    public GameinstanseonlineusersPK getGameinstanseonlineusersPK() {
        return gameinstanseonlineusersPK;
    }

    public void setGameinstanseonlineusersPK(GameinstanseonlineusersPK gameinstanseonlineusersPK) {
        this.gameinstanseonlineusersPK = gameinstanseonlineusersPK;
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

    public Gameinstance getGameinstance() {
        return gameinstance;
    }

    public void setGameinstance(Gameinstance gameinstance) {
        this.gameinstance = gameinstance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameinstanseonlineusersPK != null ? gameinstanseonlineusersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gameinstanseonlineusers)) {
            return false;
        }
        Gameinstanseonlineusers other = (Gameinstanseonlineusers) object;
        if ((this.gameinstanseonlineusersPK == null && other.gameinstanseonlineusersPK != null) || (this.gameinstanseonlineusersPK != null && !this.gameinstanseonlineusersPK.equals(other.gameinstanseonlineusersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OnlineGame.Gameinstanseonlineusers[ gameinstanseonlineusersPK=" + gameinstanseonlineusersPK + " ]";
    }
    
}

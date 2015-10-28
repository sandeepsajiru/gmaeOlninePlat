/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AKA
 */
@Entity
@Table(name = "gameinstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gameinstance.findAll", query = "SELECT g FROM Gameinstance g"),
    @NamedQuery(name = "Gameinstance.findByGameInstanceId", query = "SELECT g FROM Gameinstance g WHERE g.gameinstancePK.gameInstanceId = :gameInstanceId"),
    @NamedQuery(name = "Gameinstance.findByStatus", query = "SELECT g FROM Gameinstance g WHERE g.status = :status"),
    @NamedQuery(name = "Gameinstance.findByStartTime", query = "SELECT g FROM Gameinstance g WHERE g.startTime = :startTime"),
    @NamedQuery(name = "Gameinstance.findByEndTime", query = "SELECT g FROM Gameinstance g WHERE g.endTime = :endTime"),
    @NamedQuery(name = "Gameinstance.findByInitiatingUser", query = "SELECT g FROM Gameinstance g WHERE g.gameinstancePK.initiatingUser = :initiatingUser")})
public class Gameinstance implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GameinstancePK gameinstancePK;
    @Column(name = "Status")
    private String status;
    @Column(name = "StartTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "EndTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameinstance")
    private Collection<Gameinstanseonlineusers> gameinstanseonlineusersCollection;
    @JoinColumn(name = "GameId", referencedColumnName = "GameId")
    @ManyToOne(optional = false)
    private Game gameId;
    @JoinColumn(name = "InitiatingUser", referencedColumnName = "UserId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Gameinstance() {
    }

    public Gameinstance(GameinstancePK gameinstancePK) {
        this.gameinstancePK = gameinstancePK;
    }

    public Gameinstance(int gameInstanceId, int initiatingUser) {
        this.gameinstancePK = new GameinstancePK(gameInstanceId, initiatingUser);
    }

    public GameinstancePK getGameinstancePK() {
        return gameinstancePK;
    }

    public void setGameinstancePK(GameinstancePK gameinstancePK) {
        this.gameinstancePK = gameinstancePK;
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

    @XmlTransient
    public Collection<Gameinstanseonlineusers> getGameinstanseonlineusersCollection() {
        return gameinstanseonlineusersCollection;
    }

    public void setGameinstanseonlineusersCollection(Collection<Gameinstanseonlineusers> gameinstanseonlineusersCollection) {
        this.gameinstanseonlineusersCollection = gameinstanseonlineusersCollection;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
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
        hash += (gameinstancePK != null ? gameinstancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gameinstance)) {
            return false;
        }
        Gameinstance other = (Gameinstance) object;
        if ((this.gameinstancePK == null && other.gameinstancePK != null) || (this.gameinstancePK != null && !this.gameinstancePK.equals(other.gameinstancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OnlineGame.Gameinstance[ gameinstancePK=" + gameinstancePK + " ]";
    }
    
}

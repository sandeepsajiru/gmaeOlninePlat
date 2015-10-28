/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author AKA
 */
@Embeddable
public class GameinstancePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "GameInstanceId")
    private int gameInstanceId;
    @Basic(optional = false)
    @Column(name = "InitiatingUser")
    private int initiatingUser;

    public GameinstancePK() {
    }

    public GameinstancePK(int gameInstanceId, int initiatingUser) {
        this.gameInstanceId = gameInstanceId;
        this.initiatingUser = initiatingUser;
    }

    public int getGameInstanceId() {
        return gameInstanceId;
    }

    public void setGameInstanceId(int gameInstanceId) {
        this.gameInstanceId = gameInstanceId;
    }

    public int getInitiatingUser() {
        return initiatingUser;
    }

    public void setInitiatingUser(int initiatingUser) {
        this.initiatingUser = initiatingUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gameInstanceId;
        hash += (int) initiatingUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameinstancePK)) {
            return false;
        }
        GameinstancePK other = (GameinstancePK) object;
        if (this.gameInstanceId != other.gameInstanceId) {
            return false;
        }
        if (this.initiatingUser != other.initiatingUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OnlineGame.GameinstancePK[ gameInstanceId=" + gameInstanceId + ", initiatingUser=" + initiatingUser + " ]";
    }
    
}

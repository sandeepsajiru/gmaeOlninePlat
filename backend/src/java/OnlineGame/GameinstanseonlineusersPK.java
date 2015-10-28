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
public class GameinstanseonlineusersPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "GameInstanceId")
    private int gameInstanceId;
    @Basic(optional = false)
    @Column(name = "UserId")
    private int userId;

    public GameinstanseonlineusersPK() {
    }

    public GameinstanseonlineusersPK(int gameInstanceId, int userId) {
        this.gameInstanceId = gameInstanceId;
        this.userId = userId;
    }

    public int getGameInstanceId() {
        return gameInstanceId;
    }

    public void setGameInstanceId(int gameInstanceId) {
        this.gameInstanceId = gameInstanceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gameInstanceId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameinstanseonlineusersPK)) {
            return false;
        }
        GameinstanseonlineusersPK other = (GameinstanseonlineusersPK) object;
        if (this.gameInstanceId != other.gameInstanceId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OnlineGame.GameinstanseonlineusersPK[ gameInstanceId=" + gameInstanceId + ", userId=" + userId + " ]";
    }
    
}

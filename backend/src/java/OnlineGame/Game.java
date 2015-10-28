/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AKA
 */
@Entity
@Table(name = "game")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findByGameId", query = "SELECT g FROM Game g WHERE g.gameId = :gameId"),
    @NamedQuery(name = "Game.findByName", query = "SELECT g FROM Game g WHERE g.name = :name"),
    @NamedQuery(name = "Game.findByDesc", query = "SELECT g FROM Game g WHERE g.desc = :desc"),
    @NamedQuery(name = "Game.findByHelp", query = "SELECT g FROM Game g WHERE g.help = :help"),
    @NamedQuery(name = "Game.findByMinUsers", query = "SELECT g FROM Game g WHERE g.minUsers = :minUsers"),
    @NamedQuery(name = "Game.findByMaxUsers", query = "SELECT g FROM Game g WHERE g.maxUsers = :maxUsers"),
    @NamedQuery(name = "Game.findByImgPath", query = "SELECT g FROM Game g WHERE g.imgPath = :imgPath")})
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GameId")
    private Integer gameId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Desc")
    private String desc;
    @Column(name = "Help")
    private String help;
    @Column(name = "MinUsers")
    private Integer minUsers;
    @Column(name = "MaxUsers")
    private Integer maxUsers;
    @Column(name = "ImgPath")
    private String imgPath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameId")
    private Collection<Gameinstance> gameinstanceCollection;

    public Game() {
    }

    public Game(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Integer getMinUsers() {
        return minUsers;
    }

    public void setMinUsers(Integer minUsers) {
        this.minUsers = minUsers;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @XmlTransient
    public Collection<Gameinstance> getGameinstanceCollection() {
        return gameinstanceCollection;
    }

    public void setGameinstanceCollection(Collection<Gameinstance> gameinstanceCollection) {
        this.gameinstanceCollection = gameinstanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameId != null ? gameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.gameId == null && other.gameId != null) || (this.gameId != null && !this.gameId.equals(other.gameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OnlineGame.Game[ gameId=" + gameId + " ]";
    }
    
}

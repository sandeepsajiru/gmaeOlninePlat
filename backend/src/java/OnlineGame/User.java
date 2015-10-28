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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByNickname", query = "SELECT u FROM User u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "User.findByAvatarImgPath", query = "SELECT u FROM User u WHERE u.avatarImgPath = :avatarImgPath"),
    @NamedQuery(name = "User.findByOnlineStatus", query = "SELECT u FROM User u WHERE u.onlineStatus = :onlineStatus")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "Nickname")
    private String nickname;
    @Column(name = "AvatarImgPath")
    private String avatarImgPath;
    @Column(name = "OnlineStatus")
    private Integer onlineStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Gameinstanseonlineusers> gameinstanseonlineusersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Gameinstance> gameinstanceCollection;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarImgPath() {
        return avatarImgPath;
    }

    public void setAvatarImgPath(String avatarImgPath) {
        this.avatarImgPath = avatarImgPath;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @XmlTransient
    public Collection<Gameinstanseonlineusers> getGameinstanseonlineusersCollection() {
        return gameinstanseonlineusersCollection;
    }

    public void setGameinstanseonlineusersCollection(Collection<Gameinstanseonlineusers> gameinstanseonlineusersCollection) {
        this.gameinstanseonlineusersCollection = gameinstanseonlineusersCollection;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OnlineGame.User[ userId=" + userId + " ]";
    }
    
}

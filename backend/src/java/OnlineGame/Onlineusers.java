/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineGame;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AKA
 */
@Entity
@Table(name = "onlineusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlineusers.findAll", query = "SELECT o FROM Onlineusers o"),
    @NamedQuery(name = "Onlineusers.findByUserId", query = "SELECT o FROM Onlineusers o WHERE o.userId = :userId"),
    @NamedQuery(name = "Onlineusers.findByName", query = "SELECT o FROM Onlineusers o WHERE o.name = :name"),
    @NamedQuery(name = "Onlineusers.findByNickname", query = "SELECT o FROM Onlineusers o WHERE o.nickname = :nickname"),
    @NamedQuery(name = "Onlineusers.findByAvatarImgPath", query = "SELECT o FROM Onlineusers o WHERE o.avatarImgPath = :avatarImgPath")})
public class Onlineusers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "UserId")
    private int userId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Nickname")
    private String nickname;
    @Column(name = "AvatarImgPath")
    private String avatarImgPath;

    public Onlineusers() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
}

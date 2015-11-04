package onlinegaming.dblayer;

public class User {

    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String nickname;
    private String avatarImgPath;
    private Integer onlineStatus;
    
    public User() {
    }

    public User(Integer userId, String name, String email, String password, String nickname, String avatarImgPath, Integer onlineStatus) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.avatarImgPath = avatarImgPath;
        this.onlineStatus = onlineStatus;
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

}

/**
 *
 * @author sandy
 */
/*public class User {

 Integer id;
 String name;
 String email;
 String pwd;
 String nickName;
 String avatarImagePath;
 Integer isOnline;

 public User(Integer id, String name, String email, String pwd, String nickName, String avatarImagePath, Integer isOnline) {
 this.id = id;
 this.name = name;
 this.email = email;
 this.pwd = pwd;
 this.nickName = nickName;
 this.avatarImagePath = avatarImagePath;
 this.isOnline = isOnline;
 }
    
 }*/

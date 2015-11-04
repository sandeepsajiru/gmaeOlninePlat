package onlinegaming.dblayer;

public class Game {

    private Integer gameId;
    private String name;
    private String desc;
    private String help;
    private Integer minUsers;
    private Integer maxUsers;
    private String imgPath;

    public Game() {
    }

    public Game(Integer gameId, String name, String desc, String help, Integer minUsers, Integer maxUsers, String imgPath) {
        this.gameId = gameId;
        this.name = name;
        this.desc = desc;
        this.help = help;
        this.minUsers = minUsers;
        this.maxUsers = maxUsers;
        this.imgPath = imgPath;
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

}

package onlinegaming.dblayer;

import java.util.HashMap;
import java.util.List;
import onlinegaming.dblayer.*;

public interface IOnlineGameDBLayer {

    boolean isUserValid(String userEmail, String pwd);

    boolean isAlreadyRegistered(String userEmail);

    boolean registerUser(String name, String email, String pwd, String nickName, String avatarImagePath, Integer isOnline);

    boolean isUserOnline(String userEmail);

    void setUserOnline(Integer isOnline, String userEmail);

    User getUser(Integer id);

    public List<User> getAllUsers();

    public List<Game> getAllGames();

    public Game getGame(int id);

}

package prim.hugescrub.staxparsing;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getByCountry(String country) {
        List<User> russianUsers = new ArrayList<>();
        for(User user: users){
            if(user.getCountry().equals(country)){
                russianUsers.add(user);
            }
        }
        return russianUsers;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}

package mng.main.lambda.removeif;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {

    List<UserRemoveIfEntity> users = new ArrayList<UserRemoveIfEntity>();

    public RemoveIf() {
        this.users.add(UserRemoveIfEntity.createRandomActive());
        this.users.add(UserRemoveIfEntity.createRandomActive());
        this.users.add(UserRemoveIfEntity.createRandomInactive());
        this.users.add(UserRemoveIfEntity.createRandomInactive());
        this.users.add(UserRemoveIfEntity.createRandomActive());
        this.users.add(UserRemoveIfEntity.createRandomActive());
        this.users.add(UserRemoveIfEntity.createRandomInactive());
        this.users.add(UserRemoveIfEntity.createRandomActive());
        this.users.add(UserRemoveIfEntity.createRandomInactive());
        this.users.add(UserRemoveIfEntity.createRandomInactive());

    }

    public List<UserRemoveIfEntity> allUsers() {
        return this.users;
    }

    public List<UserRemoveIfEntity> activeUsers() {
        List<UserRemoveIfEntity> _users = new ArrayList(this.users);
        _users.removeIf(u -> !u.flagActive);
        return _users;
    }

    public List<UserRemoveIfEntity> inactiveUsers() {
        List<UserRemoveIfEntity> _users = new ArrayList(this.users);
        _users.removeIf(u -> u.flagActive);
        return _users;
    }


    public String describe(List<UserRemoveIfEntity> usersParam) {
        StringBuffer sb = new StringBuffer();

        for (UserRemoveIfEntity user : usersParam) {
            sb.append("> ").append(user.describe()).append("\n");
        }

        return sb.toString();
    }


}

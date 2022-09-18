package mng.main.lambda.removeif;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class CompareSort {

    List<UserRemoveIfEntity> users = new ArrayList<UserRemoveIfEntity>();

    public CompareSort() {

        this.users.add(new UserRemoveIfEntity("7", "MarcioMangar@mangar.com.br", "", Boolean.TRUE));
        this.users.add(new UserRemoveIfEntity("4", "rafael@mangar.com.br", "", Boolean.TRUE));
        this.users.add(new UserRemoveIfEntity("1", "m@mangar.com.br", "", Boolean.TRUE));
        this.users.add(new UserRemoveIfEntity("8", "Marciomangar@mangar.com.br", "", Boolean.TRUE));
        this.users.add(new UserRemoveIfEntity("6", "alexandre@mangar.com.br", "", Boolean.TRUE));
        this.users.add(new UserRemoveIfEntity("3", "marcio@mangar.com.br", "", Boolean.TRUE));
        this.users.add(new UserRemoveIfEntity("5", "thomaz@mangar.com.br", "", Boolean.TRUE));
        this.users.add(new UserRemoveIfEntity("2", "a@mangar.com.br", "", Boolean.TRUE));




    }

    public List<UserRemoveIfEntity> allUsers() {
        return this.users;
    }


    public List<UserRemoveIfEntity> orderById() {
        List<UserRemoveIfEntity> _users = new ArrayList(this.users);

        // 1.
        Comparator<UserRemoveIfEntity> comparator = comparing(u -> u.id);
        _users.sort(comparator);

        // 2.
        _users.sort(comparing(u -> u.id));

        return _users;
    }

    public List<UserRemoveIfEntity> orderByEmail() {
        List<UserRemoveIfEntity> _users = new ArrayList(this.users);
        _users.sort((u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(u1.email, u2.email));
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

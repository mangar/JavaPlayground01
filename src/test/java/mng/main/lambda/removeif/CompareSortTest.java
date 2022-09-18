package mng.main.lambda.removeif;

import org.junit.jupiter.api.Test;

import java.awt.desktop.UserSessionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareSortTest {

    @Test
    void orderByEmail() {
        CompareSort compareSort = new CompareSort();

        System.out.println("--- All");
        System.out.println(compareSort.describe(compareSort.users));


        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        System.out.println("--- Order By Email");
        System.out.println(compareSort.describe(compareSort.orderByEmail()));
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<

        // List<UserRemoveIfEntity> _users = new ArrayList(this.users);
        // _users.sort((u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(u1.email, u2.email));


    }


    @Test
    void orderById() {
        CompareSort compareSort = new CompareSort();

        System.out.println("--- All");
        System.out.println(compareSort.describe(compareSort.users));


        System.out.println("--- Order By ID");
        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        System.out.println(compareSort.describe(compareSort.orderById()));
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<
    }


    @Test
    void sortReverse() {
        CompareSort compareSort = new CompareSort();
        List<UserRemoveIfEntity> users = compareSort.allUsers();

        System.out.println("--- All");
        System.out.println(compareSort.describe(compareSort.users));


        System.out.println("--- REVERSE byId");
        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        users.sort(Comparator.comparing(UserRemoveIfEntity::getId).reversed());
        System.out.println(compareSort.describe(users));
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<

    }


    @Test
    void sortByIdThenEmail() {
        CompareSort compareSort = new CompareSort();
        List<UserRemoveIfEntity> users = compareSort.allUsers();

        System.out.println("--- All");
        System.out.println(compareSort.describe(compareSort.users));

        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        System.out.println("--- byEmail THEN byId");
        users.sort(Comparator.comparing(UserRemoveIfEntity::getEmail2)
                .thenComparing(UserRemoveIfEntity::getId));
        System.out.println(compareSort.describe(users));
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<

    }


}
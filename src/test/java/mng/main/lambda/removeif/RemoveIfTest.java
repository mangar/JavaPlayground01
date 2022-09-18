package mng.main.lambda.removeif;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveIfTest {

    @Test
    void allUsers() {
        RemoveIf removeIf = new RemoveIf();
        assertEquals(10, removeIf.users.size());

        System.out.println("--- All");
        System.out.println(removeIf.describe(removeIf.users));


        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        System.out.println("--- Active");
        System.out.println(removeIf.describe(removeIf.activeUsers()));
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<


        System.out.println("--- INActive");
        System.out.println(removeIf.describe(removeIf.inactiveUsers()));
    }



    @Test
    void allActivate() {
        RemoveIf removeIf = new RemoveIf();
        assertEquals(10, removeIf.users.size());

        System.out.println("--- All");
        System.out.println(removeIf.describe(removeIf.users));


        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        // >>>>>>>>>>>>>>>>>>>
        System.out.println("--- All Active [setActive]");
        removeIf.users.forEach(UserRemoveIfEntity::setActive);
        System.out.println(removeIf.describe(removeIf.activeUsers()));
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<
        // <<<<<<<<<<<<<<<<<<<



        System.out.println("--- All x2");
        System.out.println(removeIf.describe(removeIf.users));

    }


}
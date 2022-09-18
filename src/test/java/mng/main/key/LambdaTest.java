package mng.main.key;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LambdaTest {


    @Test
    void testGetKey_LambdaUsage() {
        List<String> keys = Arrays.asList("marcio@mangar.com.br", "marcio.mangar@gmail.com", "mmangar@avantstay.com");
        Map<String, String> keysRet = KeyGenerator.getInstance().getKey(keys);


        System.out.println("Lambda Usage");
        keysRet.keySet().forEach(s -> System.out.println(">> " + keysRet.get(s) + " (" + s + ")"));
        System.out.println("---");


        assertTrue(true);

    }



    @Test
    void testGetKey_Lambda2Usage() {

        Runnable r = () -> {
            System.out.println("Runnable....");
        };



    }


}
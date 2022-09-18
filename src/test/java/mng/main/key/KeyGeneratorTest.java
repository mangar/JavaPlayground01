package mng.main.key;

import org.eclipse.jetty.util.StringUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class KeyGeneratorTest {

    @Test
    void getKey() {
        final String key01 = KeyGenerator.getInstance().getKey("marcio.mangar@gmail.com");
        assertEquals("76e486e6662acf2007981e3b77af0dd43ba748e87b2a34c8d2cc359d4f5c724a", key01);

    }

    @Test
    void testGetKey() {
        List<String> keys = Arrays.asList("marcio@mangar.com.br", "marcio.mangar@gmail.com", "mmangar@avantstay.com");

        Map<String, String> keysRet = KeyGenerator.getInstance().getKey(keys);

        System.out.println("---");
        System.out.println(KeyGenerator.getInstance().describe(keysRet));
        System.out.println("---");

        assertEquals(3, keysRet.keySet().size());
        assert (StringUtil.isNotBlank(keysRet.get("marcio.mangar@gmail.com")));
        assert (StringUtil.isBlank(keysRet.get("key_not_found")));


        keysRet.keySet().forEach(s -> System.out.println(">> " + keysRet.get(s)));


        KeyGenerator.getInstance().describeToFile(KeyGenerator.getInstance().getKey(keys));


    }

}
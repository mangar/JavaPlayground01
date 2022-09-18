package mng.main.key;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyGenerator {

    public static final String SHA256 = "SHA56";
    private String selectedAlgoKey = KeyGenerator.SHA256;


    private static KeyGenerator instance = new KeyGenerator();

    private KeyGenerator() {
        this.selectedAlgoKey = KeyGenerator.SHA256;
    }

    public static KeyGenerator getInstance() {
        return KeyGenerator.instance;
    }


    public String getKey(final String content) {
        return DigestUtils.sha256Hex(content);
    }

    public Map<String, String> getKey(final List<String> content) {
        Map<String, String> ret = new HashMap<String, String>();
        for (String c: content) {
            ret.put(c, getKey(c));
        }
        return ret;
    }



    /**
     * @param content
     * @return
     */
    public String describe(Map<String, String> content) {
        StringBuffer sbRet = new StringBuffer();
        for(String k: content.keySet()) {
            sbRet.append(k).append(" : ").append(content.get(k)).append("\n");
        }
        return sbRet.toString();
    }


    public String describeToFile(Map<String, String> content) {
        String output = describe(content);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./_output/KeyGenerator.txt"));
            writer.write( output );
            writer.close();
        } catch (IOException ioe) {
            output = "Exception: " + ioe.toString();
        }
        return output;
    }


}

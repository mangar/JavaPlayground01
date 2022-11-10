package mng.main.scraper.wms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    public static final boolean DEBUG = true;

    public static final String BASE_OUTPUT_DIR = "./_output/wm/";

    public static void log (final String content) throws IOException {
        String filePathAndName = BASE_OUTPUT_DIR + "log.txt";
        Path path = Paths.get(filePathAndName);
        File f = new File(filePathAndName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date()).toString();

        StringBuffer newContent = new StringBuffer()
                .append("[").append(dateTime).append("]")
                .append(content);

        //---
        System.out.println(newContent);

        newContent.append(System.lineSeparator());

        if(!f.exists()) {
            Files.write(path, newContent.toString().getBytes(), StandardOpenOption.CREATE);
        } else {
            Files.write(path, newContent.toString().getBytes(), StandardOpenOption.APPEND);
        }
    }


    public static void logDebug (final String content) {

        if (DEBUG) {

            String filePathAndName = BASE_OUTPUT_DIR + "log.txt";
            Path path = Paths.get(filePathAndName);
            File f = new File(filePathAndName);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = dateFormat.format(new Date()).toString();

            StringBuffer newContent = new StringBuffer()
                    .append("[").append(dateTime).append("][DEBUG]")
                    .append(content);

            //---
            System.out.println(newContent);

            newContent.append(System.lineSeparator());

            try {
                if (!f.exists()) {
                    Files.write(path, newContent.toString().getBytes(), StandardOpenOption.CREATE);
                } else {
                    Files.write(path, newContent.toString().getBytes(), StandardOpenOption.APPEND);
                }
            } catch (Exception e) {
                System.out.println("!! ERROR!! " + e.toString());
            }
        }
    }


}

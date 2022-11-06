package mng.main.scraper.webmotors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Log {

    public static final String BASE_OUTPUT_DIR = "./_output/webmotors/";

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



}

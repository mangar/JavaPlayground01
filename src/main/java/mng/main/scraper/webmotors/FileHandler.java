package mng.main.scraper.webmotors;

import mng.main.scraper.webmotors.json.WMCarro;

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

public class FileHandler {

    public static final String BASE_OUTPUT_DIR = "./_output/webmotors/";
    public static final String BASE_INPUT_DIR = "./_input/webmotors/";

    public static List<CarroEntity> getCarros() throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get(BASE_INPUT_DIR + "carros.txt"));
        List<CarroEntity> allLinesClean = new ArrayList<CarroEntity>();

        for (String line : allLines) {
            if (!line.startsWith("#") && !line.isBlank()) {
                List<String> lineArray = Arrays.asList(line.trim().split(","));
                allLinesClean.add(CarroEntity.newCarro(lineArray.get(0), lineArray.get(1)));
            }
        }

        return allLinesClean;
    }


    public static void saveResponseToFile(final CarroEntity carro, final String response) throws IOException {
        String filePathAndName = BASE_OUTPUT_DIR + carro.getID() + "_content.json";
        Path path = Paths.get(filePathAndName);
        File f = new File(filePathAndName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date()).toString();

        StringBuffer newContent = new StringBuffer()
                .append(dateTime).append(",")
                .append(response)
                .append(System.lineSeparator());

        if (!f.exists()) {
            Files.write(path, newContent.toString().getBytes(), StandardOpenOption.CREATE);
        } else {
            Files.write(path, newContent.toString().getBytes(), StandardOpenOption.APPEND);
        }
    }


    public static void registerScrapping(final CarroEntity carro, final WMCarro wmCarro) throws IOException {
        String filePathAndName = BASE_OUTPUT_DIR + carro.getID() + ".csv";
        Path path = Paths.get(filePathAndName);
        File f = new File(filePathAndName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date()).toString();

        StringBuffer newContent = new StringBuffer()
                .append(dateTime).append(",")
                .append(wmCarro.toCSV())
                .append(System.lineSeparator());

        String header = "Data,WMID,Título,Data Criação,Data Publicação,Preço,Preço FIPE,Variação FIPE" + System.lineSeparator();

        if (!f.exists()) {
            Files.write(path, header.getBytes(), StandardOpenOption.CREATE);
        }

        Files.write(path, newContent.toString().getBytes(), StandardOpenOption.APPEND);

    }


    public static void registerScrapping(final WMCarro wmCarro) throws IOException {
        String filePathAndName = BASE_OUTPUT_DIR + "webmotors.csv";
        Path path = Paths.get(filePathAndName);
        File f = new File(filePathAndName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date()).toString();

        StringBuffer newContent = new StringBuffer()
                .append(dateTime).append(",")
                .append(wmCarro.toCSV())
                .append(System.lineSeparator());

        String header = "Data,WMID,Título,Data Criação,Data Publicação,Preço,Preço FIPE,Variação FIPE" + System.lineSeparator();

        if (!f.exists()) {
            Files.write(path, header.getBytes(), StandardOpenOption.CREATE);
        }

        Files.write(path, newContent.toString().getBytes(), StandardOpenOption.APPEND);

    }


}

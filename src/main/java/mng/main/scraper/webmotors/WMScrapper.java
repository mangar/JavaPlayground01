package mng.main.scraper.webmotors;

import mng.main.scraper.webmotors.json.WMCarro;
import mng.main.scraper.webmotors.json.WMCarroBuilder;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;

import java.io.IOException;
import java.util.Random;

public class WMScrapper {

    public static void main(String... args) throws Exception {

        Log.log(">>>>>>>>>> Web Scrapping Starts");

        for (CarroEntity carro : FileHandler.getCarros()) {

            Log.log("[" + carro.getID() + "]");

            try {

                Log.log("1. Getting content");
                String contentJson = new WMScrapper().getContent(carro.getURL());

                sleep();

                Log.log("2. Saving content locally");
                FileHandler.saveResponseToFile(carro, contentJson);

                Log.log("3. Building JSON Object");
                WMCarro wmCarro = WMCarroBuilder.build(contentJson);

                Log.log("4. Registering scrapping");
                FileHandler.registerScrapping(carro, wmCarro);
                FileHandler.registerScrapping(wmCarro);



                System.out.println("[wmCarro]: " + wmCarro);

            } catch (Exception e) {
                Log.log(carro.getID() + " ERRO: " + e.toString());
            }

        }

        Log.log("<<<<<<<<<< Web Scrapping Finished");
    }

    private String getContent(final String URL) throws IOException {
        String content = "";
        try {
            final HttpClient client = new HttpClient();
            client.start();
            client.setUserAgentField(new HttpField(HttpHeader.USER_AGENT, HttpHandler.getRandomUserAgent()));


            final ContentResponse res = client.GET(URL);

            content = res.getContentAsString();
            System.out.println(content);

            client.stop();
        } catch (Exception e) {
            Log.log("ERROR: " + e.getMessage());
        }

        return content;
    }

    private static void sleep() throws IOException, InterruptedException {
//        Random r = new Random();
//        int low = 1;
//        int high = 5;
//        int result = (r.nextInt(high-low) + low) * 1000;
//
//        Log.logDebug(" sleep:" + result);
//
//        Thread.sleep(result);
    }


}

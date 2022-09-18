package mng.main.scraper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceScraperTest {


    @Test
    void scrapeIt() {
        final String priceVale3 = PriceScraper.scrapeIt("VALE3");
        assertEquals(priceVale3, "10,10");

    }
}
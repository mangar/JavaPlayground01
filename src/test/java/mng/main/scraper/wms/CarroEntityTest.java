package mng.main.scraper.wms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarroEntityTest {

    @Test
    void getURL() {
        final String URL = "https://www.webmotors.com.br/comprar/chevrolet/onix/14-mpfi-lt-8v-flex-4p-automatico/4-portas/2017-2018/43923175?pos=t43923175g:&np=5";
        CarroEntity carro = CarroEntity.newCarro("idDoCarro", URL);
        assertEquals("https://www.webmotors.com.br/api/detail/car/chevrolet/onix/14-mpfi-lt-8v-flex-4p-automatico/4-portas/2017-2018/43923175", carro.getURL());
    }

    @Test
    void getURL_API() {
        final String URL = "https://www.webmotors.com.br/api/detail/car/honda/fit/15-lx-16v-flex-4p-automatico/4-portas/2017-2018/44121339";
        CarroEntity carro = CarroEntity.newCarro("idDoCarro", URL);
        assertEquals(URL, carro.getURL());
    }


}
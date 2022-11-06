package mng.main.scraper.webmotors;

public class CarroEntity {

    private String ID;
    private String URL;

    public static CarroEntity newCarro(final String id, final String url) {
        CarroEntity carro = new CarroEntity();
        carro.setID(id);
        carro.setURL(url);
        return carro;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}

package mng.main.scraper.wms;

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

        String newUrl = this.URL.replace("comprar", "api/detail/car");

        int pos = newUrl.indexOf("?");
        if (pos > 0) {
            newUrl = newUrl.substring(0, pos);
        }


        return newUrl;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}

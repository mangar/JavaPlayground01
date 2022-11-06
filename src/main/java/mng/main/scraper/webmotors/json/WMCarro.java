package mng.main.scraper.webmotors.json;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WMCarro {

    private String uniqueId;
    private String price;
    private String priceFIPE;
    private String fipePercent;
    private String datePublished;
    private String createdDate;
    private String title;

    @Override
    public String toString() {
        return "WMCarro{" +
                "uniqueId='" + uniqueId + '\'' +
                ", price='" + price + '\'' +
                ", priceFIPE='" + priceFIPE + '\'' +
                ", fipePercent='" + fipePercent + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String toCSV() {
        return this.uniqueId + "," +
                this.title + "," +
                this.createdDate + "," +
                this.datePublished + "," +
                this.price + "," +
                this.priceFIPE + "," +
                this.fipePercent;
    }



    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceFIPE() {
        return priceFIPE;
    }

    public void setPriceFIPE(String priceFIPE) {
        this.priceFIPE = priceFIPE;
    }

    public String getFipePercent() {
        return fipePercent;
    }

    public void setFipePercent(String fipePercent) {
        this.fipePercent = fipePercent;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

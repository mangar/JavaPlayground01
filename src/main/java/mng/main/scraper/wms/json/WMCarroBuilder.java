package mng.main.scraper.wms.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WMCarroBuilder {

    public static WMCarro build(final String contentJson) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(contentJson);

        WMCarro wmCarro = new WMCarro();
        wmCarro.setUniqueId(json.get("UniqueId").toString());
        wmCarro.setFipePercent(json.get("FipePercent").toString());
        wmCarro.setCreatedDate(json.get("CreatedDate").toString());

        JSONObject jsonPrices = (JSONObject) json.get("Prices");
        wmCarro.setPrice( jsonPrices.get("Price").toString() );

        JSONObject jsonSpecification = (JSONObject) json.get("Specification");
        wmCarro.setDatePublished( jsonSpecification.get("DatePublished").toString() );
        wmCarro.setTitle( jsonSpecification.get("Title").toString() );

        JSONObject jsonEvaluation = (JSONObject) jsonSpecification.get("Evaluation");
        wmCarro.setPriceFIPE(jsonEvaluation.get("FIPE").toString());

        return wmCarro;
    }


}

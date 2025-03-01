import org.json.JSONObject;
import org.json.XML;

public class XMLToJSONAdapter {
    public static String convert(String xmlData) {
        JSONObject json = XML.toJSONObject(xmlData);
        return json.toString(4);

        {
            public static String convert(String xmlData) {
                xmlData = xmlData.replace("<?xml version=\"1.0\"?>", "");
                xmlData = xmlData.replace("<data>", "{");
                xmlData = xmlData.replace("</data>", "}");
                xmlData = xmlData.replaceAll("<([a-zA-Z0-9]+)>\\s*", "\"$1\":\"");
                xmlData = xmlData.replaceAll("\\s*</([a-zA-Z0-9]+)>", "\" ,");
                xmlData = xmlData.replaceAll(",\s*}", "}");
                return xmlData;
            }
        }
    }
}
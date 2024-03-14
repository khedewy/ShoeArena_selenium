package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckoutData {
    public  String  firstName, lastName, mobile,address, city, landmark, postcode ;

    public void checkoutData() throws IOException, ParseException {

        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/checkoutData.json";
        File file = new File(srcFile);

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));

        for (Object object : jsonArray ){
            JSONObject person = (JSONObject) object;
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            mobile = (String) person.get("mobile");
            address = (String) person.get("address");
            city = (String) person.get("city");
            landmark = (String) person.get("landmark");
            postcode = (String) person.get("postcode");


        }
    }
}

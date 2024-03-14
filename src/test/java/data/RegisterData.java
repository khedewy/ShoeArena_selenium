package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RegisterData {
    public  String  email, password,country,firstName,lastName ;

    public void registerData() throws IOException, ParseException {

        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/registerData.json";
        File file = new File(srcFile);

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));

        for (Object object : jsonArray ){
            JSONObject person = (JSONObject) object;
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            email = (String) person.get("email");
            password = (String) person.get("password");
        }

    }
}

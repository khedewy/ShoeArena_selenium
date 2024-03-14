package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContactUsData {
    public  String  mobile, subject,message ;

    public void contactUsData() throws IOException, ParseException {

        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/contactUsData.json";
        File file = new File(srcFile);

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));

        for (Object object : jsonArray ){
            JSONObject person = (JSONObject) object;
            mobile = (String) person.get("mobile");
            subject = (String) person.get("subject");
            message = (String) person.get("message");

        }
}}

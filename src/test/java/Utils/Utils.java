package Utils;

import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class Utils {
    static RequestSpecification req;


    public RequestSpecification RequestSpecification() throws IOException {

        String baseURI = getGlobalProperties("baseURI");

        if (req == null) {
            PrintStream ps = new PrintStream(new FileOutputStream("logging.txt"));

            req = new RequestSpecBuilder().setBaseUri(baseURI)
                    .addFilter(RequestLoggingFilter.logRequestTo(ps))
                    .addFilter(ResponseLoggingFilter.logResponseTo(ps))
                    .setContentType(ContentType.JSON).build();
        }
        return req;
    }
    public static String getGlobalProperties(String key) throws IOException {
        File propFile = new File("src/test/resources/app.Properties");
        FileInputStream stream = new FileInputStream(propFile);
        Properties prop = new Properties();
        prop.load(stream);
        return prop.get(key).toString();
    }

    public String getResponseObjectKeyValue(Response response, String key ){

        String responseString = response.asString();
        JsonPath js = new JsonPath(responseString);
        return js.get(key).toString();
    }

    public JSONObject getResponseAsJSONObject(Response response) throws JSONException {
        String responseString = response.asString();
        return new JSONObject(responseString);
    }


}

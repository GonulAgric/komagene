package baseurl;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.ReusableMethods.smsKod;


public class KomageneBaseUrl {

    public static RequestSpecification spec;

    public static void setUp() {
        spec = new RequestSpecBuilder()
                .addHeader("Body", ReusableMethods.smsKod())
                .setBaseUri("http://display.supergrup.com")
                .setContentType(ContentType.JSON)
                .build();


    }
}
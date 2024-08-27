package post;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;

public class putstyle {

    @Test
     void bddstyle()	{

      /*  String payload1 = "{\n" +
                "    \"firstname\" : \"Ishita1\",\n" +
                "    \"lastname\" : \"Baxi\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
*/

        HashMap<String, Object> payload1 = new HashMap<>();
        payload1.put("firstname","Ishita");
        payload1.put("lastname","Baxi");
        payload1.put("totalprice",111);


        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.given()
            .header("Content-type","application/json")
            .baseUri("https://restful-booker.herokuapp.com")
            .basePath("/booking/1508")
            .cookie("token","330972c1b4ee483")
            .body(payload1)
            .when().put()
            .then().log().all()
            .body("firstname",Matchers.equalTo("Ishita1"));



    }

}

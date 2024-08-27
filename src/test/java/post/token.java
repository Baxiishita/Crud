package post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class token {


   @Test
    public void tokenMethod ()
    {
      /*  String token ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";*/


        tokenClass tokenclass = new tokenClass();
        tokenclass.setUsername("admin");
        tokenclass.setPassword("password123");
        tokenclass.getUsername();
        tokenclass.getPassword();

        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
            .basePath("/auth")
            .contentType(ContentType.JSON)
            .body(tokenclass)
            .when().post()
            .then().log().all().statusCode(200)
            .body("token.length()", Matchers.is(15));
    }
}

package post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class getstyle {


    @Test
    void getMethod()
    {

        RestAssured.given().header("Content-type","application/json")
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/402")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().all();
    }

}

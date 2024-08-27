package post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class delete {

    @Test
    void delete()
    {

        RestAssured.given().header("Content-type","application/json")
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1323")
                .cookie("token","dc9f06f393db6e2")
                .contentType(ContentType.JSON)
                .when().delete()
                .then().log().all();
    }


}

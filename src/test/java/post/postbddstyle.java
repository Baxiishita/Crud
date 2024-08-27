package post;
import com.google.gson.Gson;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class postbddstyle {

    @Test
    void bddstyle() {
       /* String payload = "{\n" +
                "    \"firstname\" : \"Ishita\",\n" +
                "    \"lastname\" : \"baxi\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";*/
//using HashMap
 /*  HashMap<String, Object> payload = new HashMap<>();
        payload.put("firstname","Ishita");
        payload.put("lastname","baxi");
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("additionalneeds","Breakfast");

        System.out.println(payload);

        HashMap<String,String> bookingDates = new HashMap<>();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");
        payload.put("bookingdates",bookingDates);

        System.out.println(bookingDates);

        //if more than one payload have in a query then Array list using.
        ArrayList<Map<String,Object>> mylist = new ArrayList<Map<String, Object>>();
        mylist.add(payload);


*/
    Employee employee = new Employee();
    Bookingdatesclass bookingdatesclass = new Bookingdatesclass();

        employee.setFirstname("Ishita");
        employee.setLastname("baxi");
        employee.setTotalprice(111);
        employee.setDepositpaid(true);
        employee.setAdditionalneeds("Breakfast");
        bookingdatesclass.setCheckin("2018-01-01");
        bookingdatesclass.setCheckout("2019-01-01");
        employee.setBookingdates(bookingdatesclass);

        System.out.println(employee.getFirstname());
        System.out.println(employee.getLastname());
        System.out.println(employee.getTotalprice());
        System.out.println(employee.getDepositpaid());
        System.out.println(employee.getAdditionalneeds());
        System.out.println(bookingdatesclass.getCheckin());
        System.out.println(bookingdatesclass.getCheckout());

        //Serilzation

        Gson gson = new Gson();
        String employee1 = gson.toJson(employee);

        //deserilazation
        System.out.println("-------poojo desrilazation--------");
        Employee employee2 = gson.fromJson(employee1,Employee.class);
        System.out.println(employee2.getFirstname());

        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.given()
                .header("Content-type","application/json")
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(employee1)
                .when()
                .post("/booking")
                .then()
                .log().all().assertThat()
                .body("bookingid",Matchers.notNullValue());
    }
}

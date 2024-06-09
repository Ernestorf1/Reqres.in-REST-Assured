import org.junit.Test;

import io.restassured.RestAssured;

public class DemoRestAssured {

    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://reqres.in/api";
        String body = RestAssured.given().when().get("/users").then().extract().body().asString();

        System.out.println(body);

    }
}

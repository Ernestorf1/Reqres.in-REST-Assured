import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class DemoRestAssured {

    @Test
    public void testGetUsers() {
        // Setup URI for requests
        baseURI = "https://reqres.in/api";

        // GET request to the /users endpoint storing in a String variable "body"
        String body = given()
                .when()
                .get("/users?page=2")
                .then()
                // Verify response status code
                .statusCode(200)
                // Verify that name on position 1 matches
                .body("data[1].first_name", equalTo("Lindsay"))
                // Extract response body as String
                .extract().body().asString();

        // Print response body in console
        System.out.println(body);

    }
   // GET Single User
   @Test
   public void testGetSingleUser() {
       // Setup URI for requests
       baseURI = "https://reqres.in/api";

       // GET request to the /users/2 endpoint
       String body2 = given()
                       .when()
                           .get("/users/2")
                       .then()
                           // Verify response status code
                           .statusCode(200)
                           // Verify that the last name matches
                           .body("data.last_name", equalTo("Weaver"))
                           // Extract response body as String
                           .extract().body().asString();

       // Print response body in console
       System.out.println(body2);
   }

    @Test
    public void testPostUser() {
        // Setup URI
        baseURI = "https://reqres.in/api";

        // Create a Map to use with user data to send
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Alejandra");
        map.put("job", "Customer Success");

        // Create a POST request to /users endpoint
        given()
                // Registering all log in console to depurate
                .log().all()
                // Define body request using the map created
                .body(map)
                .when()
                // Send the POST request
                .post("/users")
                .then()
                // Registering all the log response in console
                .log().all()
                // Verify statusCode 201
                .statusCode(201);

    }

}

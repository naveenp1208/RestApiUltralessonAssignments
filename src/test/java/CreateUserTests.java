import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test
    public void shouldCreateMaleUser() {



        // 1. Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna55@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        // 2. Act
        createUser(body)
                .then()
                .log().body()

        // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna55@gmail.com"));




    }


    @Test
    public void shouldCreateFemaleUser() {



        // 1. Arrange
        String body = "{\n" +
                "  \"name\": \"Anushka\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Anushka.sheety66@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        // 2. Act
        createUser(body)
                .then()
                .log().body()

        // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("Anushka.sheety66@gmail.com"));
    }

        private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ed50b50c3f76a6e0dfbf0f4e87f0ca7f46fda8cc0f68632d2d86e1bf369949ec")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }





    }



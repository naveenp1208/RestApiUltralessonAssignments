import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test
    public void shouldCreateMaleUser() {



        // 1. Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna16@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        // 2. Act
       new UsersClient().createUser(body)
                .then()
                .log().body()

        // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna16@gmail.com"));




    }


    @Test
    public void shouldCreateFemaleUser() {



        // 1. Arrange
        String body = "{\n" +
                "  \"name\": \"Anushka\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Anushka.sheety15@gmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        // 2. Act
      new UsersClient().createUser(body)
                .then()
                .log().body()

        // 3. Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("Anushka.sheety15@gmail.com"));
    }









    }



import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Sampletest {
    @Test
    public void shouldGetAllUsers(){

        //Arrange
        //Act
        //Assert
        given()
                .when()
                     .get("https://gorest.co.in/public/v1/users")
                .then()
                     .statusCode(200)
                     .log().body();


    }


    @Test
    public void shouldCreateUser() {
        // 1. Arrange
        // 2. Act
        // 3. Assert

        given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization","Bearer ed50b50c3f76a6e0dfbf0f4e87f0ca7f46fda8cc0f68632d2d86e1bf369949ec")
                        .body("{\n" +
                                "  \"name\": \"Tenali Ramakrishna\",\n" +
                                "  \"gender\": \"male\",\n" +
                                "  \"email\": \"tenali.ramakrishna32@gmail.com\",\n" +
                                "  \"status\": \"active\"\n" +
                                "}")
                .when()
                     .post("https://gorest.co.in/public/v1/users")
                .then()
                     .log().body()
                     .statusCode(201);


    }

}

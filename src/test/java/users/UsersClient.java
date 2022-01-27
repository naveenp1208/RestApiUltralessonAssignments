package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(CreateUserRequestBody body) {
        return
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer ed50b50c3f76a6e0dfbf0f4e87f0ca7f46fda8cc0f68632d2d86e1bf369949ec")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");
    }



    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v1/users");
    }

}

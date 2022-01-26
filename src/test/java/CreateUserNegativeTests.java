import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
            usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        // 1. Arrange
        String body = "{\n" +
                "  \"name\": \"Anushka\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"Anushka.sheetygmail.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        // 2. Act
       usersClient.createUser(body)
                .then()
                .log().body()

                // 3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));

    }

}

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class GetAllUsersTests {

    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeclass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldGetAllUsers(){



        //Act
        usersClient
                .getAllUsers()
                .then()
                //Assert
                .statusCode(200)
                .body("data", Matchers.hasSize(20))
                .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")))
                .log().body();


    }



}

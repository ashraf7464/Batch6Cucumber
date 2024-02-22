package restAssuredTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class APIMentoring {

    String baseURI = "https://uprightautomation.online/wp-json/";

    @Test
    public void getToken(){

        Map<String, String> newUser = new HashMap<>();

        newUser.put("username", "ashraf_1000");
        newUser.put("password", "Yellow_123");

        Response response = given()
                .baseUri(baseURI)
                .when()
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\getToken.json"))
                .post("jwt-auth/v1/token/")
                .then()
                .log()
                .all()
                .assertThat()
                .header("Content-Length", "273")
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();



    }
























}

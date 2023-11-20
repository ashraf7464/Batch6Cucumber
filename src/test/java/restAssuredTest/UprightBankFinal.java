package restAssuredTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;

import static io.restassured.RestAssured.given;

public class UprightBankFinal {

    String baseURI ="https://uprightautomation.online/wp-json/";
    String bearerToken;
    int accountNumber=126;
    int transaction_id;

    @Test
    public void createAccount(){
        Response response = given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .when()
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\uprightBankFinal\\createAccount.json"))
                .post("upright-account/register")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

    @Test
    public void getToken(){
        Response response = given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .when()
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\uprightBankFinal\\getToken.json"))
                .post("jwt-auth/v1/token/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();
        bearerToken= jp.getString("token");
        System.out.println(bearerToken);

    }

    @Test
    public void tokenValidation(){
        Response response = given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .post("jwt-auth/v1/token/validate")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

    }

    @Test
    public void getPersonalAccountInformation(){

    }

    @Test
    public void updatePersonalAccountInformation(){

    }

    @Test
    public void deactivatePersonalAccount(){

    }

    @Test
    public void activatePersonalAccount(){

    }

    @Test
    public void getAccountTransactionData(){

    }

    @Test
    public void deleteAccountTransactionData(){

    }

}

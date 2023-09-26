package restAssuredTest;

import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

import static io.restassured.RestAssured.*;

public class Reqres {
String baseURI = "https://reqres.in";
@Test(priority = 1)
    public void listUsers(){

        Response response = given()
                .baseUri(baseURI)
                .queryParam("page",2)
                .when()
                .get("/api/users")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        SoftAssert soft = new SoftAssert();
        JsonPath jp = response.jsonPath();

        int pageNumber = jp.getInt("page");
        soft.assertEquals(pageNumber,2);
        soft.assertAll();

    }
@Test(priority = 2)
    public void singleUser(){
        Response response =given()
                .baseUri(baseURI)
                .queryParam("id",2)
                .when()
                .get("/api/users")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }
@Test(priority = 3)
    public void singleUserNotFound(){
    Response response =given()
                .baseUri(baseURI)
                .queryParam("id",23)
                .when()
                .get("/api/users")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(404)
                .extract().response();
    }
@Test(priority = 4)
    public void listResource(){
    Response response =given()
                .baseUri(baseURI)
                .queryParam("unknown","unknown")
                .when()
                .get("api/unknown")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
            .extract().response();
    }
@Test(priority = 5)
    public void singleResource(){
    Response response =given()
                .baseUri(baseURI)
                .queryParam("id",2)
                .when()
                .get("api/unknown")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
            .extract().response();
    }
@Test(priority = 6)
    public void singleUserResourceNotFound(){
    Response response =given()
                .baseUri(baseURI)
                .queryParam("id",23)
                .when()
                .get("api/unknown")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(404)
                .extract().response();
    }
@Test(priority = 7)
    public void createUser(){
    Response response = given()
            .baseUri(baseURI)
            .header("Content-type", "application/json")
            .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\createPayload.json"))
            .when()
            .post("/api/users")
            .then()
            .log()
            .all()
            .assertThat()
            .statusCode(201)
            .extract().response();

    JsonPath jp = response.jsonPath();
    int userID = jp.getInt("id");
    System.out.println("Assigned ID for new user is : "+userID);

    }
@Test(priority = 8)
    public void updateUser(){
    Response response =given()
            .baseUri(baseURI)
            .header("Content-type", "application/json")
            .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\updatePayload.json"))
            .when()
            .put("/api/users/2")
            .then()
            .log()
            .all()
            .assertThat()
            .statusCode(200)
            .extract().response();
    }
    @Test(priority = 9)
    public void patchUser(){
        Response response =given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\patchPayload.json"))
                .when()
                .patch("/api/users/2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }
    @Test(priority = 10)
    public void deleteUser() {
        Response response =given()
                .baseUri(baseURI)
                .when()
                .delete("/api/users/2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(204)
                .extract().response();
    }
    @Test(priority = 11)
    public void registerUser() {
        Response response=given()
                .baseUri(baseURI)
                .header("Content-type", "application/json") //??
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\registerPayload.json"))
                .when()
                .post("/api/register")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();
        int id = jp.getInt("id");
        String token = jp.getString("token");

        SoftAssert soft = new SoftAssert();

        soft.assertEquals(4, id);
        soft.assertEquals("QpwL5tke4Pnpja7X4", token);
        soft.assertAll();
    }

    @Test(priority = 12)
    public void registerUnsuccessful() {
        Response response=given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\registerUnsuccessfulPayload.json"))
                .when()
                .post("/api/register")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .extract().response();

        JsonPath jp = response.jsonPath();
        String error = jp.getString("error");

        System.out.println(error);

    }

    @Test(priority = 13)
    public void loginSuccessful() {
        Response response =given()
                .baseUri(baseURI)
                .header("Content-type", "application/json") //??
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\loginPayload.json"))
                .when()
                .post("/api/login")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 14)
    public void loginUnsuccessful() {
        Response response =given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\loginUnsuccessfulPayload.json"))
                .when()
                .post("/api/login")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .extract().response();
    }

    @Test(priority = 15)
    public void delayedResponse() {
        Response response =given()
                .baseUri(baseURI)
                .queryParam("delay",3)
                .when()
                .get("/api/users")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

}

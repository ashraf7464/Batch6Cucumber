package restAssuredTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;



public class uprightAPI {

    String baseURI = "https://uprightautomation.online/wp-json/";
    String bearerToken;
    int accountNumber = 148;

@Test
    public void createUser(){
    Response response = given()
            .baseUri(baseURI)
            .header("Content-type", "application/json")
            .when()
            .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\upRight\\create.json"))
            .post("upright-account/register")
            .then()
            .log()
            .all()
            .assertThat()
            .statusCode(200)
            .extract().response();

    JsonPath jp = response.jsonPath();
    String responseBody = jp.getString("username_email");

    if(responseBody.contains("already existing")){
        System.out.println("User already exist");
    }

    }

@Test
    public void getToken(){

    Response response = given()
            .baseUri(baseURI)
            .header("Content-type", "application/json")
            .when()
            .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\upRight\\getToken.json"))
            .post("jwt-auth/v1/token/")
            .then()
            .log()
            .all()
            .assertThat()
            .statusCode(200)
            .extract().response();

    JsonPath jp = response.jsonPath();

    bearerToken = jp.getString("token");

    System.out.println(bearerToken);

    String userDisplayName = jp.getString("user_display_name");

    if(userDisplayName.equalsIgnoreCase("Md Ashraf")){
        System.out.println("Correct user and token");
    }
}



@Test
    public void tokenValidation() {

        Response response = given()
                .baseUri(baseURI)
                //.header("Authorization", "Bearer " +bearerToken)
                .header("Authorization", "Bearer " +"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3VwcmlnaHRhdXRvbWF0aW9uLm9ubGluZSIsImlhdCI6MTY5NTA4NjU5MiwibmJmIjoxNjk1MDg2NTkyLCJleHAiOjE2OTU2OTEzOTIsImRhdGEiOnsidXNlciI6eyJpZCI6IjE0OCJ9fX0.78y-mrYsND8SJr6EvsXrKpBVGHphRmIWfA5iIm11A28")
                .when()
                .post("jwt-auth/v1/token/validate")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();

        String token = jp.getString("code");

        if (token.contains("valid_token")) {
            System.out.println("Token is validated");
        }

    }

    @Test
    public void getPersonalInformation() {

        Response response = given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " +"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3VwcmlnaHRhdXRvbWF0aW9uLm9ubGluZSIsImlhdCI6MTY5NTA4NjU5MiwibmJmIjoxNjk1MDg2NTkyLCJleHAiOjE2OTU2OTEzOTIsImRhdGEiOnsidXNlciI6eyJpZCI6IjE0OCJ9fX0.78y-mrYsND8SJr6EvsXrKpBVGHphRmIWfA5iIm11A28")
                .when()
                .get("upright-account/get/personal-info/"+accountNumber)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();

        String birthDay = jp.getString("birth");

        if (birthDay.equalsIgnoreCase("01-24")) {
            System.out.println("Correct user info");
        }

    }

    @Test
    public void updatePersonalInformation() {

        Response response = given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " +"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3VwcmlnaHRhdXRvbWF0aW9uLm9ubGluZSIsImlhdCI6MTY5NTA4NjU5MiwibmJmIjoxNjk1MDg2NTkyLCJleHAiOjE2OTU2OTEzOTIsImRhdGEiOnsidXNlciI6eyJpZCI6IjE0OCJ9fX0.78y-mrYsND8SJr6EvsXrKpBVGHphRmIWfA5iIm11A28")
                .when()
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\upRight\\updateUser.json"))
                .put("upright-account/update/personal-info")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();


    }

@Test
    public void activateAccount(){

    Response response = given()
            .baseUri(baseURI)
            .header("Content-type", "application/json")
            .header("Authorization", "Bearer " +"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3VwcmlnaHRhdXRvbWF0aW9uLm9ubGluZSIsImlhdCI6MTY5NTA4NjU5MiwibmJmIjoxNjk1MDg2NTkyLCJleHAiOjE2OTU2OTEzOTIsImRhdGEiOnsidXNlciI6eyJpZCI6IjE0OCJ9fX0.78y-mrYsND8SJr6EvsXrKpBVGHphRmIWfA5iIm11A28")
            .when()
            .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\upRight\\activateAccount.json"))
            .patch("upright-account/update/account-status")
            .then()
            .log()
            .all()
            .assertThat()
            .statusCode(200)
            .extract().response();

}


@Test
    public void deactivateAccount(){

        Response response = given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " +"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3VwcmlnaHRhdXRvbWF0aW9uLm9ubGluZSIsImlhdCI6MTY5NTA4NjU5MiwibmJmIjoxNjk1MDg2NTkyLCJleHAiOjE2OTU2OTEzOTIsImRhdGEiOnsidXNlciI6eyJpZCI6IjE0OCJ9fX0.78y-mrYsND8SJr6EvsXrKpBVGHphRmIWfA5iIm11A28")
                .when()
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\upRight\\deactivateAccount.json"))
                .patch("upright-account/update/account-status")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

    }

    @Test
    public void accountTransaction(){

        Response response = given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " +"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3VwcmlnaHRhdXRvbWF0aW9uLm9ubGluZSIsImlhdCI6MTY5NTA4NjU5MiwibmJmIjoxNjk1MDg2NTkyLCJleHAiOjE2OTU2OTEzOTIsImRhdGEiOnsidXNlciI6eyJpZCI6IjE0OCJ9fX0.78y-mrYsND8SJr6EvsXrKpBVGHphRmIWfA5iIm11A28")
                .when()
                .get("upright-account/get/transaction/"+accountNumber)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

    }

    @Test
    public void deleteTransactionData(){

        Response response = given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " +"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3VwcmlnaHRhdXRvbWF0aW9uLm9ubGluZSIsImlhdCI6MTY5NTA4NjU5MiwibmJmIjoxNjk1MDg2NTkyLCJleHAiOjE2OTU2OTEzOTIsImRhdGEiOnsidXNlciI6eyJpZCI6IjE0OCJ9fX0.78y-mrYsND8SJr6EvsXrKpBVGHphRmIWfA5iIm11A28")
                .when()
                .delete("upright-account/delete/transaction/"+accountNumber)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

    }



}

package restAssuredTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DummyRestAPI {

    String baseURI = "https://dummy.restapiexample.com/api/v1";

    @Test
    public void getEmployeeData(){
        Response response = given()
                .baseUri(baseURI)
                .when()
                .get("/employees")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();
        String status = jp.getString("status");
        int id = jp.getInt("data[0].id");
        int age3 = jp.getInt("data[2].employee_age");


        SoftAssert soft = new SoftAssert();

        soft.assertEquals(id,1);
        soft.assertEquals(age3,66);
        soft.assertEquals(status,"success");
        System.out.println(id);
        System.out.println(age3);

    }

    @Test
    public void getSingleEmployeeData(){
        Response response = given()
                .baseUri(baseURI)
                .when()
                .get("/employee/1")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();
        String message = jp.getString("message");
        int id = jp.getInt("data.id");


        SoftAssert soft = new SoftAssert();

        soft.assertEquals(id,1);
        soft.assertEquals(message,"Successfully! Record has been fetched.");
    }

    @Test
    public void createNewRecord(){
        Response response = given()
                .baseUri(baseURI)
                .when()
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\DummyRestAPI\\newRecord.json"))
                .post("/create")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();
        String status = jp.getString("status");
        String message = jp.getString("message");

        SoftAssert soft = new SoftAssert();

        soft.assertEquals(status,"success");
        soft.assertEquals(message,"Successfully! Record has been added.");


    }

    @Test
    public void createNewRecordHashMap(){
        Map <String, String> newEmp = new HashMap<>();
        newEmp.put("name", "Ashraf");
        newEmp.put("salary", "111");
        newEmp.put("age", "36");

        Response response = given()
                .baseUri(baseURI)
                .when()
                .body(newEmp )
                .post("/create")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }
    @Test
    public void updateAnEmployeeRecord(){
        Response response = given()
                .baseUri(baseURI)
                .when()
                .body(new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\main\\resources\\jsonFiles\\DummyRestAPI\\updateRecord.json"))
                .put("/update/21")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JsonPath jp = response.jsonPath();
        String status = jp.getString("status");
        String message = jp.getString("message");

        SoftAssert soft = new SoftAssert();

        soft.assertEquals(status,"success");
        soft.assertEquals(message,"Successfully! Record has been updated.");

    }

    @Test
    public void deleteAnEmployeeRecord(){
        Response response = given()
                .baseUri(baseURI)
                .when()
                .delete("/delete/2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

    }
}

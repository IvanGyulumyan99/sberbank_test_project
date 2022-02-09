package API.ipApi.steps;

import API.ipApi.requestSpecifications.USAPIBaseRequestSpecification;
import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class USAAPISteps {
    @Step("Get random ip address from USA ip addresses query")
    @Attachment
    public String getRandomIpAddress() {
        Faker faker = new Faker();
        return given()
                .spec(USAPIBaseRequestSpecification.usAPIRequestSpecification())
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getString("data[" + faker.random().nextInt(0, 50000) + "][1]");
    }
}

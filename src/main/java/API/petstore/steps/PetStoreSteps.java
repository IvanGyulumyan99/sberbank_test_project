package API.petstore.steps;

import API.petstore.requestDTO.User;
import API.petstore.requestSpecifications.PetStoreBaseRequestSpecification;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetStoreSteps {
    @Step("Change users firstname to {firstName}")
    @Attachment
    public Response changeUsersFirstName(User user, String firstName) {
        user.setFirstName(firstName);
        return given()
                .spec(PetStoreBaseRequestSpecification.petStoreRequestSpecification())
                .body(user)
                .when()
                .put(user.getUsername());
    }

    @Step("Change users lastname to {lastname}")
    @Attachment
    public Response changeUsersLastName(User user, String lastname) {
        user.setLastName(lastname);
        return given()
                .spec(PetStoreBaseRequestSpecification.petStoreRequestSpecification())
                .body(user)
                .when()
                .put(user.getUsername());
    }

    @Step("Get users by username: {username}")
    @Attachment
    public Response getUserByUsername(String username) {
        return given()
                .spec(PetStoreBaseRequestSpecification.petStoreRequestSpecification())
                .when()
                .get(username);
    }

    @Step("Create user")
    @Attachment
    public Response createUser(User user) {
        return given()
                .spec(PetStoreBaseRequestSpecification.petStoreRequestSpecification())
                .body(user)
                .post();
    }

    @Step("Create users from list")
    @Attachment
    public Response createUsersFromList(List<User> userList) {
        return given()
                .spec(PetStoreBaseRequestSpecification.petStoreRequestSpecification())
                .body(userList)
                .post("/createWithList");
    }

    @Step("Login system")
    public Response login(String username, String password) {
        return given()
                .spec(PetStoreBaseRequestSpecification.petStoreRequestSpecification())
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("/login");
    }
}


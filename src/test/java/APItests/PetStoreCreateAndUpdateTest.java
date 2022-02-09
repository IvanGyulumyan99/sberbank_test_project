package APItests;

import API.petstore.base.PetStoreBaseTest;
import API.petstore.requestDTO.User;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static API.petstore.utils.UserGenerator.generateListOfUsersWithLength;
import static org.hamcrest.core.IsEqual.equalTo;

@DisplayName("Pet store")
@Epic("API")
public class PetStoreCreateAndUpdateTest extends PetStoreBaseTest {

    /**
     * Check that put request works correctly for firstname field
     * 1. Creates users
     * 2. Update users firstname
     * 3. Check that firstname changed
     */
    @Test
    @Story("Update users fields")
    @DisplayName("Create user and update firstName field")
    public void updateFirstNameTest() {
        String firstNameToChange = "Ivan";
        List<User> listOfUsersToCreate = generateListOfUsersWithLength(5);
        User lastUser = listOfUsersToCreate.get(listOfUsersToCreate.size() - 1);

        petStoreSteps.login("username", "password");

        petStoreSteps.createUsersFromList(listOfUsersToCreate)
                .then()
                .statusCode(200);

// uncomment to print result of finding created users from list (only last user creates)
//        for (User user : listOfUsersToCreate) {
//            System.out.println(petStoreSteps
//                    .getUserByUsername(user.getUsername())
//                    .then()
//                    .extract().asString());
//        }

        petStoreSteps.changeUsersFirstName(lastUser, firstNameToChange)
                .then()
                .statusCode(200);

        petStoreSteps.getUserByUsername(lastUser.getUsername())
                .then()
                .statusCode(200)
                .body("firstName", equalTo(firstNameToChange));
    }

    /**
     * Check that put request works correctly for lastname field
     * 1. Creates users
     * 2. Update users lastname
     * 3. Check that lastname changed
     */
    @Test
    @Story("Update users fields")
    @DisplayName("Create user and update lastName field")
    public void updateLastNameTest() {
        String lastnameToChange = "Gyulumyan";
        List<User> listOfUsersToCreate = generateListOfUsersWithLength(5);
        User lastUser = listOfUsersToCreate.get(listOfUsersToCreate.size() - 1);

        petStoreSteps.login("username", "password");

        petStoreSteps.createUsersFromList(listOfUsersToCreate)
                .then()
                .statusCode(200);

        // uncomment to print result of finding created users from list (only last user creates)
//        for (User user : listOfUsersToCreate) {
//            System.out.println(petStoreSteps
//                    .getUserByUsername(user.getUsername())
//                    .then()
//                    .extract().asString());
//        }

        petStoreSteps.changeUsersLastName(lastUser, lastnameToChange)
                .then()
                .statusCode(200);

        petStoreSteps.getUserByUsername(lastUser.getUsername())
                .then()
                .statusCode(200)
                .body("lastName", equalTo(lastnameToChange));
    }

}

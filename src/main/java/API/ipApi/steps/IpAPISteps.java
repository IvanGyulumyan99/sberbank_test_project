package API.ipApi.steps;

import API.ipApi.responseDTO.IpObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

import static API.ipApi.requestSpecifications.IpAPIBaseRequestSpecification.ipAPIRequestSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IpAPISteps {
    @Step("Check that all ip addresses from list are from: {expectedCountry}")
    @Attachment
    public void checkAllIpAddressesFromListAreFromCountry(String expectedCountry, List<String> listOfAPIAddresses) throws IOException {
        for (String ipAddress : listOfAPIAddresses) {
            IpObject actualCountry = getIpAddressInfo(ipAddress)
                    .then()
                    .statusCode(200)
                    .extract().body().as(IpObject.class);
            assertEquals(expectedCountry, actualCountry.getCountryName(),
                    "The IP address " + ipAddress + " belongs to " + actualCountry.getCountryName() + ", " + actualCountry.getCountryCode());
        }
    }

    //Same method but easier using jsonpath
//    @Step("Check that all ip addresses from list are from: {expectedCountry}")
//    @Attachment
//    public void checkAllIpAddressesFromListAreFromCountry(String expectedCountry, List<String> listOfAPIAddresses) throws IOException {
//        for (String ipAddress : listOfAPIAddresses) {
//            String actualCountry = getIpAddressInfo(ipAddress)
//                    .then()
//                    .statusCode(200)
//                    .extract().body().jsonPath().getString("country_name");
//            Assertions.assertEquals(expectedCountry, actualCountry, "IP address " + ipAddress + " is from " + actualCountry);
//        }
//    }

    @Step("Get info about ip address։ {ip}")
    @Attachment
    private Response getIpAddressInfo(String ip) throws IOException {
        return given()
                .spec(ipAPIRequestSpecification())
                .get(ip);
    }
}

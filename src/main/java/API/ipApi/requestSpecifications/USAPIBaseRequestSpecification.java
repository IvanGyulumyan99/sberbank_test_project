package API.ipApi.requestSpecifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class USAPIBaseRequestSpecification {
    public static RequestSpecification usAPIRequestSpecification() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://cdn-lite.ip2location.com/datasets/US.json");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addFilter(new AllureRestAssured());
        return requestSpecBuilder.build();
    }
}

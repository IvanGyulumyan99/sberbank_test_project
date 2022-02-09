package API.ipApi.requestSpecifications;

import API.ipApi.utils.ReadProperty;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class IpAPIBaseRequestSpecification {
    public static RequestSpecification ipAPIRequestSpecification() throws IOException {
        ReadProperty readProperty = new ReadProperty();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addFilter(new AllureRestAssured());
        requestSpecBuilder.addQueryParam("access_key", readProperty.getPropertyValue("access_key"));
        requestSpecBuilder.setBaseUri("http://api.ipapi.com/api/");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        return requestSpecBuilder.build();
    }
}

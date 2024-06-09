package perf.ipr.api.core;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import static io.restassured.RestAssured.given;

@Component
public class RestRequest {
    @Autowired
    private RestRequestConfig restRequestConfig;

    public static Response getResponse() {
        return response;
    }

    public static Response response;

    public void executeGetRequest(String path) {
        response = given().spec(restRequestConfig.getSpecificationForGetAndDelete())
                .when()
                .get(path)
                .then()
                .extract().response();
    }

    public void executeGetRequestWithPathParam(String path, Map<String, String> params) {
        response = given().spec(restRequestConfig.getSpecificationForGetAndDelete())
                .when()
                .pathParams(params)
                .get(path)
                .then()
                .extract().response();
    }

    public void executePostRequest(String path, String body) {
        response = given().spec(restRequestConfig.getSpecificationForPostAndPatch(body))
                .when()
                .post(path)
                .then()
                .extract().response();
    }

    public void executePostRequestWithPathParam(String path, String body, Map<String, String> params) {
        response = given().spec(restRequestConfig.getSpecificationForPostAndPatch(body))
                .when()
                .pathParams(params)
                .post(path)
                .then()
                .extract().response();
    }

    public void executeDeleteRequestWithPathParam(String path, Map<String, String> params) {
        response = given().spec(restRequestConfig.getSpecificationForGetAndDelete())
                .when()
                .pathParams(params)
                .delete(path)
                .then()
                .extract().response();
    }

    public void executePatchRequestWithPathParam(String path, String body, Map<String, String> params) {
        response = given().spec(restRequestConfig.getSpecificationForPostAndPatch(body))
                .when()
                .pathParams(params)
                .patch(path)
                .then()
                .extract().response();
    }
}

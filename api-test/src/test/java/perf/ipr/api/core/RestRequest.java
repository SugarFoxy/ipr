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

    public Response executeGetRequest(String path) {
        return given().spec(restRequestConfig.getSpecificationForGetAndDelete())
                .when()
                .get(path)
                .then()
                .extract().response();
    }

    public Response executeGetRequestWithPathParam(String path, Map<String, String> params) {
        return given().spec(restRequestConfig.getSpecificationForGetAndDelete())
                .when()
                .pathParams(params)
                .get(path)
                .then()
                .extract().response();
    }

    public Response executePostRequest(String path, Object body) {
        return given().spec(restRequestConfig.getSpecificationForPostAndPatch(body))
                .when()
                .post(path)
                .then()
                .extract().response();
    }

    public Response executePostRequestWithPathParam(String path, String body, Map<String, String> params) {
        return given().spec(restRequestConfig.getSpecificationForPostAndPatch(body))
                .when()
                .pathParams(params)
                .post(path)
                .then()
                .extract().response();
    }

    public Response executeDeleteRequestWithPathParam(String path, Map<String, String> params) {
        return given().spec(restRequestConfig.getSpecificationForGetAndDelete())
                .when()
                .pathParams(params)
                .delete(path)
                .then()
                .extract().response();
    }

    public Response executePatchRequestWithPathParam(String path, Object body, Map<String, String> params) {
        return given().spec(restRequestConfig.getSpecificationForPostAndPatch(body))
                .when()
                .pathParams(params)
                .patch(path)
                .then()
                .extract().response();
    }
}

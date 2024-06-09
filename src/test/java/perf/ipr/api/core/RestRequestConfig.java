package perf.ipr.api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perf.ipr.common.EnvironmentData;

@Component
public class RestRequestConfig {
    @Autowired
    private EnvironmentData environmentData;

    public RequestSpecification getSpecificationForGetAndDelete() {
        return new RequestSpecBuilder()
                .setBaseUri(environmentData.getUrl())
                .build();
    }

    public RequestSpecification getSpecificationForPostAndPatch(String body) {
        return new RequestSpecBuilder()
                .setBaseUri(environmentData.getUrl())
                .setContentType(ContentType.JSON)
                .setBody(body)
                .build();
    }

}

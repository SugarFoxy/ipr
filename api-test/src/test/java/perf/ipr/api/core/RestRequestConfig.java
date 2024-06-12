package perf.ipr.api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perf.ipr.api.PropertiesConfiguration;

@Component
public class RestRequestConfig {
    @Autowired
    private PropertiesConfiguration configuration;

    public RequestSpecification getSpecificationForGetAndDelete() {
        System.out.println(configuration.getApiServerUrl());
        return new RequestSpecBuilder()
                .setBaseUri(configuration.getApiServerUrl())
                .build();
    }

    public RequestSpecification getSpecificationForPostAndPatch(String body) {
        System.out.println("url::");
        System.out.println(configuration.getApiServerUrl());
        return new RequestSpecBuilder()
                .setBaseUri(configuration.getApiServerUrl())
                .setContentType(ContentType.JSON)
                .setBody(body)
                .build();
    }

}

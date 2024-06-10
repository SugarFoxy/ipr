package perf.ipr.api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;


@Component
public class RestRequestConfig {

    //    @Autowired
//    private Environment env;
    String serverUrl = "http://localhost:9090";
    public RequestSpecification getSpecificationForGetAndDelete() {
//        var serverUrl = env.getProperty("my.property");
        System.out.println("url::");
        System.out.println(serverUrl);
        return new RequestSpecBuilder()
                .setBaseUri(serverUrl)
                .build();
    }

    public RequestSpecification getSpecificationForPostAndPatch(String body) {
        System.out.println("url::");
        System.out.println(serverUrl);
        return new RequestSpecBuilder()
                .setBaseUri(serverUrl)
                .setContentType(ContentType.JSON)
                .setBody(body)
                .build();
    }

}

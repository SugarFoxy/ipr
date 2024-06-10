package perf.ipr.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeneratorJson {
    private static final Gson gson = new GsonBuilder().create();

    public static String toJson(Object object){
        return gson.toJson(object);
    }
}

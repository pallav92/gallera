package pallav.example.com.galleryapp.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

/**
 * Class is used to object to json string conversion and vice versa.
 */

public class GsonUtils {
    public static <T> T parseJson(String json, Class<T> tClass) {
        return new Gson().fromJson(json, tClass);
    }

    public static <T> T parseJson(JsonElement result, Class<T> tClass) {
        return new Gson().fromJson(result, tClass);
    }

    public static <T> T parseJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }

    public static JsonObject parseJson(String response) {
        JsonObject jo = null;
        JsonElement e = null;
        return new JsonParser().parse(response).getAsJsonObject();
    }

    public static JsonArray getJsonElement(String s) {
        return new JsonParser().parse(s).getAsJsonArray();
    }


    public static String getJson(Object profile) {
        return new Gson().toJson(profile);
    }

    public static String getExposeJson(Object profile) {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(profile);
    }

    public static <T> T getObject(final String jsonString, final Class<T> objectClass) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, objectClass);
    }



}

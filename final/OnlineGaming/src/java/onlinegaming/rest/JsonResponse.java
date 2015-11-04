package onlinegaming.rest;

import com.google.gson.JsonObject;

public class JsonResponse {

    private JsonObject jsonObject;

    public JsonResponse() {
        jsonObject = new JsonObject();
    }

    public void addProperty(String property, String value) {
        jsonObject.addProperty(property, value);
    }

    public void addProperty(String property, int value) {
        jsonObject.addProperty(property, value);
    }

    @Override
    public String toString() {
        return jsonObject.toString();
    }
    
    

}

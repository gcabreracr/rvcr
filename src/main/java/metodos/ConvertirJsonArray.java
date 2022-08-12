package metodos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class ConvertirJsonArray {

    public static JSONObject wrapFieldInArray(JSONObject object, String fieldKey) throws JSONException {
        Object fieldValueObj = object.get(fieldKey);
        if (fieldValueObj instanceof JSONObject) {
            JSONObject fieldValue = (JSONObject) fieldValueObj;
            object.remove(fieldKey);
            object.put(fieldKey, wrapObjectInArray(fieldValue));
        }
        return object;
    }

    public static JSONArray wrapObjectInArray(JSONObject obj) throws JSONException {
        return new JSONArray().put(new JSONObject(obj.toString()));
    }

}

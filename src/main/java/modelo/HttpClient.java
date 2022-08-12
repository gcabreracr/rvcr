package modelo;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpClient {

    public static JSONObject httpPOST(String url, JSONObject json) throws IOException, JSONException {
        JSONObject jsonObjectResp = null;

        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        jsonObjectResp = new JSONObject(response.body().string());

        return jsonObjectResp;

    }

    public static JSONObject httpGET(String url) throws IOException, JSONException {
        JSONObject jsonObjectResp = null;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        jsonObjectResp = new JSONObject(response.body().string());

        return jsonObjectResp;
    }

}

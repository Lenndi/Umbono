package org.lenndi.umbono;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.lenndi.umbono.entity.Token;
import org.lenndi.umbono.util.Properties;

import java.io.UnsupportedEncodingException;

/**
 * Based application.
 */

public class UmbonoApplication extends Application {

    private Context context;
    private Properties properties;

    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();

        this.properties = new Properties(context);
        this.getJwtToken();

    }

    public Context getAppContext() {
        return this.context;
    }

    private void getJwtToken() {
        String loginUrl = this.properties.getApiUrl() + "/login";

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", UmbonoApplication.this.properties.getAppUsername());
            jsonBody.put("password", UmbonoApplication.this.properties.getAppPassword());
        } catch (JSONException e) {
            VolleyLog.wtf("Can't add username & password in jsonBody.");
        }
        final String stringBody = jsonBody.toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(
                Request.Method.POST,
                loginUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Token token = gson.fromJson(response, Token.class);
                        UmbonoApplication.this.properties.setToken(token.getAuthorization());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Authentication", "Can't receive jwt token");
                    }
                })  {

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        try {
                            return stringBody == null ? null : stringBody.getBytes("utf-8");
                        } catch (UnsupportedEncodingException uee) {
                            VolleyLog.wtf(
                                "Unsupported Encoding while trying to get the bytes of %s using %s",
                                stringBody,
                                "utf-8");

                            return null;
                        }
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }
        };

        queue.add(request);
    }
}

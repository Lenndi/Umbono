package org.lenndi.umbono.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
import org.lenndi.umbono.R;
import org.lenndi.umbono.entity.Token;

import java.io.UnsupportedEncodingException;


public class JwtManager {

    private Context context;
    private Properties properties;

    public JwtManager(Context context) {
        this.context = context;
        this.properties = new Properties(context);
    }

    /**
     * Request jwt token and set it to properties.
     *
     * @return 0 if ok
     */
    public int jwtRequest() {
        final int[] returnCode = new int[1];
        String loginUrl = this.properties.getApiUrl() + "/login";

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", JwtManager.this.properties.getAppUsername());
            jsonBody.put("password", JwtManager.this.properties.getAppPassword());
        } catch (JSONException e) {
            VolleyLog.wtf("Can't add username & password in jsonBody.");
        }
        final String stringBody = jsonBody.toString();

        RequestQueue queue = Volley.newRequestQueue(this.context);
        StringRequest request = new StringRequest(
                Request.Method.POST,
                loginUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Token token = gson.fromJson(response, Token.class);
                        JwtManager.this.properties.setToken(token.getAuthorization());

                        returnCode[0] = 0;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Authentication", "Can't receive jwt token");
                        Toast.makeText(context, R.string.cnx_error, Toast.LENGTH_LONG).show();

                        returnCode[0] = -1;
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

        return returnCode[0];
    }
}

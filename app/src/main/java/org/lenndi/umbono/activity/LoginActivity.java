package org.lenndi.umbono.activity;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.lenndi.umbono.R;
import org.lenndi.umbono.util.JwtManager;
import org.lenndi.umbono.util.LogTag;
import org.lenndi.umbono.util.Properties;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Properties properties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.properties = new Properties(this);

        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (nfcAdapter == null) {
            Toast.makeText(this, R.string.no_rfid, Toast.LENGTH_LONG).show();
        } else if (!nfcAdapter.isEnabled()) {
            Toast.makeText(this, R.string.turn_on_rfid, Toast.LENGTH_LONG).show();
        }
      }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        String uid = this.bin2hex(tag.getId());
        this.properties.setUserUid(uid);

        // Carte test : 501F9A7C
        //Toast.makeText(this, uid, Toast.LENGTH_LONG).show();

        this.switchToLoanActivity();
    }

    private void switchToLoanActivity() {
        String loansUrl = String.format(
                "%s/uid/borrowers/%s/loans",
                this.properties.getApiUrl(),
                this.properties.getUserUid());

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(
                Request.Method.GET,
                loansUrl,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Intent intent = new Intent(LoginActivity.this, LoanActivity.class);
                        intent.putExtra("loans", response);
                        startActivity(intent);
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error.networkResponse.statusCode == 401) {
                            JwtManager jwtManager = new JwtManager(LoginActivity.this);
                            int returnCode = jwtManager.jwtRequest();

                            if (returnCode == 0) {
                                LoginActivity.this.switchToLoanActivity();
                            }
                        } else if (error.networkResponse.statusCode == 404) {
                            Toast.makeText(
                                    LoginActivity.this,
                                    R.string.user_not_found,
                                    Toast.LENGTH_LONG).show();
                            Log.e(LogTag.API_TAG, "User not found");
                        } else {
                            Toast.makeText(
                                    LoginActivity.this,
                                    R.string.api_error,
                                    Toast.LENGTH_LONG).show();
                            Log.e(LogTag.API_TAG, "Api error");
                        }
                    }
                })  {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("Content-Type","application/json");
                params.put("Authorization", properties.getToken());

                return params;
            }
        };

        queue.add(request);
    }

    private String bin2hex(byte[] data) {
        return String.format("%0" + (data.length * 2) + "X", new BigInteger(1, data));
    }
}

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
import org.lenndi.umbono.util.LogTag;
import org.lenndi.umbono.util.Properties;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (nfcAdapter == null) {
            String noRfidMsg = "Votre appareil ne peut pas lire votre carte de bibliothèque";
            Toast.makeText(this, noRfidMsg, Toast.LENGTH_LONG).show();
        } else if (!nfcAdapter.isEnabled()) {
            String turnOnRfid =
                    "Veuillez activer le NFC de votre appareil avant d'utiliser l'application";
            Toast.makeText(this, turnOnRfid, Toast.LENGTH_LONG).show();
        }
      }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        final Properties properties = new Properties(this);

        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        String uid = this.bin2hex(tag.getId());
        properties.setUserUid(uid);

        //Toast.makeText(this, uid, Toast.LENGTH_LONG).show();

        String loansUrl = properties.getApiUrl() + "/users/" + properties.getUserUid() + "/loans";
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
                        Log.e(LogTag.API_TAG, "Can't get user's loans");
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

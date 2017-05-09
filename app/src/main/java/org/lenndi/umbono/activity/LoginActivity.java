package org.lenndi.umbono.activity;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.lenndi.umbono.R;
import org.lenndi.umbono.api.UmtapoRetrofit;
import org.lenndi.umbono.api.service.BorrowerApi;
import org.lenndi.umbono.entity.Borrower;
import org.lenndi.umbono.service.SessionService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private BorrowerApi borrowerApi;
    private SessionService sessionService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.borrowerApi = UmtapoRetrofit.getInstance().getBorrowerApi();
        this.sessionService = SessionService.getInstance();

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
        } else {
            //TODO: get a borrower using rfid card
            Call<Borrower> call = this.borrowerApi.getBorrower(1);

            call.enqueue(new Callback<Borrower>() {
                @Override
                public void onResponse(Call<Borrower> call, Response<Borrower> response) {
                    Borrower borrower = response.body();
                    sessionService.login(borrower);
                    startActivity(new Intent(LoginActivity.this, LoanActivity.class));
                }

                @Override
                public void onFailure(Call<Borrower> call, Throwable t) {
                    String failureMsg = "Oops… Votre carte n'est pas reconnue.";
                    Toast.makeText(LoginActivity.this, failureMsg, Toast.LENGTH_LONG).show();

                    Log.d("LOGIN_FAILURE", t.getMessage());
                }
            });
        }
      }

    @Override
    protected void onNewIntent(Intent intent) {
        Parcelable[] parcelables = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_TAG);
    }
}

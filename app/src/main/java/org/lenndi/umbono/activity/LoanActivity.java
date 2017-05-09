package org.lenndi.umbono.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.lenndi.umbono.R;
import org.lenndi.umbono.adapter.LoanAdapter;
import org.lenndi.umbono.api.UmtapoRetrofit;
import org.lenndi.umbono.api.service.LoanApi;
import org.lenndi.umbono.entity.Borrower;
import org.lenndi.umbono.entity.Loan;
import org.lenndi.umbono.service.SessionService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoanActivity extends AppCompatActivity {

    private SessionService sessionService;
    private LoanApi loanApi;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.sessionService = SessionService.getInstance();
        this.loanApi = UmtapoRetrofit.getInstance().getLoanApi();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        this.listView = (ListView) findViewById(R.id.loanList);

        Borrower borrower = this.sessionService.getConnectedBorrower();
        Call<List<Loan>> call = this.loanApi.getLoans(borrower.getId());

        call.enqueue(new Callback<List<Loan>>() {
            @Override
            public void onResponse(Call<List<Loan>> call, Response<List<Loan>> response) {
                List<Loan> loans = response.body();
                LoanAdapter loanAdapter = new LoanAdapter(LoanActivity.this, loans);
                listView.setAdapter(loanAdapter);

                if (loans.size() == 0) {
                    String msg = "Pas d'emprunts en cours";
                    Toast.makeText(LoanActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Loan>> call, Throwable t) {
                String failureMsg = "Oops… Nous n'avons pas reçus d'informations sur vos emprunts";
                Toast.makeText(LoanActivity.this, failureMsg, Toast.LENGTH_LONG).show();

                Log.d("LOAN_FAILURE", t.getMessage());
            }
        });
    }
}

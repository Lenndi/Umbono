package org.lenndi.umbono.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.lenndi.umbono.R;
import org.lenndi.umbono.adapter.LoanAdapter;
import org.lenndi.umbono.entity.Loan;

import java.lang.reflect.Type;
import java.util.List;

public class LoanActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        this.listView = (ListView) findViewById(R.id.loanList);

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Loan>>(){}.getType();
        List<Loan> loans = gson.fromJson(this.getIntent().getStringExtra("loans"), listType);

        LoanAdapter loanAdapter = new LoanAdapter(LoanActivity.this, loans);
        listView.setAdapter(loanAdapter);

        if (loans.size() == 0) {
            String msg = "Pas d'emprunts en cours";
            Toast.makeText(LoanActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        ListView listView = (ListView) findViewById(R.id.loanList);

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Loan>>(){}.getType();
        List<Loan> loans = gson.fromJson(this.getIntent().getStringExtra("loans"), listType);

        if (loans != null && loans.size() > 0) {
            LoanAdapter loanAdapter = new LoanAdapter(LoanActivity.this, loans);
            listView.setAdapter(loanAdapter);
        } else {
            Toast.makeText(LoanActivity.this, R.string.no_loan, Toast.LENGTH_SHORT).show();
        }
    }
}

package org.lenndi.umbono.api.service;

import org.lenndi.umbono.entity.Loan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoanApi {

    @GET("loans")
    Call<List<Loan>> getLoans(@Query("borrowerId") Integer borrowerId);
}

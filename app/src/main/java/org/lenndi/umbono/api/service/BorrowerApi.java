package org.lenndi.umbono.api.service;

import org.lenndi.umbono.entity.Borrower;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BorrowerApi {

    @GET("borrowers/{id}")
    Call<Borrower> getBorrower(@Path("id") Integer id);
}

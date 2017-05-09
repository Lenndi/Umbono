package org.lenndi.umbono.api;

import org.lenndi.umbono.api.service.BorrowerApi;
import org.lenndi.umbono.api.service.LoanApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UmtapoRetrofit {

    private static final UmtapoRetrofit ourInstance = new UmtapoRetrofit();

    public static UmtapoRetrofit getInstance() {
        return ourInstance;
    }

    private LoanApi loanService;
    private BorrowerApi borrowerApi;

    private UmtapoRetrofit() {
        this.loanService = this.getApi(LoanApi.class);
        this.borrowerApi = this.getApi(BorrowerApi.class);
    }

    public LoanApi getLoanApi() {
        return this.loanService;
    }

    public BorrowerApi getBorrowerApi() {
        return this.borrowerApi;
    }

    private <T> T getApi(Class<T> service) {
        return new Retrofit.Builder()
                .baseUrl("http://10.3.5.49:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(service);
    }
}

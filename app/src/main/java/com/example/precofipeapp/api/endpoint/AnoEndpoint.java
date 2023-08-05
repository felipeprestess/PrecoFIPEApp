package com.example.precofipeapp.api.endpoint;

import com.example.precofipeapp.api.model.Ano;
import com.example.precofipeapp.api.model.Modelos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnoEndpoint {

    @GET("carros/marcas/{codigo}/modelos/{codigo_modelo}/anos")
    Call<List<Ano>> getAnos(@Path("codigo") int codigo, @Path("codigo_modelo") int codigo_modelo);
}

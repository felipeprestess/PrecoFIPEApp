package com.example.precofipeapp.api.endpoint;

import com.example.precofipeapp.api.model.Marcas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarcasEndpoint {

    @GET("carros/marcas")
    Call<List<Marcas>> getMarcas();
}

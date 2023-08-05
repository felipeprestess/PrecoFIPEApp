package com.example.precofipeapp.api.endpoint;

import com.example.precofipeapp.api.model.Marcas;
import com.example.precofipeapp.api.model.Modelos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ModelosEndpoint {

    @GET("carros/marcas/{codigo}/modelos")
    Call<Modelos> getModelos(@Path("codigo") int codigo);
}

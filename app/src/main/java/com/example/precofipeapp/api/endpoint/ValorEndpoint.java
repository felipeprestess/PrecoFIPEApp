package com.example.precofipeapp.api.endpoint;

import com.example.precofipeapp.api.model.Modelos;
import com.example.precofipeapp.api.model.Valor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ValorEndpoint {

    @GET("carros/marcas/{codigo}/modelos/{codigo_modelo}/anos/{codigo_ano}")
    Call<Valor> getValor(@Path("codigo") int codigo, @Path("codigo_modelo") int codigo_modelo, @Path("codigo_ano") String codigo_ano);
}

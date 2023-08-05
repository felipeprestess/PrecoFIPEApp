package com.example.precofipeapp.api;

import com.example.precofipeapp.api.endpoint.AnoEndpoint;
import com.example.precofipeapp.api.endpoint.MarcasEndpoint;
import com.example.precofipeapp.api.endpoint.ModelosEndpoint;
import com.example.precofipeapp.api.endpoint.ValorEndpoint;
import com.example.precofipeapp.api.model.Ano;
import com.example.precofipeapp.api.model.Marcas;
import com.example.precofipeapp.api.model.Modelos;
import com.example.precofipeapp.api.model.Valor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static final String URL_ROOT = "https://parallelum.com.br/fipe/api/v1/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getMarcas(final Callback<List<Marcas>> callback) {
        MarcasEndpoint endpoint = retrofit.create(MarcasEndpoint.class);
        Call<List<Marcas>> call = endpoint.getMarcas();
        call.enqueue(callback);
    }

    public static void getModelos(int codigo, final Callback<Modelos> callback) {
        ModelosEndpoint endpoint = retrofit.create(ModelosEndpoint.class);
        Call<Modelos> call = endpoint.getModelos(codigo);
        call.enqueue(callback);
    }

    public static void getAnos(int codigo, int codigo_modelo, final Callback<List<Ano>> callback) {
        AnoEndpoint endpoint = retrofit.create(AnoEndpoint.class);
        Call<List<Ano>> call = endpoint.getAnos(codigo, codigo_modelo);
        call.enqueue(callback);
    }

    public static void getValor(int codigo, int codigo_modelo, String codigo_ano, final Callback<Valor> callback) {
        ValorEndpoint endpoint = retrofit.create(ValorEndpoint.class);
        Call<Valor> call = endpoint.getValor(codigo, codigo_modelo, codigo_ano);
        call.enqueue(callback);
    }
}

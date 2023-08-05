package com.example.precofipeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.precofipeapp.adapter.AnosAdapter
import com.example.precofipeapp.api.Api
import com.example.precofipeapp.api.model.Ano
import com.example.precofipeapp.api.model.Modelos
import com.example.precofipeapp.api.model.Valor
import com.example.precofipeapp.util.DialogUtil
import com.example.precofipeapp.util.KeyUtil
import retrofit2.Call
import retrofit2.Response

class AnosActivity: ComponentActivity() {
    lateinit var listaAnos: ListView
    lateinit var adapter: AnosAdapter
    var codigoMarca: Int = 0
    var codigoModelo: Int = 0
    var codigoAno: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anos_activity);

        val myAct: Activity = this
        listaAnos =  findViewById(R.id.listaAnos)
        listaAnos.setOnItemClickListener { parent, view, position, id ->
            run {

                codigoAno = ((adapter.getItem(position)) as Ano).getCodigo()
                Api.getValor(codigoMarca, codigoModelo, codigoAno, object: retrofit2.Callback<Valor> {
                    override fun onResponse(call: Call<Valor>?, response: Response<Valor>?) {
                        if (response != null) {
                            if(response.isSuccessful()){
                                DialogUtil.show("INFO", "Valor FIPE: "+response.body().valor, myAct)
                            } else {
                                DialogUtil.show("Erro", "Falha ao buscar o valor da FIPE", myAct)
                            }
                        }
                    }

                    override fun onFailure(call: Call<Valor>?, t: Throwable?) {
                        t?.printStackTrace()
                        DialogUtil.show("Erro", "Falha ao buscar o valor da FIPE", myAct)
                    }
                })
            }
        }

        Toast.makeText(this, "Buscando anos de veículos", Toast.LENGTH_LONG).show()
        val act = this
        codigoMarca =  getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0)
        codigoModelo = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MODELO, 0)

        Api.getAnos(codigoMarca, codigoModelo, object: retrofit2.Callback<List<Ano>> {
            override fun onResponse(
                call: Call<List<Ano>>?,
                response: Response<List<Ano>>?
            ){
                if (response != null) {
                    if (response.isSuccessful()) {
                        adapter = AnosAdapter(act, response.body())
                        listaAnos.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            override fun onFailure(call: Call<List<Ano>>?, t: Throwable?) {
                t?.printStackTrace()
                DialogUtil.show("Erro", "Falha ao buscar os anos", act)
            }
        })
    }
}
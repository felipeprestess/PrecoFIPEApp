package com.example.precofipeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.precofipeapp.adapter.MarcasAdapter
import com.example.precofipeapp.adapter.ModelosAdapter
import com.example.precofipeapp.api.Api
import com.example.precofipeapp.api.model.Marcas
import com.example.precofipeapp.api.model.Modelos
import com.example.precofipeapp.util.DialogUtil
import com.example.precofipeapp.util.KeyUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelosActivity: ComponentActivity() {
    lateinit var listaModelos: ListView
    lateinit var adapter: ModelosAdapter
    var codigoMarca: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modelos_activity);

        listaModelos =  findViewById(R.id.listaModelo)
        listaModelos.setOnItemClickListener { parent, view, position, id ->
            run {
                val it = Intent(this, AnosActivity::class.java)

                val codigo = (adapter.getItem(0)) as Modelos.Items
                it.putExtra(KeyUtil.KEY_CODIGO_MODELO, codigo.getCodigo())
                it.putExtra(KeyUtil.KEY_CODIGO_MARCA, codigoMarca)

                startActivity(it)
            }
        }

        Toast.makeText(this, "Buscando modelos de veículos", Toast.LENGTH_LONG).show()
        val act = this

        codigoMarca = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0)

        Api.getModelos(getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0), object: retrofit2.Callback<Modelos> {
            override fun onResponse(
                call: Call<Modelos>?,
                response: Response<Modelos>?
            ){
                if (response != null) {
                    if (response.isSuccessful()) {
                        adapter = ModelosAdapter(act, response.body().getModelos())
                        listaModelos.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            override fun onFailure(call: Call<Modelos>?, t: Throwable?) {
                t?.printStackTrace()
                DialogUtil.show("Erro", "Falha ao buscar os modelos", act)
            }
        })
    }
}
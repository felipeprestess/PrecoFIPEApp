package com.example.precofipeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.precofipeapp.adapter.MarcasAdapter
import com.example.precofipeapp.api.Api
import com.example.precofipeapp.api.model.Marcas
import com.example.precofipeapp.util.DialogUtil
import com.example.precofipeapp.util.KeyUtil
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList

class MainActivity : ComponentActivity() {
    lateinit var listaMarcas: ListView
    lateinit var adapter: MarcasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val act: Activity = this

        listaMarcas = findViewById(R.id.listaVeiculos)
        listaMarcas.setOnItemClickListener { parent, view, position, id ->
            run {
                val it = Intent(this, ModelosActivity::class.java)

                val codigo = (adapter.getItem(position )) as Marcas
                it.putExtra(KeyUtil.KEY_CODIGO_MARCA, codigo.getCodigo())
                startActivity(it)
            }
        }

        Toast.makeText(act, "Buscando marcas de veículoas", Toast.LENGTH_LONG).show()

        Api.getMarcas(object: retrofit2.Callback<MutableList<Marcas>> {
            override fun onResponse(
                call: Call<MutableList<Marcas>>?,
                response: Response<MutableList<Marcas>>?
            ) {
                if (response != null) {
                    if (response.isSuccessful()){
                        adapter = MarcasAdapter(act, response.body() as ArrayList<Marcas>?)
                        listaMarcas.setAdapter(adapter)
                        adapter.notifyDataSetChanged()

                    } else {
                        DialogUtil.show("Erro", "Falha ao buscar as marcas", act)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<Marcas>>?, t: Throwable?) {
                t?.printStackTrace()
                DialogUtil.show("Erro", "Falha ao buscar as marcas", act)
            }

        })
    }
}



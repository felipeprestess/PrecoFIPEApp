package com.example.precofipeapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import com.example.precofipeapp.adapter.VeiculoAdapter
import com.example.precofipeapp.model.Veiculo
import com.example.precofipeapp.util.DialogUtil

class MainActivity : ComponentActivity() {
    lateinit var listaVeiculos: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val arrayTst: ArrayList<Veiculo> = ArrayList()

        arrayTst.add(Veiculo("Audi", 2015))
        arrayTst.add(Veiculo("Audi", 2016))
        arrayTst.add(Veiculo("Audi", 2017))
        arrayTst.add(Veiculo("Audi", 2018))
        arrayTst.add(Veiculo("Audi", 2019))
        arrayTst.add(Veiculo("Audi", 2020))
        arrayTst.add(Veiculo("Audi", 2021))
        arrayTst.add(Veiculo("Audi", 2022))
        arrayTst.add(Veiculo("Corsa", 2015))
        arrayTst.add(Veiculo("BMW", 2020))
        arrayTst.add(Veiculo("BMW", 2021))
        arrayTst.add(Veiculo("BMW", 2022))
        arrayTst.add(Veiculo("Ferrari", 2017))
        arrayTst.add(Veiculo("Ferrari", 2018))
        arrayTst.add(Veiculo("Ferrari", 2019))
        arrayTst.add(Veiculo("Ferrari", 2020))

        val tmpScreen: Activity = this

        listaVeiculos = findViewById(R.id.listaVeiculos)
        listaVeiculos.setOnItemClickListener { parent, view, position, id -> DialogUtil.show("Informação", "Clicou no item " + position + " da lista", this)  }
        listaVeiculos.setAdapter(VeiculoAdapter(this,arrayTst))
    }
}


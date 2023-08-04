package com.example.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.precofipeapp.R;
import com.example.precofipeapp.model.Veiculo;

import java.util.ArrayList;

public class VeiculoAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Veiculo> arrayVeiculos;

    public VeiculoAdapter(final Activity activity, final ArrayList<Veiculo> array) {
        this.activity = activity;
        this.arrayVeiculos = array;
    }

    @Override
    public int getCount() {
        return arrayVeiculos.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayVeiculos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.item_lista_veiculo, parent, false);
        }

        TextView textVeiculo = convertView.findViewById(R.id.textVeiculo);
        textVeiculo.setText(arrayVeiculos.get(position).getNomeVeiculo());

        TextView textAnoFabricao = convertView.findViewById(R.id.textAnoFabricacao);
        textAnoFabricao.setText(""+arrayVeiculos.get(position).getAnoFabricacao());

        return convertView;
    }
}

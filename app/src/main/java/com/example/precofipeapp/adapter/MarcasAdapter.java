package com.example.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.precofipeapp.R;
import com.example.precofipeapp.api.model.Marcas;
import com.example.precofipeapp.model.Veiculo;

import java.util.ArrayList;

public class MarcasAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Marcas> arrayVeiculos;

    public MarcasAdapter(final Activity activity, final ArrayList<Marcas> array) {
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
            convertView = activity.getLayoutInflater().inflate(R.layout.item_lista, parent, false);
        }

        TextView textNome = convertView.findViewById(R.id.textNome);
        textNome.setText(arrayVeiculos.get(position).getNome());

        TextView textCodigo = convertView.findViewById(R.id.textCodigo);
        textCodigo.setText(""+arrayVeiculos.get(position).getCodigo());

        return convertView;
    }
}

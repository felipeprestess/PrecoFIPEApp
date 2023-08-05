package com.example.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.precofipeapp.R;
import com.example.precofipeapp.api.model.Marcas;
import com.example.precofipeapp.api.model.Modelos;

import java.util.ArrayList;
import java.util.List;

public class ModelosAdapter extends BaseAdapter {

    private Activity activity;
    private List<Modelos.Items> arrayModelos;

    public ModelosAdapter(final Activity activity, final List<Modelos.Items> array) {
        this.activity = activity;
        this.arrayModelos = array;
    }

    @Override
    public int getCount() {
        return arrayModelos.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayModelos.get(position);
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
        textNome.setText(arrayModelos.get(position).getNome());

        TextView textCodigo = convertView.findViewById(R.id.textCodigo);
        textCodigo.setText(""+arrayModelos.get(position).getCodigo());

        return convertView;
    }
}

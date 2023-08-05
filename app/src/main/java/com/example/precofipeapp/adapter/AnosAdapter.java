package com.example.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.precofipeapp.R;
import com.example.precofipeapp.api.model.Ano;
import com.example.precofipeapp.api.model.Marcas;

import java.util.ArrayList;
import java.util.List;

public class AnosAdapter extends BaseAdapter {

    private Activity activity;
    private List<Ano> arrayAnos;

    public AnosAdapter(final Activity activity, final List<Ano> arrayAnos) {
        this.activity = activity;
        this.arrayAnos = arrayAnos;
    }

    @Override
    public int getCount() {
        return arrayAnos.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayAnos.get(position);
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
        textNome.setText(arrayAnos.get(position).getNome());

        TextView textCodigo = convertView.findViewById(R.id.textCodigo);
        textCodigo.setText(""+arrayAnos.get(position).getCodigo());

        return convertView;
    }
}

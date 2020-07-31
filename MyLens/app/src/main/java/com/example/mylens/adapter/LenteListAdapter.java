package com.example.mylens.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mylens.R;
import com.example.mylens.model.Lente;

import java.util.List;

public class LenteListAdapter extends ArrayAdapter<Lente> {

    private Context context;
    private List<Lente> lentes;

    public LenteListAdapter(@NonNull Context context, int resource, @NonNull List<Lente> lentes) {
        super(context, resource, lentes);

        this.context = context;
        this.lentes = lentes;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Lente lente = lentes.get(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());


        convertView = inflater.inflate(R.layout.list_lente_item, parent, false);


        TextView txt_marca = convertView.findViewById(R.id.txt_marca);
        TextView txt_oe = convertView.findViewById(R.id.txt_oe);
        TextView txt_od = convertView.findViewById(R.id.txt_od);
        TextView txt_dval = convertView.findViewById(R.id.txt_dval);
        TextView txt_durou = convertView.findViewById(R.id.txt_durou);
        TextView txt_motivo = convertView.findViewById(R.id.txt_motivo);

        txt_marca.setText(lente.getMarca());
        txt_oe.setText(lente.getGrauOE());
        txt_od.setText(lente.getGrauOD());
        txt_dval.setText((String.valueOf(lente.getDiasValidade())));
        txt_durou.setText((String.valueOf(lente.getDiasDuracao())));
        txt_motivo.setText(lente.getMotivoTroca());


        return convertView;
    }


}

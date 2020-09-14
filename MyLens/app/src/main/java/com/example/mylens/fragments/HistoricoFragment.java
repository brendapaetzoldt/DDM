package com.example.mylens.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mylens.R;
import com.example.mylens.activities.Informacos_lentes;
import com.example.mylens.adapter.LenteListAdapter;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;

import java.util.ArrayList;
import java.util.List;

public class HistoricoFragment extends Fragment {

    private ListView listView;
    private Intent intent;


    public HistoricoFragment() {

    }


    private LenteDAO dao;
    private List<Lente> lentes;
    private List<Lente> lentesFiltradas = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historico, container, false);

        intent = new Intent(getActivity(), Informacos_lentes.class);

        listView = view.findViewById(R.id.list_lentes);
        dao = new LenteDAO(getActivity());
        lentes = dao.obterTodos();
        lentesFiltradas.addAll(lentes);

        LenteListAdapter adapter = new LenteListAdapter(getActivity().getApplicationContext(), 0, lentes);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        listView.setOnItemClickListener(listClick);


        return view;

    }

    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            String itemValue = String.valueOf(listView.getItemAtPosition(position));


            intent.putExtra("LENTE_SELECIONADA", itemValue);


            intent.putExtra("ID", lentes.get(position).getId());
            intent.putExtra("MARCA", lentes.get(position).getMarca());
            intent.putExtra("OD", lentes.get(position).getGrauOD());
            intent.putExtra("OE", lentes.get(position).getGrauOE());
            intent.putExtra("MOTIVO_TROCA", lentes.get(position).getMotivoTroca());
            intent.putExtra("DIAS_VALIDADE", lentes.get(position).getDiasValidade());
            intent.putExtra("DIAS_DURACAO", lentes.get(position).getDiasDuracao());


            //Toast.makeText(getContext(), "o id é" + id, Toast.LENGTH_SHORT).show();

            startActivity(intent);


        }
    };


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}



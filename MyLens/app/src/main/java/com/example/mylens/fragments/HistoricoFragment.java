package com.example.mylens.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mylens.R;
import com.example.mylens.adapter.LenteListAdapter;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;

import java.util.ArrayList;
import java.util.List;

public class HistoricoFragment extends Fragment {
    public HistoricoFragment() {
    }

    private LenteDAO dao;
    private List<Lente> lentes;
    private List<Lente> lentesFiltradas = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historico, container, false);

        ListView listView = view.findViewById(R.id.list_lentes);
        dao = new LenteDAO(getActivity());
        lentes = dao.obterTodos();
        lentesFiltradas.addAll(lentes);


        LenteListAdapter adapter = new LenteListAdapter(getActivity().getApplicationContext(), 0, lentes);

        listView.setAdapter(adapter);


        registerForContextMenu(listView);

        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}



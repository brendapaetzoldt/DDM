package com.example.mylens.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {


        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            String idValue = String.valueOf(listView.getItemIdAtPosition(position));
            intent.putExtra("ID", idValue);


            intent.putExtra("MARCA", lentes.get(position).getMarca());
            intent.putExtra("OD", lentes.get(position).getGrauOD());
            intent.putExtra("OE", lentes.get(position).getGrauOE());
            intent.putExtra("MOTIVO_TROCA", lentes.get(position).getMotivoTroca());
            intent.putExtra("DIAS_VALIDADE", lentes.get(position).getDiasValidade());
            intent.putExtra("DIAS_DURACAO", lentes.get(position).getDiasDuracao());


            String itemValue = String.valueOf(listView.getItemAtPosition(position));
            intent.putExtra("LENTE_SELECIONADA", itemValue);


//            Toast.makeText(getContext(), "" + itemValue, Toast.LENGTH_SHORT).show();

            //  startActivity(intent);


            verifica((int) id);

            final Lente lenteExcluir = lentesFiltradas.get(position);
            final Lente lenteAtualizar = lentesFiltradas.get(position);

//            Toast.makeText(getContext(), "Alteração realizada com sucesso" + lenteExcluir, Toast.LENGTH_SHORT).show();


            AlertDialog dialog = new AlertDialog.Builder(getContext()).setTitle("Atenção").setMessage("Deseja alterar ou excluir?")
                    .setNegativeButton("Alterar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            intent.putExtra("lente", lenteAtualizar);
                            startActivity(intent);

                        }
                    })
                    .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            lentesFiltradas.remove(lenteExcluir);
                            lentes.remove(lenteExcluir);
                            dao.excluir(lenteExcluir);
                            listView.invalidateViews();
                        }
                    }).create();
            dialog.show();


        }
    };

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


    public boolean verifica(int id) {
        for (Lente l : lentes) {
            if (l.getId() == id) {
                lentesFiltradas.add(l);
//                Toast.makeText(getActivity(), "its a match", Toast.LENGTH_SHORT).show();
                return true;

            }
        }
        return false;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}



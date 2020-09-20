package com.example.mylens.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mylens.R;
import com.example.mylens.adapter.LenteListAdapter;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;
import com.example.mylens.model.LenteUsada;

import java.util.List;

public class HomeFragment extends Fragment {

    private LenteDAO dao;
    private List<Lente> lentes;
    private List<LenteUsada> lentesUsar;

    public HomeFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        dao = new LenteDAO(getActivity());
        lentesUsar = dao.ObterUsar();
//       Lente l = new Lente();

        if (lentesUsar == null || lentesUsar.isEmpty()) {
            Toast.makeText(getActivity(), "Tá vazia", Toast.LENGTH_SHORT).show();
        } else {
            lentesUsar = dao.ObterUsar();
            Toast.makeText(getActivity(), "Tá cheia", Toast.LENGTH_SHORT).show();

        }

        LenteListAdapter adapter = new LenteListAdapter(getActivity().getApplicationContext(), 0, lentes);

        Toast.makeText(getContext(), "" + lentes, Toast.LENGTH_SHORT).show();

        TextView txt_oe_dias_restantes = view.findViewById(R.id.txt_oe_dias_restantes);
        //       txt_oe_dias_restantes.setText(message);

        TextView txt_od_dias_restantes = view.findViewById(R.id.txt_od_dias_restantes);
//        txt_od_dias_restantes.setText("333");


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView imageView = view.findViewById(R.id.img_case);
        imageView.setImageResource(R.drawable.estojo);


    }


}

package com.example.mylens.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mylens.R;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;

public class CadastroFragment extends Fragment {

    Button btn_cadastrar;
    EditText marca;
    EditText grauOD;
    EditText grauOE;
    //informada pela caixa/fabricante
    EditText diasValidade;
    //quantos dias realmente durou
    EditText diasDuracao;
    EditText motivoTroca;
    LenteDAO dao;


    public CadastroFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_lentes, container, false);

        marca = view.findViewById(R.id.edt_marca);
        grauOE = view.findViewById(R.id.edt_grauoe);
        grauOD = view.findViewById(R.id.edt_grauod);
        diasDuracao = view.findViewById(R.id.edt_dias_duracao);
        motivoTroca = view.findViewById(R.id.sp_motivo_troca);
        dao = new LenteDAO(getActivity());


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void salvar(View v) {
        btn_cadastrar = v.findViewById(R.id.btn_cadastrar);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lente l = new Lente();
                l.setMarca(marca.getText().toString());
                l.setGrauOE(grauOE.getText().toString());
                l.setGrauOD(grauOD.getText().toString());
                l.setDiasValidade(Integer.parseInt(diasDuracao.getText().toString()));
                l.setDiasDuracao(Integer.parseInt(diasDuracao.getText().toString()));
                l.setMotivoTroca(motivoTroca.getText().toString());
                long id = dao.inserir(l);
                Toast.makeText(getActivity(), "Sucesso" + id, Toast.LENGTH_SHORT).show();
                //        Toast.makeText(this, "Sucesso" + id, Toast.LENGTH_SHORT).show();

            }
        });

    }

}

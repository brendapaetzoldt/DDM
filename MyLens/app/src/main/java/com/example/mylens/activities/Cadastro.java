package com.example.mylens.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylens.R;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;

public class Cadastro extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        marca = findViewById(R.id.edt_marca);
        grauOE = findViewById(R.id.edt_grauoe);
        grauOD = findViewById(R.id.edt_grauod);
        diasValidade = findViewById(R.id.edt_dias_validade);
        diasDuracao = findViewById(R.id.edt_dias_duracao);
        motivoTroca = findViewById(R.id.sp_motivo_troca);
        dao = new LenteDAO(this);


    }


    public void salvar(View view) {
        Lente l = new Lente();
        l.setMarca(marca.getText().toString());
        l.setGrauOE(grauOE.getText().toString());
        l.setGrauOD(grauOD.getText().toString());
        l.setDiasValidade(Integer.parseInt(diasDuracao.getText().toString()));
        l.setDiasDuracao(Integer.parseInt(diasDuracao.getText().toString()));
        l.setMotivoTroca(motivoTroca.getText().toString());
        long id = dao.inserir(l);
        Toast.makeText(this, "Sucesso" + id, Toast.LENGTH_SHORT).show();
    }
}
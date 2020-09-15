package com.example.mylens.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylens.R;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;

public class Cadastro extends AppCompatActivity {

    Button button_cancelar;
    EditText marca;
    EditText grauOE;
    EditText grauOD;
    EditText diasValidade;
    EditText diasDuracao;
    EditText motivoTroca;
    LenteDAO dao;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        listView = findViewById(R.id.list_lentes);

        marca = findViewById(R.id.edt_marca);
        grauOE = findViewById(R.id.edt_grauoe);
        grauOD = findViewById(R.id.edt_grauod);
        diasValidade = findViewById(R.id.edt_dias_validade);
        diasDuracao = findViewById(R.id.edt_dias_duracao);
        motivoTroca = findViewById(R.id.edt_motivo_troca);
        dao = new LenteDAO(this);


    }


    public void salvar(View view) {
        Lente l = new Lente();
        l.setMarca(marca.getText().toString());
        l.setGrauOE(grauOE.getText().toString());
        l.setGrauOD(grauOD.getText().toString());
        l.setDiasValidade(Integer.parseInt(diasValidade.getText().toString()));
        l.setDiasDuracao(Integer.parseInt(diasDuracao.getText().toString()));
        l.setMotivoTroca(motivoTroca.getText().toString());
        long id = dao.inserir(l);
        Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Cadastro.this, MainActivity.class);
        startActivity(intent);
    }

    public void retorna(View view) {
        Intent intent = new Intent(Cadastro.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
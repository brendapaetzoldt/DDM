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
import com.example.mylens.fragments.HistoricoFragment;
import com.example.mylens.model.Lente;

import java.util.ArrayList;
import java.util.List;

public class Informacos_lentes extends AppCompatActivity {

    Button button_cancelar, btn_excluir, btn_cadastrar;
    private LenteDAO dao;
    private List<Lente> lentes;
    private List<Lente> lentesFiltradas = new ArrayList<>();
    EditText edt_marca;
    EditText edt_grauod;
    EditText edt_grauoe;
    //informada pela caixa/fabricante
    EditText edt_dias_validade;
    //quantos dias realmente durou
    EditText edt_dias_duracao;
    EditText edt_motivo_troca;
    private HistoricoFragment hf;
    private Lente lente = null;
    int defaultValue = -1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacos_lentes);
        dao = new LenteDAO(getApplicationContext());
        lentes = dao.obterTodos();

        listView = findViewById(R.id.list_lentes);


        Intent intent2 = getIntent();

        if (intent2.hasExtra("lente")) {
            lente = (Lente) intent2.getSerializableExtra("lente");
//            edt_marca.setText(lente.getMarca());
//            edt_grauod.setText(lente.getGrauOD());
//            edt_grauoe.setText(lente.getGrauOE());
//            edt_dias_validade.setText(lente.getDiasValidade());
//            edt_dias_duracao.setText(lente.getDiasDuracao());
//            edt_motivo_troca.setText(lente.getMotivoTroca());


        }


//        String marca = intent2.getStringExtra("MARCA");
//        String od = intent2.getStringExtra("OD");
//        String oe = intent2.getStringExtra("OE");
//        Integer dias_validade = intent2.getIntExtra("DIAS_VALIDADE", defaultValue);
//        Integer dias_duracao = intent2.getIntExtra("DIAS_DURACAO", defaultValue);
//        String motivo_troca = intent2.getStringExtra("MOTIVO_TROCA");


        edt_marca = findViewById(R.id.edt_marca);
        edt_grauod = findViewById(R.id.edt_grauod);
        edt_grauoe = findViewById(R.id.edt_grauoe);
        edt_dias_validade = findViewById(R.id.edt_dias_validade);
        edt_dias_duracao = findViewById(R.id.edt_dias_duracao);
        edt_motivo_troca = findViewById(R.id.edt_motivo_troca);


        edt_marca.setText(lente.getMarca());
        edt_grauod.setText(lente.getGrauOD());
        edt_grauoe.setText(lente.getGrauOE());
        edt_dias_validade.setText(String.valueOf(lente.getDiasValidade()));
        edt_dias_duracao.setText(String.valueOf(lente.getDiasDuracao()));
        edt_motivo_troca.setText(lente.getMotivoTroca());


    }


    public void Alterar(View view) {

        if (lente == null) {
            lente = new Lente();
            lente.setMarca(edt_marca.getText().toString());
            lente.setGrauOE(edt_grauoe.getText().toString());
            lente.setGrauOD(edt_grauod.getText().toString());
            lente.setDiasValidade(Integer.parseInt(edt_dias_validade.getText().toString()));
            lente.setDiasDuracao(Integer.parseInt(edt_dias_duracao.getText().toString()));
            lente.setMotivoTroca(edt_motivo_troca.getText().toString());
            long id = dao.inserir(lente);
            listView.invalidateViews();
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            lente.setMarca(edt_marca.getText().toString());
            lente.setGrauOE(edt_grauoe.getText().toString());
            lente.setGrauOD(edt_grauod.getText().toString());
            lente.setDiasValidade(Integer.parseInt(edt_dias_validade.getText().toString()));
            lente.setDiasDuracao(Integer.parseInt(edt_dias_duracao.getText().toString()));
            lente.setMotivoTroca(edt_motivo_troca.getText().toString());
            dao.atualizar(lente);
            listView.invalidateViews();
            Toast.makeText(this, "Alteração realizada com sucesso", Toast.LENGTH_SHORT).show();
        }

    }

    public void Excluir(View view) {
        lentes.remove(lente);
        dao.excluir(lente);
        listView.invalidateViews();
        Toast.makeText(this, "Excluído com sucesso", Toast.LENGTH_SHORT).show();

    }


    public void retorna(View view) {
        Intent intent = new Intent(Informacos_lentes.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
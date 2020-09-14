package com.example.mylens.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylens.R;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.Lente;

public class Informacos_lentes extends AppCompatActivity {

    Button button_cancelar;
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
        setContentView(R.layout.activity_informacos_lentes);

        Intent intent2 = getIntent();


        //  String mensagem = intent2.getStringExtra("LENTE_SELECIONADA");
        String marca = intent2.getStringExtra("MARCA");
        String od = intent2.getStringExtra("OD");
        String oe = intent2.getStringExtra("OE");
        String motivo_troca = intent2.getStringExtra("MOTIVO_TROCA");
        String dias_validade = intent2.getStringExtra("DIAS_VALIDADE");
        String dias_duracao = intent2.getStringExtra("DIAS_DURACAO");

        TextView edt_marca = findViewById(R.id.edt_marca);
        TextView edt_grauoe = findViewById(R.id.edt_grauoe);
        TextView edt_grauod = findViewById(R.id.edt_grauod);
        TextView edt_dias_validade = findViewById(R.id.edt_dias_validade);
        TextView edt_dias_duracao = findViewById(R.id.edt_dias_duracao);
        TextView edt_motivo_troca = findViewById(R.id.sp_motivo_troca);


        edt_marca.setText(marca);
        edt_grauod.setText(od);
        edt_grauoe.setText(oe);
        edt_dias_validade.setText(dias_validade);
        edt_dias_duracao.setText(dias_duracao);
        edt_motivo_troca.setText(motivo_troca);

    }

    public void Alterar(View view) {
        Lente l = new Lente();
        l.setMarca(marca.getText().toString());
        l.setGrauOE(grauOE.getText().toString());
        l.setGrauOD(grauOD.getText().toString());
        l.setDiasValidade(Integer.parseInt(diasDuracao.getText().toString()));
        l.setDiasDuracao(Integer.parseInt(diasDuracao.getText().toString()));
        l.setMotivoTroca(motivoTroca.getText().toString());
        long id = dao.inserir(l);
        Toast.makeText(this, "Alteração realizada com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void retorna(View view) {
        Intent intent = new Intent(Informacos_lentes.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
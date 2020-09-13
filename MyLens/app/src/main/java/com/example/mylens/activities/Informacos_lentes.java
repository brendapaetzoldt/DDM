package com.example.mylens.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylens.R;

public class Informacos_lentes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacos_lentes);

        Intent intent2 = getIntent();
        String mensagem = "A lente selecionada é:" + intent2.getStringExtra("LENTE_SELECIONADA");

//        Toast.makeText(this, "sucesso" + mensagem , Toast.LENGTH_SHORT).show();


        TextView edt_marca = findViewById(R.id.edt_marca);
        edt_marca.setText(mensagem);

    }
}
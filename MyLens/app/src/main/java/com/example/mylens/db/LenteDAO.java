package com.example.mylens.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mylens.model.Lente;

public class LenteDAO {

    private Conexao conecao;
    private SQLiteDatabase banco;

    public LenteDAO(Context context) {
        conecao = new Conexao(context);
        banco = conecao.getWritableDatabase();
    }

    public long inserir(Lente lente) {
        ContentValues values = new ContentValues();
        values.put("marca", lente.getMarca());
        values.put("grauOE", lente.getGrauOE());
        values.put("grauOD", lente.getGrauOD());
        values.put("diasValidade", lente.getDiasValidade());
        values.put("diasDuracao", lente.getDiasDuracao());
        values.put("motivoTroca", lente.getMotivoTroca());

        return banco.insert("lente", null, values);
    }
}

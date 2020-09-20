package com.example.mylens.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mylens.model.Lente;
import com.example.mylens.model.LenteUsada;

import java.util.ArrayList;
import java.util.List;

public class LenteDAO {

    private Conexao conecao;
    private SQLiteDatabase banco;

    public LenteDAO(Context context) {
        conecao = new Conexao(context);
        banco = conecao.getWritableDatabase();
    }

    public long usar(LenteUsada lenteUsada) {
        ContentValues values = new ContentValues();
        values.put("id", lenteUsada.getId());
        values.put("marca", lenteUsada.getMarca());
        values.put("grauOE", lenteUsada.getGrauOE());
        values.put("grauOD", lenteUsada.getGrauOD());
        values.put("diasValidade", lenteUsada.getDiasValidade());
        values.put("diasDuracao", lenteUsada.getDiasDuracao());
        values.put("motivoTroca", lenteUsada.getMotivoTroca());

        return banco.insert("usar", null, values);
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

    public List<Lente> obterTodos() {
        List<Lente> lentes = new ArrayList<>();
        Cursor cursor = banco.query("lente", new String[]{"id", "marca", "grauOE", "grauOD", "diasValidade", "diasDuracao", "motivoTroca"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Lente l = new Lente();
            l.setId(cursor.getInt(0));
            l.setMarca(cursor.getString(1));
            l.setGrauOE(cursor.getString(2));
            l.setGrauOD(cursor.getString(3));
            l.setDiasValidade(cursor.getInt(4));
            l.setDiasDuracao(cursor.getInt(5));
            l.setMotivoTroca(cursor.getString(6));

            lentes.add(l);
        }
        return lentes;

    }

    public void excluir(Lente l) {
        banco.delete("lente", "id=?", new String[]{l.getId() + ""});


    }

    public void excluirUsada(LenteUsada l) {
        banco.delete("usar", "id=?", new String[]{l.getId() + ""});


    }


    public void atualizar(Lente lente) {
        ContentValues values = new ContentValues();
        values.put("marca", lente.getMarca());
        values.put("grauOE", lente.getGrauOE());
        values.put("grauOD", lente.getGrauOD());
        values.put("diasValidade", lente.getDiasValidade());
        values.put("diasDuracao", lente.getDiasDuracao());
        values.put("motivoTroca", lente.getMotivoTroca());
        banco.update("lente", values, "id=?", new String[]{lente.getId().toString()});
    }

    public List<LenteUsada> ObterUsar() {
        List<LenteUsada> lentesUsar = new ArrayList<>();
        Cursor cursor = banco.query("usar", new String[]{"id", "marca", "grauOE", "grauOD", "diasValidade", "diasDuracao", "motivoTroca"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            LenteUsada l = new LenteUsada();
            l.setId(cursor.getInt(0));
            l.setMarca(cursor.getString(1));
            l.setGrauOE(cursor.getString(2));
            l.setGrauOD(cursor.getString(3));
            l.setDiasValidade(cursor.getInt(4));
            l.setDiasDuracao(cursor.getInt(5));
            l.setMotivoTroca(cursor.getString(6));

            lentesUsar.add(l);
        }
        return lentesUsar;

    }

}





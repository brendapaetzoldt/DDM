package com.example.mylens.model;

import java.io.Serializable;

public class Lente implements Serializable {

    private int id;
    private String marca;
    private Double grauOD;
    private Double grauOE;
    //informada pela caixa/fabricante
    private int diasValidade;
    //quantos dias realmente durou
    private int diasDuracao;
    private String motivoTroca;

    public Lente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getGrauOD() {
        return grauOD;
    }

    public void setGrauOD(Double grauOD) {
        this.grauOD = grauOD;
    }

    public Double getGrauOE() {
        return grauOE;
    }

    public void setGrauOE(Double grauOE) {
        this.grauOE = grauOE;
    }

    public int getDiasValidade() {
        return diasValidade;
    }

    public void setDiasValidade(int diasValidade) {
        this.diasValidade = diasValidade;
    }

    public int getDiasDuracao() {
        return diasDuracao;
    }

    public void setDiasDuracao(int diasDuracao) {
        this.diasDuracao = diasDuracao;
    }

    public String getMotivoTroca() {
        return motivoTroca;
    }

    public void setMotivoTroca(String motivoTroca) {
        this.motivoTroca = motivoTroca;
    }
}

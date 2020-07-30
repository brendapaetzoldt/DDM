package com.example.mylens.model;

public class Lente {


    private String marca;
    private double grauOD;
    private double grauOE;
    //informada pela caixa/fabricante
    private int diasValidade;
    //quantos dias realmente durou
    private int diasDuracao;
    private String motivoTroca;

    public Lente() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getGrauOD() {
        return grauOD;
    }

    public void setGrauOD(double grauOD) {
        this.grauOD = grauOD;
    }

    public double getGrauOE() {
        return grauOE;
    }

    public void setGrauOE(double grauOE) {
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

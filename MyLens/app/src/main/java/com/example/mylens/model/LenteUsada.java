package com.example.mylens.model;

public class LenteUsada {
    private Integer id;
    private String marca;
    private String grauOE;
    private String grauOD;
    //informada pela caixa/fabricante
    private Integer diasValidade;
    //quantos dias realmente durou
    private Integer diasDuracao;
    private String motivoTroca;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGrauOE() {
        return grauOE;
    }

    public void setGrauOE(String grauOE) {
        this.grauOE = grauOE;
    }

    public String getGrauOD() {
        return grauOD;
    }

    public void setGrauOD(String grauOD) {
        this.grauOD = grauOD;
    }

    public Integer getDiasValidade() {
        return diasValidade;
    }

    public void setDiasValidade(Integer diasValidade) {
        this.diasValidade = diasValidade;
    }

    public Integer getDiasDuracao() {
        return diasDuracao;
    }

    public void setDiasDuracao(Integer diasDuracao) {
        this.diasDuracao = diasDuracao;
    }

    public String getMotivoTroca() {
        return motivoTroca;
    }

    public void setMotivoTroca(String motivoTroca) {
        this.motivoTroca = motivoTroca;
    }

    @Override
    public String toString() {
        return "LenteUsada{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", grauOE='" + grauOE + '\'' +
                ", grauOD='" + grauOD + '\'' +
                ", diasValidade=" + diasValidade +
                ", diasDuracao=" + diasDuracao +
                ", motivoTroca='" + motivoTroca + '\'' +
                '}';
    }
}

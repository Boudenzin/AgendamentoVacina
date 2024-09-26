package br.ufpb.dcx.romildo.vacinacao;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data() {
        this(0,0,0);
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

}

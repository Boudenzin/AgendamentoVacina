package br.ufpb.dcx.romildo.vacinacao;

import br.ufpb.dcx.romildo.vacinacao.exceptions.DataNaoCadastradaException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return dia == data.dia && mes == data.mes && ano == data.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, ano);
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}

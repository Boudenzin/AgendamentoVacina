package br.ufpb.dcx.romildo.vacinacao;

import br.ufpb.dcx.romildo.vacinacao.exceptions.DataNaoCadastradaException;

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

    public Data(String data) throws DataNaoCadastradaException{
        try {
            String[] dataFormatada = data.split("/");
            this.dia = Integer.parseInt(dataFormatada[0]);
            this.mes = Integer.parseInt(dataFormatada[1]);
            this.ano = Integer.parseInt(dataFormatada[2]);
        } catch (NumberFormatException e) {
            throw new DataNaoCadastradaException("Data não foi inserida corretamente");
        }
    }
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}

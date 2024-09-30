package br.ufpb.dcx.romildo.vacinacao.exceptions;

public class VacinaNaoEncontradaException extends Exception {
    public VacinaNaoEncontradaException(String msg) {
        super(msg);
    }

    public VacinaNaoEncontradaException() {
        super("Vacina não foi encontrada no sistema");
    }
}

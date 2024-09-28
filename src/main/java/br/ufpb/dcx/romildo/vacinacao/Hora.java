package br.ufpb.dcx.romildo.vacinacao;

import br.ufpb.dcx.romildo.vacinacao.exceptions.HoraNaoCadastradaException;

import java.util.Objects;

public class Hora {

    private int hora;
    private int minutos;

    public Hora(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public Hora(String hora) throws HoraNaoCadastradaException {
        try {
            String[] horaFormatada = hora.split("/");
            this.hora = Integer.parseInt(horaFormatada[0]);
            this.minutos = Integer.parseInt(horaFormatada[1]);
        } catch (NumberFormatException e) {
            throw new HoraNaoCadastradaException("Hora não foi inserida corretamente");
        }
    }

    public Hora() {
        this(0,0);
    }

    public Hora(int hora) {
        this(hora, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hora hora1 = (Hora) o;
        return hora == hora1.hora && minutos == hora1.minutos;
    }

    @Override
    public int hashCode() {
        //todo: fazer o hashcode
        return Objects.hash(hora, minutos);
    }
}

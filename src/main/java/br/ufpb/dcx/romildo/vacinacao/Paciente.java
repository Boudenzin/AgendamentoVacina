package br.ufpb.dcx.romildo.vacinacao;

import br.ufpb.dcx.romildo.vacinacao.exceptions.VacinaNaoEncontradaException;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class Paciente {

    private String cartaoSUS;

    private String nome;

    private int idade;

    private List<Vacina> vacinas;

    public Paciente(String cartaoSUS, String nome, int idade) {

        this.cartaoSUS = cartaoSUS;
        this.nome = nome;
        this.idade = idade;
        this.vacinas = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        if (cartaoSUS.equals(paciente.getCartaoSUS())) return false;
        if (nome.equals(paciente.getNome())) return false;
        if (idade != paciente.getIdade()) return false;
        return idade == paciente.idade && Objects.equals(cartaoSUS, paciente.cartaoSUS) && Objects.equals(nome, paciente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartaoSUS, nome, idade);
    }

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void adicionarVacina(Vacina vacina) {
        this.vacinas.add(vacina);
    }

    public void removerVacina(Vacina vacina) throws VacinaNaoEncontradaException{
        if (!this.vacinas.contains(vacina)) {
            throw new VacinaNaoEncontradaException("Vacina não está no sistema");
        }
        this.vacinas.remove(vacina);
    }

    public void alterarDataDeVacina(Vacina vacina, Data data) throws VacinaNaoEncontradaException{
        if (!this.vacinas.contains(vacina)) {
            throw new VacinaNaoEncontradaException("Vacina não está no sistema");
        }
        for (Vacina v : this.vacinas) {
            if (v.equals(vacina)) {
                vacina.setData(data);
            }
        }
    }

    public void alterarVacina(Vacina vacinaAntiga, Vacina vacinaNova) throws VacinaNaoEncontradaException {
        if (!this.vacinas.contains(vacinaAntiga)) {
            throw new VacinaNaoEncontradaException("Vacina não está no sistema");
        }
        this.removerVacina(vacinaAntiga);
        this.adicionarVacina(vacinaNova);

    }


    public List<Vacina> getVacinas() {
        return this.vacinas;
    }


    public StringBuilder mostrarTodasAsVacinas() {
        StringBuilder saida = new StringBuilder();

        for(Vacina vacina : this.vacinas) {
            saida.append(vacina.toString()).append("\n");
        }

        return saida;
    }

    public Vacina pesquisarVacinaPeloTipoEDose(String tipo, int dose) throws VacinaNaoEncontradaException{
        for (Vacina v : this.vacinas) {
            if (v.getTipo().equals(TipoVacina.valueOf(tipo))) {
                return v;
            }
        }
        throw new VacinaNaoEncontradaException();

    }
    @Override
    public String toString() {
        return String.format("""
                As vacinas do paciente %s de cartão %s e de idade %02d são
                
                %s
                """, this.nome, this.cartaoSUS, this.idade, this.mostrarTodasAsVacinas());
    }

    public List<Vacina> vacinasDaData(Data data) throws VacinaNaoEncontradaException{
        if (vacinas == null) throw new VacinaNaoEncontradaException("Nenhuma vacina foi cadastrada ainda para esse paciente");
        List<Vacina> vacinasPesquisadas = new ArrayList<>();
        for (Vacina v : vacinas) {
            if (v.ehDaData(data)) {
                vacinasPesquisadas.add(v);
            }
        }
        return vacinasPesquisadas;
    }

    public List<Vacina> vacinasDaHora(Hora hora) throws VacinaNaoEncontradaException{
        if (vacinas == null) throw new VacinaNaoEncontradaException("Nenhuma vacina foi cadastrada ainda para esse paciente");
        List<Vacina> vacinasPesquisadas = new ArrayList<>();
        for (Vacina v : vacinas) {
            if (v.ehDaHora(hora)) {
                vacinasPesquisadas.add(v);
            }
        }
        return vacinasPesquisadas;
    }


}

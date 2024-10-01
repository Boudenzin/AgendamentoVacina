package br.ufpb.dcx.romildo.vacinacao;

import br.ufpb.dcx.romildo.vacinacao.exceptions.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class AgendamentoVacinaUBSPrimavera implements AgendamentoVacinaInterface {

    private Map<String, Paciente> pacientes;

    private final Map<String, TipoVacina> dicionarioTipo = new HashMap<>();

    public AgendamentoVacinaUBSPrimavera() {
        this.pacientes = new HashMap<>();
        dicionarioTipo.put("1", TipoVacina.POLIOMIELITE);
        dicionarioTipo.put("2", TipoVacina.INFLUENZA);
        dicionarioTipo.put("3", TipoVacina.DTP);
        dicionarioTipo.put("4", TipoVacina.HPV);
    }

    public void cadastrarPaciente(String cartaoSUS, Paciente paciente) throws PacienteJaCadastradoException {
        if (pacientes.containsKey(cartaoSUS)) {
            throw new PacienteJaCadastradoException("br.ufpb.dcx.romildo.vacinacao.Paciente já cadastrado");
        }
        pacientes.put(cartaoSUS, paciente);

    }

    public void agendarVacina(String cartaoSUS, Vacina vacina) throws PacienteNaoEncontradoException {
        try {
            Paciente p = pesquisarPaciente(cartaoSUS);
            p.adicionarVacina(vacina);
        } catch (PacienteNaoEncontradoException e) {
            throw new PacienteNaoEncontradoException(e.getMessage());
        }
    }


    public void removerVacinaDePaciente(String cartaoSUS, Vacina vacina) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);
        try {
            p.removerVacina(vacina);
        } catch (VacinaNaoEncontradaException e) {
            throw new VacinaNaoEncontradaException(e.getMessage());
        }
    }

    public void alterarDataDeVacinaDoPaciente(String cartaoSUS, String tipo, int dose, Data data, Hora hora) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);

        try {
            TipoVacina tipoFormatado = dicionarioTipo.get(tipo);
            Vacina vacina = p.pesquisarVacinaPeloTipoEDose(tipoFormatado, dose);
            p.alterarDataDeVacina(vacina, data);
        } catch (VacinaNaoEncontradaException e) {
            throw new VacinaNaoEncontradaException(e.getMessage());
        }
    }


    public void alterarVacinaDePaciente(String cartaoSUS, Vacina vacinaAntiga, Vacina vacinaNova) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);
        try {
            p.alterarVacina(vacinaAntiga, vacinaNova);
        } catch (VacinaNaoEncontradaException e) {
            throw new VacinaNaoEncontradaException(e.getMessage());
        }
    }

    public void removerPacienteDoSistema(String cartaoSUS) throws PacienteNaoEncontradoException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        this.pacientes.remove(cartaoSUS);
    }

    public Paciente pesquisarPaciente(String cartaoSUS) throws PacienteNaoEncontradoException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        return pacientes.get(cartaoSUS);
    }

    public List<Vacina> pesquisarDataAgendada(String cartaoSUS, String data) {
        try {
            Data dataNova = dataFormatada(data);
            Paciente p = pesquisarPaciente(cartaoSUS);
            return p.vacinasDaData(dataNova);
        } catch (PacienteNaoEncontradoException | VacinaNaoEncontradaException | DataNaoCadastradaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Vacina> pesquisarHoraAgendada(String cartaoSUS, String hora) {
        try {
            Hora horaNova = horaFormatada(hora);
            Paciente p = pesquisarPaciente(cartaoSUS);
            return p.vacinasDaHora(horaNova);
        } catch (PacienteNaoEncontradoException | VacinaNaoEncontradaException | HoraNaoCadastradaException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    public List<Vacina> pesquisarTodasAsVacinasDoPaciente(String cartaoSUS) throws PacienteNaoEncontradoException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);
        return p.getVacinas();
        //TODO: REFATORAR COM O TOSTRING DE PACIENTE
    }

    public Vacina pesquisarVacinaPeloTipoEDose(String cartaoSUS, String tipo, int dose) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);

        try {
            TipoVacina tipoFormatado = dicionarioTipo.get(tipo);
            return p.pesquisarVacinaPeloTipoEDose(tipoFormatado, dose);
        } catch (VacinaNaoEncontradaException e) {
            throw new VacinaNaoEncontradaException(e.getMessage());
        }
    }

    public StringBuilder exibirToStringsDasVacinas(List<Vacina> vacinas) {
        StringBuilder saida = new StringBuilder();
        for (Vacina v : vacinas) {
            saida.append(v.toString()).append("\n");
        }
        return saida;
    }

    public Data dataFormatada(String data) throws DataNaoCadastradaException {
        try {
            String[] dataFormatada = data.split("/");
            int dia = Integer.parseInt(dataFormatada[0]);
            int mes = Integer.parseInt(dataFormatada[1]);
            int ano = Integer.parseInt(dataFormatada[2]);
            Data dataNova = new Data(dia, mes, ano);
            return dataNova;
        } catch (NumberFormatException e) {
            throw new DataNaoCadastradaException("Data não foi inserida corretamente");
        }
    }

    public Hora horaFormatada(String horaVelha) throws HoraNaoCadastradaException {
        try {
            String[] horaFormatada = horaVelha.split(":");
            int hora = Integer.parseInt(horaFormatada[0]);
            int minutos = Integer.parseInt(horaFormatada[1]);
            Hora horaNova = new Hora(hora, minutos);
            return horaNova;
        } catch (NumberFormatException e) {
            throw new HoraNaoCadastradaException("Hora não foi inserida corretamente");
        }
    }

    public Paciente pacienteBuilder(String cartaoSUS, String nome, int idade) {
        return new Paciente(cartaoSUS, nome, idade);
    }

    public Vacina vacinaBuilder(String tipo, int dose, Data data, Hora hora) throws VacinaNaoEncontradaException {
        if (!dicionarioTipo.containsKey(tipo)) {
            throw new VacinaNaoEncontradaException();
        }
        TipoVacina tipoFormatado = dicionarioTipo.get(tipo);

        return new Vacina(tipoFormatado, dose, data, hora);
    }
}
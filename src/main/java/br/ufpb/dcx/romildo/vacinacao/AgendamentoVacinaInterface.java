package br.ufpb.dcx.romildo.vacinacao;

import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteJaCadastradoException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteNaoEncontradoException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.VacinaNaoEncontradaException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface AgendamentoVacinaInterface {

    public void cadastrarPaciente(String cartaoSUS, Paciente paciente) throws PacienteJaCadastradoException;

    public void agendarVacina(String cartaoSUS, Vacina vacina) throws PacienteNaoEncontradoException;

    public void removerVacinaDePaciente(String cartaoSUS, Vacina vacina) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException;

    public void alterarDataDeVacinaDoPaciente(String cartaoSUS, String tipo, int dose, Data data, Hora hora) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException;

    public void alterarVacinaDePaciente(String cartaoSUS, Vacina vacinaAntiga, Vacina vacinaNova) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException;

    public void removerPacienteDoSistema(String cartaoSUS) throws PacienteNaoEncontradoException;

    public Paciente pesquisarPaciente(String cartaoSUS) throws PacienteNaoEncontradoException;

    public List<Vacina> pesquisarDataAgendada(String cartaoSUS, String data);

    public List<Vacina> pesquisarTodasAsVacinasDoPaciente(String cartaoSUS) throws PacienteNaoEncontradoException;


}

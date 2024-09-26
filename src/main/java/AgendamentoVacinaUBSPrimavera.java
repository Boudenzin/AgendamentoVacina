import exceptions.PacienteJaCadastradoException;
import exceptions.PacienteNaoEncontradoException;
import exceptions.VacinaNaoEncontradaException;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class AgendamentoVacinaUBSPrimavera implements AgendamentoVacinaInterface{

    private Map<String, Paciente> pacientes;

    public AgendamentoVacinaUBSPrimavera() {
        this.pacientes = new HashMap<>();
    }

    public void cadastrarPaciente(String cartaoSUS, Paciente paciente) throws PacienteJaCadastradoException {
        if (pacientes.containsKey(cartaoSUS)) {
            throw new PacienteJaCadastradoException("Paciente já cadastrado");
        }
        pacientes.put(cartaoSUS, paciente);

    }

    public void agendarVacina(String cartaoSUS, Vacina vacina) throws PacienteNaoEncontradoException {
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);
        p.adicionarVacina(vacina);
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

    public void alterarDataDeVacinaDoPaciente(String cartaoSUS, Vacina vacina, Data data, Hora hora) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException{
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);
        try {
            p.alterarDataDeVacina(vacina, data);
        } catch (VacinaNaoEncontradaException e) {
            throw new VacinaNaoEncontradaException(e.getMessage());
        }
    }


    public void alterarVacinaDePaciente(String cartaoSUS, Vacina vacinaAntiga, Vacina vacinaNova) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException{
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

    public void removerPacienteDoSistema(String cartaoSUS) throws PacienteNaoEncontradoException{
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        this.pacientes.remove(cartaoSUS);
    }

    public Paciente pesquisarPaciente(String cartaoSUS) {
        return pacientes.get(cartaoSUS);
    }
    public Data pesquisarDataAgendada(String cartaoSUS, Vacina vacina, Data data) throws PacienteNaoEncontradoException, VacinaNaoEncontradaException{
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);
        try {
            return p.pesquisarDataDaVacina(vacina);
        } catch (VacinaNaoEncontradaException e) {
            throw new VacinaNaoEncontradaException(e.getMessage());
        }
    }


    public List<Vacina> pesquisarTodasAsVacinasDoPaciente(String cartaoSUS) throws PacienteNaoEncontradoException{
        if (!pacientes.containsKey(cartaoSUS)) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pesquisarPaciente(cartaoSUS);
        return p.getVacinas();
    }

}
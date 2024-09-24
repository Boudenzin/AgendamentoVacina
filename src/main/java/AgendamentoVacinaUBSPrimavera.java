import exceptions.PacienteJaCadastradoException;
import exceptions.PacienteNaoEncontradoException;

import java.util.Map;
import java.util.HashMap;

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

    public void cadastrarVacina(Paciente paciente, Vacina vacina) throws PacienteNaoEncontradoException {
        if (!pacientes.containsKey(paciente.getCartaoSUS())) {
            throw new PacienteNaoEncontradoException("Paciente não pode ser encontrado");
        }
        Paciente p = pacientes.get(paciente.getCartaoSUS());
        p.adicionarVacina(vacina);
    }
    public boolean agendarVacina(Paciente paciente, Vacina vacina) { return false; //TODO

    }

    public Paciente pesquisarPaciente(Paciente paciente) {
        return null; //TODO
    }
    public Vacina pesquisarTipoVacina(TipoVacina tipo) {
        return null; //TODO
    }
    public Data pesquisarDataAgendada(Paciente paciente, Vacina vacina) {
        return null; //TODO
    }


    public boolean removerVacinaDePaciente(Paciente paciente, Vacina vacina) {
        return false; //TODO
    }


    public boolean alterarDataDeVacinaDoPaciente(Paciente paciente, Vacina vacina) {
        return false; //TODO
    }

    public boolean alterarVacinaDePaciente(Paciente paciente, Vacina vacina) {
        return false; //TODO
    }

    public boolean removerPacienteDoSistema(Paciente paciente) {
        return false; //TODO
    }

    public Vacina[] pesquisarTodasAsVacinasDoPaciente(Paciente paciente) {
        return null; //TODO
    }
}

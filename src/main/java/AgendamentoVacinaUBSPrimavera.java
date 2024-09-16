import java.util.Map;
public class AgendamentoVacinaUBSPrimavera implements AgendamentoVacinaInterface{

    private Map<Paciente, Vacina[]> agenda;

    //fazer um builder pattern para colocar paciente, vacina, data, hora

    public boolean agendarVacina(Paciente paciente, Vacina vacina) {
        return false; //TODO
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

import java.util.Map;
public class AgendamentoVacinaUBSPrimavera implements AgendamentoVacinaInterface{

    private Map<Paciente, Vacina[]> agenda;

    //fazer um builder pattern para colocar paciente, vacina, data, hora

    public boolean agendarVacina(Paciente paciente, Vacina vacina) {}

    public Paciente pesquisarPaciente(Paciente paciente) {}
    public Vacina pesquisarTipoVacina(TipoVacina tipo) {}
    public Data pesquisarDataAgendada(Paciente paciente, Vacina vacina) {}


    public boolean removerVacinaDePaciente(Paciente paciente, Vacina vacina) {}


    public boolean alterarDataDeVacinaDoPaciente(Paciente paciente, Vacina vacina) {}

    public boolean alterarVacinaDePaciente(Paciente paciente, Vacina vacina) {}

    public boolean removerPacienteDoSistema(Paciente paciente) {}

    public Vacina[] pesquisarTodasAsVacinasDoPaciente(Paciente paciente) {}
}

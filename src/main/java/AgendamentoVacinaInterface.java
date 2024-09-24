import exceptions.PacienteJaCadastradoException;
import exceptions.PacienteNaoEncontradoException;

public interface AgendamentoVacinaInterface {

    public void cadastrarPaciente(String cartaoSUS, Paciente paciente) throws PacienteJaCadastradoException;

    public void cadastrarVacina(Paciente paciente, Vacina vacina) throws PacienteNaoEncontradoException;
    public boolean agendarVacina(Paciente paciente, Vacina vacina);

    public boolean removerVacinaDePaciente(Paciente paciente, Vacina vacina);

    public boolean alterarDataDeVacinaDoPaciente(Paciente paciente, Vacina vacina);

    public boolean alterarVacinaDePaciente(Paciente paciente, Vacina vacina);

    public boolean removerPacienteDoSistema(Paciente paciente);

    public Paciente pesquisarPaciente(Paciente paciente);
    public Vacina pesquisarTipoVacina(TipoVacina tipo);
    public Data pesquisarDataAgendada(Paciente paciente, Vacina vacina);

    public Vacina[] pesquisarTodasAsVacinasDoPaciente(Paciente paciente);


}

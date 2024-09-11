public interface AgendamentoVacinaInterface {

    public boolean cadastrarPaciente(Paciente paciente);
    public boolean cadastrarVacina(Vacina vacina);
    public boolean cadastrarData(Data data);

    public Paciente pesquisarPaciente(Paciente paciente);
    public Vacina pesquisarTipoVacina(TipoVacina tipo);
    public Data pesquisarDataAgendada(Paciente paciente, Vacina vacina);

    public boolean removerPaciente(Paciente paciente);
    public boolean removerVacinaDePaciente(Paciente paciente, Vacina vacina);
    public boolean alterarDataAgendada(Paciente paciente, Vacina vacina);
}

package br.ufpb.dcx.romildo.vacinacao.controllers;

import br.ufpb.dcx.romildo.vacinacao.*;
import br.ufpb.dcx.romildo.vacinacao.exceptions.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarDataController implements ActionListener {

    private AgendamentoVacinaInterface sistema;
    private JFrame janelaPrincipal;
    public AlterarDataController(AgendamentoVacinaInterface sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do aniversariante?", "Alterar Data", JOptionPane.INFORMATION_MESSAGE);
            Paciente paciente = sistema.pesquisarPaciente(cartaoSUS);

            String tipo = JOptionPane.showInputDialog(janelaPrincipal, "Digite o tipo que quer alterar \n" + paciente.toString(), "Alterar Data", JOptionPane.INFORMATION_MESSAGE);
            int dose = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite a dose da vacina " + tipo + "que quer alterar \n" + paciente.toString(), "Agendar Data", JOptionPane.INFORMATION_MESSAGE));

            String data = JOptionPane.showInputDialog(janelaPrincipal, "Qual a data que a vacina será agendada? \n Por favor, digite no formato: DD/MM/AAAA", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
            String hora = JOptionPane.showInputDialog(janelaPrincipal, "Qual a hora a ser escolhida?  Por favor, digite no formato: hora:min", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);

            Data dataFormatada = new Data(data);
            Hora horaFormtada = new Hora(hora);

            sistema.alterarDataDeVacinaDoPaciente(cartaoSUS, tipo, dose, dataFormatada, horaFormtada);


            JOptionPane.showMessageDialog(janelaPrincipal, "Data Alterada com Sucesso", "Alterar Data", JOptionPane.INFORMATION_MESSAGE);

        } catch (VacinaNaoEncontradaException | DataNaoCadastradaException | HoraNaoCadastradaException |
                 IllegalArgumentException | PacienteNaoEncontradoException exception) {
        JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
        exception.printStackTrace();
        System.err.println(exception.getMessage());
    }

}
}

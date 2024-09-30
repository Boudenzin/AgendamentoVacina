package br.ufpb.dcx.romildo.vacinacao.controllers;

import br.ufpb.dcx.romildo.vacinacao.*;
import br.ufpb.dcx.romildo.vacinacao.exceptions.DataNaoCadastradaException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.HoraNaoCadastradaException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteNaoEncontradoException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.VacinaNaoEncontradaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarVacinaController implements ActionListener {
    private AgendamentoVacinaUBSPrimavera sistema;
    private JFrame janelaPrincipal;

    public AlterarVacinaController(AgendamentoVacinaUBSPrimavera sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cartão do SUS do paciente?", "Alterar Vacina", JOptionPane.INFORMATION_MESSAGE);
            Paciente paciente = sistema.pesquisarPaciente(cartaoSUS);

            String tipo = JOptionPane.showInputDialog(janelaPrincipal, "Digite o tipo que quer alterar \n" + paciente.toString(), "Alterar Vacina", JOptionPane.INFORMATION_MESSAGE);
            int dose = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite a dose da vacina " + tipo + "que quer alterar \n" + paciente.toString(), "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE));
            Vacina vacinaAntiga = sistema.pesquisarVacinaPeloTipoEDose(cartaoSUS, tipo, dose);

            String tipoNovo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o tipo da Vacina que está no estoque? \n 1.Poliomielite \n 2.Influenza \n 3.DTP \n HPV", "Alterar Vacina", JOptionPane.INFORMATION_MESSAGE);
            int doseNova = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a dose? \n Por favor digite apenas números", "Alterar Vacina", JOptionPane.INFORMATION_MESSAGE));
            String dataNova = JOptionPane.showInputDialog(janelaPrincipal, "Qual a data que a vacina será agendada? \n Por favor, digite no formato: DD/MM/AAAA", "Alterar Vacina", JOptionPane.INFORMATION_MESSAGE);
            String horaNova = JOptionPane.showInputDialog(janelaPrincipal, "Qual a hora a ser escolhida?  Por favor, digite no formato: hora:min", "Alterar Vacina", JOptionPane.INFORMATION_MESSAGE);

            Data dataFormatada = sistema.dataFormatada(dataNova);
            Hora horaFormatada = sistema.horaFormatada(horaNova);

            Vacina vacinaNova = sistema.vacinaBuilder(tipoNovo, doseNova, dataFormatada, horaFormatada);

            sistema.alterarVacinaDePaciente(cartaoSUS, vacinaAntiga, vacinaNova);
            sistema.alterarDataDeVacinaDoPaciente(cartaoSUS, tipo, dose, dataFormatada, horaFormatada);


            JOptionPane.showMessageDialog(janelaPrincipal, "Vacina Alterada com Sucesso", "Alterar Vacina", JOptionPane.INFORMATION_MESSAGE);

        } catch (VacinaNaoEncontradaException | DataNaoCadastradaException | HoraNaoCadastradaException |
                 IllegalArgumentException | PacienteNaoEncontradoException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());
        }
    }
}

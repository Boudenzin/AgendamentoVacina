package br.ufpb.dcx.romildo.vacinacao.controllers;

import br.ufpb.dcx.romildo.vacinacao.AgendamentoVacinaUBSPrimavera;
import br.ufpb.dcx.romildo.vacinacao.Vacina;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;

public class PesquisarHorarioController implements ActionListener {

    private AgendamentoVacinaUBSPrimavera sistema;
    private JFrame janelaPrincipal;

    public PesquisarHorarioController(AgendamentoVacinaUBSPrimavera sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cartão do SUS do paciente?", "Pesquisar Vacina por Hora", JOptionPane.INFORMATION_MESSAGE);
            String hora = JOptionPane.showInputDialog(janelaPrincipal, "Qual a hora a ser procurada? \n Por favor, digite no formato: hh:mm", "Pesquisar Vacina por Hora", JOptionPane.INFORMATION_MESSAGE);

            List<Vacina> vacinasEncontradas = sistema.pesquisarHoraAgendada(cartaoSUS, hora);
            StringBuilder saida = sistema.exibirToStringsDasVacinas(vacinasEncontradas);

            JOptionPane.showMessageDialog(janelaPrincipal, "O paciente procurado tem as seguintes vacinas: \n" + saida, "Pesquisar Vacinas do Paciente pela Hora", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());

        }
    }
}

package br.ufpb.dcx.romildo.vacinacao.controllers;

import br.ufpb.dcx.romildo.vacinacao.AgendamentoVacinaUBSPrimavera;
import br.ufpb.dcx.romildo.vacinacao.Paciente;
import br.ufpb.dcx.romildo.vacinacao.Vacina;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteNaoEncontradoException;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MostrarVacinasController implements ActionListener{

    private AgendamentoVacinaUBSPrimavera sistema;
    private JFrame janelaPrincipal;

    public MostrarVacinasController(AgendamentoVacinaUBSPrimavera sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cartão do SUS do paciente?", "Exibir as Vacinas do Paciente", JOptionPane.INFORMATION_MESSAGE);
            Paciente paciente = sistema.pesquisarPaciente(cartaoSUS);
            JOptionPane.showMessageDialog(janelaPrincipal, paciente.toString(), "Exibir as Vacinas do Paciente", JOptionPane.INFORMATION_MESSAGE);
        } catch (PacienteNaoEncontradoException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());
        }
    }
}

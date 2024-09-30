package br.ufpb.dcx.romildo.vacinacao.controllers;

import br.ufpb.dcx.romildo.vacinacao.AgendamentoVacinaUBSPrimavera;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteNaoEncontradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverPacienteController implements ActionListener {

    private AgendamentoVacinaUBSPrimavera sistema;
    private JFrame janelaPrincipal;
    public RemoverPacienteController(AgendamentoVacinaUBSPrimavera sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cartão do SUS do paciente?", "Remover Paciente", JOptionPane.INFORMATION_MESSAGE);
            sistema.removerPacienteDoSistema(cartaoSUS);
            JOptionPane.showMessageDialog(janelaPrincipal, "Paciente Removido com Sucesso!", "Remover Paciente", JOptionPane.INFORMATION_MESSAGE);
        } catch (PacienteNaoEncontradoException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());
        }
    }
}



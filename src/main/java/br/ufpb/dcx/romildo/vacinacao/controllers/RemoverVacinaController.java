package br.ufpb.dcx.romildo.vacinacao.controllers;

import br.ufpb.dcx.romildo.vacinacao.AgendamentoVacinaUBSPrimavera;
import br.ufpb.dcx.romildo.vacinacao.Paciente;
import br.ufpb.dcx.romildo.vacinacao.Vacina;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteNaoEncontradoException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.VacinaNaoEncontradaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverVacinaController implements ActionListener {

    private AgendamentoVacinaUBSPrimavera sistema;
    private JFrame janelaPrincipal;
    public RemoverVacinaController(AgendamentoVacinaUBSPrimavera sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cartão do SUS do paciente?", "Remover Vacina", JOptionPane.INFORMATION_MESSAGE);
            Paciente paciente = sistema.pesquisarPaciente(cartaoSUS);

            String tipo = JOptionPane.showInputDialog(janelaPrincipal, "Digite o tipo que quer alterar \n" + paciente.toString(), "Remover Vacina", JOptionPane.INFORMATION_MESSAGE);
            int dose = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite a dose da vacina " + tipo + "que quer alterar \n" + paciente.toString(), "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE));
            Vacina vacina = sistema.pesquisarVacinaPeloTipoEDose(cartaoSUS, tipo, dose);


            sistema.removerVacinaDePaciente(cartaoSUS, vacina);
            JOptionPane.showMessageDialog(janelaPrincipal, "Vacina Removida com Sucesso!", "Remover Vacina", JOptionPane.INFORMATION_MESSAGE);
        } catch (PacienteNaoEncontradoException | VacinaNaoEncontradaException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());
        }
    }
}

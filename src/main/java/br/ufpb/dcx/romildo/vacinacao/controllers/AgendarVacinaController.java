package br.ufpb.dcx.romildo.vacinacao.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import br.ufpb.dcx.romildo.vacinacao.*;
import br.ufpb.dcx.romildo.vacinacao.exceptions.*;

import javax.swing.*;

public class AgendarVacinaController implements ActionListener {
    private AgendamentoVacinaUBSPrimavera sistema;
    private JFrame janelaPrincipal;


    public AgendarVacinaController(AgendamentoVacinaUBSPrimavera sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cartão do SUS do paciente?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE);
            String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do paciente?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE);
            int idade = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a idade do paciente?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE));

            String tipo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o tipo da Vacina que está no estoque? Digite apenas o número \n 1.Poliomielite \n 2.Influenza \n 3.DTP \n HPV", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
            int dose = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a dose? \n Por favor digite apenas números", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE));
            String data = JOptionPane.showInputDialog(janelaPrincipal, "Qual a data que a vacina será agendada? \n Por favor, digite no formato: DD/MM/AAAA", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
            String hora = JOptionPane.showInputDialog(janelaPrincipal, "Qual a hora a ser escolhida?  Por favor, digite no formato: hh:mm", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);



            Paciente paciente = sistema.pacienteBuilder(cartaoSUS, nome, idade);
            sistema.cadastrarPaciente(cartaoSUS, paciente);
            Data dataFormatada = sistema.dataFormatada(data);
            Hora horaFormatada = sistema.horaFormatada(hora);
            Vacina vacina = sistema.vacinaBuilder(tipo, dose, dataFormatada, horaFormatada);
            sistema.agendarVacina(cartaoSUS, vacina);

            JOptionPane.showMessageDialog(janelaPrincipal, "Paciente e Vacinas Agendadas com Sucesso", "Agendar Vacinas", JOptionPane.INFORMATION_MESSAGE);

        } catch (PacienteJaCadastradoException | DataNaoCadastradaException | HoraNaoCadastradaException |
                 IllegalArgumentException | PacienteNaoEncontradoException | VacinaNaoEncontradaException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());
        }


    }
}

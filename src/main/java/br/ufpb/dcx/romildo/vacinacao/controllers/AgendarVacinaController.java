package br.ufpb.dcx.romildo.vacinacao.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufpb.dcx.romildo.vacinacao.*;
import br.ufpb.dcx.romildo.vacinacao.exceptions.DataNaoCadastradaException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.HoraNaoCadastradaException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteJaCadastradoException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteNaoEncontradoException;

import javax.swing.*;

public class AgendarVacinaController implements ActionListener {
    private AgendamentoVacinaInterface sistema;
    private JFrame janelaPrincipal;
    public AgendarVacinaController(AgendamentoVacinaInterface sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do aniversariante?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE);
            String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do paciente?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE);
            int idade = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a idade do paciente?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE));

            String tipo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o tipo da Vacina que está no estoque? \n 1.Poliomielite \n 2.Influenza \n 3.DTP \n HPV", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
            int dose = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a dose? \n Por favor digite apenas números", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE));
            String data = JOptionPane.showInputDialog(janelaPrincipal, "Qual a data que a vacina será agendada? \n Por favor, digite no formato: DD/MM/AAAA", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
            String hora = JOptionPane.showInputDialog(janelaPrincipal, "Qual a hora a ser escolhida?  Por favor, digite no formato: hora:min", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);

            Paciente paciente = new Paciente(cartaoSUS, nome, idade);
            sistema.cadastrarPaciente(cartaoSUS, paciente);
            Data dataFormatada = new Data(data);
            Hora horaFormtada = new Hora(hora);
            Vacina vacina = new Vacina(tipo, dose, dataFormatada, horaFormtada);
            sistema.agendarVacina(cartaoSUS, vacina);

            JOptionPane.showMessageDialog(janelaPrincipal, "Paciente e Vacinas Agendadas com Sucesso", "Agendar Vacinas", JOptionPane.INFORMATION_MESSAGE);

        } catch (PacienteJaCadastradoException | DataNaoCadastradaException | HoraNaoCadastradaException |
                 IllegalArgumentException | PacienteNaoEncontradoException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());
        }


    }
}

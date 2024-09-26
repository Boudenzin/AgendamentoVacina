package br.ufpb.dcx.romildo.vacinacao.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.ufpb.dcx.romildo.vacinacao.AgendamentoVacinaInterface;
import br.ufpb.dcx.romildo.vacinacao.Data;
import br.ufpb.dcx.romildo.vacinacao.Hora;

import javax.swing.*;

public class AgendarVacinaController implements ActionListener {
    private AgendamentoVacinaInterface agendamentoVacinaInterface;
    private JFrame janelaPrincipal;
    public AgendarVacinaController(AgendamentoVacinaInterface agenda, JFrame janela) {
        this.agendamentoVacinaInterface = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do aniversariante?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE);
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do paciente?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE);
        int idade = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a idade do paciente?", "Agendar Paciente", JOptionPane.INFORMATION_MESSAGE));
        String tipo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o tipo da Vacina que está no estoque? \n 1.Poliomielite \n 2.Influenza \n 3.DTP \n HPV", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
        int dose = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a dose? \n Por favor digite apenas números", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE));
        String data = JOptionPane.showInputDialog(janelaPrincipal, "Qual a data que a vacina será agendada?", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
        String hora = JOptionPane.showInputDialog(janelaPrincipal, "Qual a hora a ser escolhida?", "Agendar Vacina", JOptionPane.INFORMATION_MESSAGE);
        //TODO: FAZER UM TRY-CATCH E MODELAR DATA E HORA PARA O CONSTRUTOR
        //TODO: AGENDAR A VACINA E DAR UM FEEDBACK CASO NAO SEJA CADASTRADO.
    }
}

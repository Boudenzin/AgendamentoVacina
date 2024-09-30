package br.ufpb.dcx.romildo.vacinacao.controllers;

import br.ufpb.dcx.romildo.vacinacao.AgendamentoVacinaUBSPrimavera;
import br.ufpb.dcx.romildo.vacinacao.Paciente;
import br.ufpb.dcx.romildo.vacinacao.Vacina;
import br.ufpb.dcx.romildo.vacinacao.exceptions.DataNaoCadastradaException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.HoraNaoCadastradaException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.PacienteNaoEncontradoException;
import br.ufpb.dcx.romildo.vacinacao.exceptions.VacinaNaoEncontradaException;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;

public class PesquisarDataController implements ActionListener {
    private AgendamentoVacinaUBSPrimavera sistema;
    private JFrame janelaPrincipal;

    public PesquisarDataController(AgendamentoVacinaUBSPrimavera sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    //TODO: PROJETO DE CLASSE/FUNÇÃO FUTURA/O:UM POUCO COMPLEXO, MAS O INTUITO É PASSAR TOSTRINGS ESPECIAIS A PARTIR DOS OBJETOS DE VACINA -> PACIENTE -> SISTEMA -> EXIBIR AQUI

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cartaoSUS = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cartão do SUS do paciente?", "Pesquisar Vacina por Data", JOptionPane.INFORMATION_MESSAGE);
            String data = JOptionPane.showInputDialog(janelaPrincipal, "Qual a data a ser procurada? \n Por favor, digite no formato: DD/MM/AAAA", "Pesquisar Vacina por Data", JOptionPane.INFORMATION_MESSAGE);

            List<Vacina> vacinasEncontradas = sistema.pesquisarDataAgendada(cartaoSUS, data);
            StringBuilder saida = sistema.exibirToStringsDasVacinas(vacinasEncontradas);

            JOptionPane.showMessageDialog(janelaPrincipal, "O paciente procurado tem as seguintes vacinas: \n" + saida, "Pesquisar Vacinas do Paciente pela Data", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Erro de Digitação", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            System.err.println(exception.getMessage());

        }
    }
}

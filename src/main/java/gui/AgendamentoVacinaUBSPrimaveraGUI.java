package gui;

import javax.swing.*;
import java.awt.*;


import controllers.*;
public class AgendamentoVacinaUBSPrimaveraGUI extends JFrame {

    private ImageIcon zeGotinha = new ImageIcon("./imgs/ZeGotinha.gif");
    private JLabel linha1, linha2;
    private ImageIcon fotoPrincipal = zeGotinha;
    private JMenuBar barraDeMenu = new JMenuBar();

    public AgendamentoVacinaUBSPrimaveraGUI() {

        setTitle("Agendamento de Vacinas");
        setSize(1080,720);

        Dimension dimensaoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraTela = dimensaoTela.width;
        int alturaTela = dimensaoTela.height;

        int x = (larguraTela - getWidth()) / 2;
        int y = (alturaTela - getHeight()) / 2;

        setLocation(x, y);
        setResizable(false);
        getContentPane().setBackground(Color.white);

        linha1 = new JLabel("Agendamento de Vacinas da UBS Primavera", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Raleway", Font.BOLD, 24));

        linha2 = new JLabel(fotoPrincipal, JLabel.CENTER);
        setLayout(new GridLayout(2,1));

        add(linha1);
        add(linha2);
        add(new JLabel());

        JMenu menuAgendar = new JMenu("Agendar");
        JMenuItem menuAgendarVacina = new JMenuItem("Agendar Vacina");
        menuAgendar.add(menuAgendarVacina);

        JMenu menuAlterar = new JMenu("Alterar");
        JMenuItem menuAlterarDataVacina = new JMenuItem("Alterar Data da Vacina");
        JMenuItem menuAlterarVacinaDoPaciente = new JMenuItem("Alterar Vacina do Paciente");
        menuAlterar.add(menuAlterarDataVacina);
        menuAlterar.add(menuAlterarVacinaDoPaciente);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverPacienteDoSistema = new JMenuItem("Remover o Paciente do Sistema");
        JMenuItem menuRemoverVacinaDoPaciente = new JMenuItem("Remover Vacina do Paciente");
        menuRemover.add(menuRemoverPacienteDoSistema);
        menuRemover.add(menuRemoverVacinaDoPaciente);

        barraDeMenu.add(menuAgendar);
        barraDeMenu.add(menuAlterar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);

    }

    public static void main(String[] args) {
        JFrame janela = new AgendamentoVacinaUBSPrimaveraGUI();
        janela.setVisible(true);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

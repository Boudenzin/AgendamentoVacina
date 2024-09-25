package gui;

import javax.swing.*;
import java.awt.*;


import controllers.*;
public class AgendamentoVacinaUBSPrimaveraGUI extends JFrame {

    ImageIcon zegotinha = new ImageIcon(".imgs/zegotinha.png");
    JLabel linha1, linha2;
    ImageIcon fotoPrincipal = zegotinha;
    JMenuBar barraDeMeu = new JMenuBar();

    public AgendamentoVacinaUBSPrimaveraGUI() {

        setTitle("Agendamento de Vacinas");
        setSize(1820,720);

        Dimension dimensaoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraTela = dimensaoTela.width;
        int alturaTela = dimensaoTela.height;



    }
}

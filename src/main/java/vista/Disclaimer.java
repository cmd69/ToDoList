package vista;

import javax.swing.*;
import java.awt.*;

public class Disclaimer extends JDialog {

    Disclaimer(String msg, JFrame padre, boolean b){
        super(padre, b);
        if(b){
            JLabel mensaje =new JLabel(msg);
            JPanel panel = new JPanel();
            panel.add(mensaje);

            add(panel, BorderLayout.CENTER);
            setBounds(750, 400, 300, 100);
            setTitle("Error");
            setVisible(true);

        }

    }
}

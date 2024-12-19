package Button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelButton {

    public void ajouterBouton(JPanel panel, String texte, ActionListener action) {
        JButton bouton = new JButton(texte);
        bouton.addActionListener(action);
        panel.add(bouton);
    }

}

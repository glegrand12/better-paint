import javax.swing.*;
import java.awt.*;

import Panel.OutilsPanel;
import Toile.ToileDessin;

public class ApplicationDessin extends JFrame {
    OutilsPanel panel = new OutilsPanel();

    public ApplicationDessin() {
        setTitle("Application de Dessin");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ToileDessin toileDessin = new ToileDessin();
        add(toileDessin, BorderLayout.CENTER);
// Configuration du panneau latéral
        JPanel panneauLateral = new JPanel();
        panneauLateral.setLayout(new BoxLayout(panneauLateral, BoxLayout.Y_AXIS)); // Disposition verticale
        panneauLateral.setPreferredSize(new Dimension(150, getHeight())); // Largeur fixée

// Ajout des sous-panneaux
        panel.creerPanelOutils(toileDessin);
        panel.creerPanelCouleurs(toileDessin);
        panel.creerPanelEpaisseurs(toileDessin);

        panneauLateral.add(panel.getPanelOutils());
        panneauLateral.add(panel.getPanelCouleurs());
        panneauLateral.add(panel.getPanelEpaisseurs());

// Ajout au conteneur principal
        add(panneauLateral, BorderLayout.WEST);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ApplicationDessin app = new ApplicationDessin();
            app.setVisible(true);
        });
    }
}

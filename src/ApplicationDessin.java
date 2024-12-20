import javax.swing.*;
import java.awt.*;
import Panel.OutilsPanel;
import Toile.ToileDessin;

/**
 * Classe principale qui représente la fenêtre de l'application de dessin.
 * Elle utilise Swing pour l'interface graphique et gère l'organisation des différents panneaux.
 */
public class ApplicationDessin extends JFrame {
    // Panneau principal contenant tous les outils de dessin
    OutilsPanel panel = new OutilsPanel();

    /**
     * Constructeur qui initialise l'interface graphique
     */
    public ApplicationDessin() {
        /* Configuration de base de la fenêtre principale
         * - Définit le titre, la taille et le comportement de fermeture
         * - Utilise BorderLayout pour organiser les éléments
         */
        setTitle("Application de Dessin");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        /* Zone de dessin
         * Création et placement de la toile de dessin au centre de la fenêtre
         */
        ToileDessin toileDessin = new ToileDessin();
        add(toileDessin, BorderLayout.CENTER);

        /* Configuration du panneau latéral
         * - Crée un panneau pour contenir tous les outils
         * - Utilise BoxLayout vertical pour empiler les composants
         * - Définit une largeur fixe
         */
        JPanel panneauLateral = new JPanel();
        panneauLateral.setLayout(new BoxLayout(panneauLateral, BoxLayout.Y_AXIS));
        panneauLateral.setPreferredSize(new Dimension(150, getHeight()));

        /* Initialisation des outils
         * Création des différents panneaux d'outils et association avec la toile de dessin
         */
        panel.creerPanelOutils(toileDessin);
        panel.creerPanelCouleurs(toileDessin);
        panel.creerPanelEpaisseurs(toileDessin);

        /* Assemblage des panneaux
         * Ajout de tous les panneaux d'outils au panneau latéral
         */
        panneauLateral.add(panel.getPanelOutils());
        panneauLateral.add(panel.getPanelCouleurs());
        panneauLateral.add(panel.getPanelEpaisseurs());

        // Placement du panneau latéral à gauche de la fenêtre
        add(panneauLateral, BorderLayout.WEST);

        // Centrage de la fenêtre sur l'écran
        setLocationRelativeTo(null);
    }

    /**
     * Point d'entrée de l'application
     * Configure le look and feel et lance l'application dans le thread EDT
     */
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
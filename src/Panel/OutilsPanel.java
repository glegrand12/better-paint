package Panel;

import javax.swing.*;
import java.awt.*;
import Toile.ToileDessin;
import Button.ColorButton;
import Button.PanelButton;


/**
 * Classe pour la création des panneaux d'outils, de couleurs et d'épaisseurs
 */
public class OutilsPanel {

    // Variables pour les panneaux

    private JPanel panelOutils;
    private JPanel panelCouleurs;
    private JPanel panelEpaisseurs;
    private final PanelButton panelButton = new PanelButton();

    /**
     * Création du panneau d'outils avec les différents boutons
     * @param toileDessin Toile de dessin
     */
    public void creerPanelOutils(ToileDessin toileDessin) {
        String[] outils = {"Crayon", "Ligne", "Rectangle","Triangle", "Cercle", "Effacer"};

        panelOutils = new JPanel(new GridLayout(outils.length, 1, 5, 5));
        panelOutils.setBorder(BorderFactory.createTitledBorder("Outils"));

        for (String outil : outils) {
            JButton bouton = new JButton(outil);
            bouton.setPreferredSize(new Dimension(80, 25));
            panelButton.ajouterBouton(panelOutils, bouton.getText(), e -> toileDessin.changerOutil(outil));
        }
    }

    /**
     * Création du panneau de couleurs avec les boutons de couleur
     * @param toileDessin Toile de dessin
     */
    public void creerPanelCouleurs(ToileDessin toileDessin) {
        panelCouleurs = new JPanel(new FlowLayout());
        panelCouleurs.setBorder(BorderFactory.createTitledBorder("Couleurs"));

        // Liste des couleurs disponibles
        Color[] couleurs = {
                Color.BLACK, Color.RED, Color.BLUE,
                Color.GREEN, Color.YELLOW, Color.ORANGE,
                Color.PINK, Color.MAGENTA, Color.CYAN
        };

        // Création des boutons de couleur personnalisés
        for (Color couleur : couleurs) {
            ColorButton boutonCouleur = new ColorButton(couleur);
            boutonCouleur.addActionListener(e -> toileDessin.changerCouleur(couleur));
            panelCouleurs.add(boutonCouleur);
        }
    }

    /**
     * Création du panneau d'épaisseurs avec la liste déroulante
     * @param toileDessin Toile de dessin
     */
    public void creerPanelEpaisseurs(ToileDessin toileDessin) {
        panelEpaisseurs = new JPanel(new FlowLayout());
        panelEpaisseurs.setBorder(BorderFactory.createTitledBorder("Épaisseurs"));

        JComboBox<Integer> epaisseurBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        epaisseurBox.addActionListener(e -> toileDessin.changerEpaisseur((Integer) epaisseurBox.getSelectedItem()));
        panelEpaisseurs.add(new JLabel("Épaisseur:"));
        panelEpaisseurs.add(epaisseurBox);
    }

    public JPanel getPanelOutils() {
        return panelOutils;
    }

    public JPanel getPanelCouleurs() {
        return panelCouleurs;
    }

    public JPanel getPanelEpaisseurs() {
        return panelEpaisseurs;
    }
}



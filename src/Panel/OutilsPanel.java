package Panel;

import javax.swing.*;
import java.awt.*;
import Toile.ToileDessin;
import Button.ColorButton;
import Button.PanelButton;

/**
 * Classe `OutilsPanel` responsable de la création et de la gestion des panneaux d'outils,
 * de couleurs et d'épaisseurs pour une application de dessin.
 *
 * Cette classe organise les boutons et composants nécessaires pour permettre à
 * l'utilisateur de sélectionner un outil de dessin, une couleur ou une épaisseur
 * pour dessiner sur la toile.
 */
public class OutilsPanel {

    // Panneaux pour organiser les outils, couleurs et épaisseurs
    private JPanel panelOutils;
    private JPanel panelCouleurs;
    private JPanel panelEpaisseurs;

    // Instance de PanelButton pour gérer les actions sur les boutons
    private final PanelButton panelButton = new PanelButton();

    /**
     * Crée le panneau d'outils avec différents boutons correspondant aux outils disponibles.
     *
     * @param toileDessin Instance de la toile de dessin où les outils seront utilisés.
     */
    public void creerPanelOutils(ToileDessin toileDessin) {
        // Liste des outils disponibles
        String[] outils = {"Crayon", "Ligne", "Rectangle", "Triangle", "Cercle", "Effacer"};

        // Initialisation du panneau avec une disposition en grille
        panelOutils = new JPanel(new GridLayout(outils.length, 1, 5, 5));
        panelOutils.setBorder(BorderFactory.createTitledBorder("Outils"));

        // Création d'un bouton pour chaque outil
        for (String outil : outils) {
            JButton bouton = new JButton(outil);
            bouton.setPreferredSize(new Dimension(80, 25));
            // Ajout du bouton au panneau et définition de son action
            panelButton.ajouterBouton(panelOutils, bouton.getText(), e -> toileDessin.changerOutil(outil));
        }
    }

    /**
     * Crée le panneau de couleurs avec des boutons représentant des couleurs spécifiques.
     *
     * @param toileDessin Instance de la toile de dessin où les couleurs seront appliquées.
     */
    public void creerPanelCouleurs(ToileDessin toileDessin) {
        // Initialisation du panneau avec une disposition en flux
        panelCouleurs = new JPanel(new FlowLayout());
        panelCouleurs.setBorder(BorderFactory.createTitledBorder("Couleurs"));

        // Liste des couleurs disponibles
        Color[] couleurs = {
                Color.BLACK, Color.RED, Color.BLUE,
                Color.GREEN, Color.YELLOW, Color.ORANGE,
                Color.PINK, Color.MAGENTA, Color.CYAN
        };

        // Création de boutons personnalisés pour chaque couleur
        for (Color couleur : couleurs) {
            ColorButton boutonCouleur = new ColorButton(couleur);
            boutonCouleur.addActionListener(e -> toileDessin.changerCouleur(couleur));
            panelCouleurs.add(boutonCouleur);
        }
    }

    /**
     * Crée le panneau d'épaisseurs avec une liste déroulante permettant
     * de choisir l'épaisseur des traits.
     *
     * @param toileDessin Instance de la toile de dessin où l'épaisseur sera appliquée.
     */
    public void creerPanelEpaisseurs(ToileDessin toileDessin) {
        // Initialisation du panneau avec une disposition en flux
        panelEpaisseurs = new JPanel(new FlowLayout());
        panelEpaisseurs.setBorder(BorderFactory.createTitledBorder("Épaisseurs"));

        // Création d'une liste déroulante pour sélectionner l'épaisseur
        JComboBox<Integer> epaisseurBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        epaisseurBox.addActionListener(e ->
                toileDessin.changerEpaisseur((Integer) epaisseurBox.getSelectedItem())
        );

        // Ajout d'une étiquette et de la liste déroulante au panneau
        panelEpaisseurs.add(new JLabel("Épaisseur:"));
        panelEpaisseurs.add(epaisseurBox);
    }

    /**
     * Accède au panneau des outils.
     *
     * @return Le panneau contenant les outils.
     */
    public JPanel getPanelOutils() {
        return panelOutils;
    }

    /**
     * Accède au panneau des couleurs.
     *
     * @return Le panneau contenant les couleurs.
     */
    public JPanel getPanelCouleurs() {
        return panelCouleurs;
    }

    /**
     * Accède au panneau des épaisseurs.
     *
     * @return Le panneau contenant la sélection des épaisseurs.
     */
    public JPanel getPanelEpaisseurs() {
        return panelEpaisseurs;
    }
}

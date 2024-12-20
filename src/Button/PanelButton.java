package Button;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * La classe PanelButton fournit une méthode utilitaire pour ajouter des boutons
 * à un panneau (`JPanel`) avec un texte spécifique et une action associée.
 *
 * Cette classe simplifie la création et la gestion des boutons dans une interface graphique Swing.
 */
public class PanelButton {

    /**
     * Ajoute un bouton à un panneau avec un texte et un gestionnaire d'événements spécifiés.
     *
     * @param panel  Le panneau (`JPanel`) auquel le bouton sera ajouté.
     * @param texte  Le texte a affiché sur le bouton.
     * @param action L'écouteur d'action (de type `ActionListener`) qui sera déclenché lorsque
     *               le bouton sera cliqué.
     */
    public void ajouterBouton(JPanel panel, String texte, ActionListener action) {
        // Création d'un bouton avec le texte fourni.
        JButton bouton = new JButton(texte);

        // Ajout de l'écouteur d'action au bouton.
        bouton.addActionListener(action);

        // Ajout du bouton au panneau.
        panel.add(bouton);
    }
}

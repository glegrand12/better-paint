package Button;

import javax.swing.*;
import java.awt.*;

/**
 * La classe ColorButton est une extension de JButton qui affiche un bouton circulaire
 * rempli d'une couleur spécifique. Ce bouton est conçu pour être utilisé dans des
 * interfaces graphiques nécessitant une représentation visuelle des couleurs.
 */
public class ColorButton extends JButton {
    private Color couleur; // La couleur associée au bouton.
    private static final int TAILLE = 20; // Taille (diamètre) du cercle de couleur.

    /**
     * Constructeur pour initialiser le bouton avec une couleur donnée.
     *
     * @param couleur La couleur à afficher sur le bouton.
     */
    public ColorButton(Color couleur) {
        this.couleur = couleur;

        // Définit l'icône du bouton avec un cercle de la couleur spécifiée.
        setIcon(creerIconeCouleur());

        // Configure l'apparence et le comportement du bouton.
        setPreferredSize(new Dimension(30, 30)); // Définit une taille préférée.
        setBorderPainted(false); // Supprime la bordure peinte par défaut.
        setContentAreaFilled(false); // Supprime le fond du bouton.
        setFocusPainted(false); // Supprime l'effet visuel lors de la mise au focus.
    }

    /**
     * Méthode privée pour créer une icône représentant un cercle coloré.
     *
     * @return Une instance de Icon dessinant un cercle de la couleur spécifiée.
     */
    private Icon creerIconeCouleur() {
        return new Icon() {
            /**
             * Dessine l'icône, un cercle rempli de la couleur spécifiée,
             * avec un contour noir pour plus de visibilité.
             *
             * @param c Le composant sur lequel l'icône est dessinée.
             * @param g Le contexte graphique utilisé pour le dessin.
             * @param x La position x du coin supérieur gauche de l'icône.
             * @param y La position y du coin supérieur gauche de l'icône.
             */
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                // Dessin du cercle rempli avec la couleur associée.
                g.setColor(couleur);
                g.fillOval(x, y, TAILLE, TAILLE);

                // Dessin du contour noir autour du cercle.
                g.setColor(Color.BLACK);
                g.drawOval(x, y, TAILLE, TAILLE);
            }

            /**
             * Retourne la largeur de l'icône (diamètre du cercle).
             *
             * @return La largeur de l'icône en pixels.
             */
            @Override
            public int getIconWidth() {
                return TAILLE;
            }

            /**
             * Retourne la hauteur de l'icône (diamètre du cercle).
             *
             * @return La hauteur de l'icône en pixels.
             */
            @Override
            public int getIconHeight() {
                return TAILLE;
            }
        };
    }

    /**
     * Accesseur pour récupérer la couleur associée au bouton.
     *
     * @return La couleur du bouton.
     */
    public Color getCouleur() {
        return couleur;
    }
}

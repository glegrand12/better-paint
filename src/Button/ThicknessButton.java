package Button;

import javax.swing.*;
import java.awt.*;

/**
 * La classe ThicknessButton est une extension de JButton qui affiche un bouton
 * avec une icône représentant une épaisseur spécifique sous la forme d'un cercle rempli.
 * Ce bouton est utile dans des interfaces où l'utilisateur doit choisir ou visualiser une épaisseur.
 */
public class ThicknessButton extends JButton {
    private final int epaisseur; // L'épaisseur représentée par le bouton.
    private static final int LARGEUR_DEFAUT = 30; // Largeur par défaut du bouton.
    private static final int HAUTEUR_DEFAUT = 30; // Hauteur par défaut du bouton.

    /**
     * Constructeur pour initialiser le bouton avec une épaisseur donnée.
     *
     * @param epaisseur L'épaisseur à représenter sur le bouton.
     */
    public ThicknessButton(int epaisseur) {
        this.epaisseur = epaisseur;

        // Création de l'icône personnalisée représentant l'épaisseur.
        setIcon(creerIconeEpaisseur());

        // Configuration du style du bouton.
        setPreferredSize(new Dimension(LARGEUR_DEFAUT, HAUTEUR_DEFAUT)); // Taille préférée du bouton.
        setBorderPainted(false); // Supprime la bordure peinte par défaut.
        setContentAreaFilled(false); // Supprime le remplissage par défaut.
        setFocusPainted(false); // Supprime l'effet visuel de mise au focus.
    }

    /**
     * Méthode privée pour créer une icône représentant l'épaisseur.
     *
     * @return Une instance de Icon qui dessine un cercle rempli, dont le diamètre
     * correspond à deux fois la valeur de l'épaisseur.
     */
    private Icon creerIconeEpaisseur() {
        return new Icon() {
            /**
             * Dessine l'icône représentant l'épaisseur sous la forme d'un cercle noir rempli.
             *
             * @param c Le composant sur lequel l'icône est dessinée.
             * @param g Le contexte graphique utilisé pour le dessin.
             * @param x La position x du coin supérieur gauche de l'icône.
             * @param y La position y du coin supérieur gauche de l'icône.
             */
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                // Création d'un contexte graphique pour le dessin.
                Graphics2D g2d = (Graphics2D) g.create();

                // Activation de l'anti-aliasing pour des cercles plus lisses.
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dessiner un cercle noir rempli.
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(1f)); // Contour mince pour le cercle.

                // Calculer la position et le diamètre du cercle.
                int diametre = epaisseur * 2; // Le diamètre est proportionnel à l'épaisseur.
                g2d.fillOval(
                        x + (LARGEUR_DEFAUT - diametre) / 2, // Centrage horizontal.
                        y + (HAUTEUR_DEFAUT - diametre) / 2, // Centrage vertical.
                        diametre,
                        diametre
                );

                g2d.dispose(); // Libération des ressources graphiques.
            }

            /**
             * Retourne la largeur de l'icône (fixée à LARGEUR_DEFAUT).
             *
             * @return La largeur de l'icône en pixels.
             */
            @Override
            public int getIconWidth() {
                return LARGEUR_DEFAUT;
            }

            /**
             * Retourne la hauteur de l'icône (fixée à HAUTEUR_DEFAUT).
             *
             * @return La hauteur de l'icône en pixels.
             */
            @Override
            public int getIconHeight() {
                return HAUTEUR_DEFAUT;
            }
        };
    }

    /**
     * Accesseur pour récupérer la valeur de l'épaisseur associée au bouton.
     *
     * @return L'épaisseur représentée par le bouton.
     */
    public int getEpaisseur() {
        return epaisseur;
    }
}

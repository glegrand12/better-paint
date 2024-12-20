package Forme;

import java.awt.*;

/**
 * La classe Cercle représente une forme géométrique de type cercle ou ellipse.
 * Elle hérite de la classe abstraite `Forme` et implémente la méthode de dessin spécifique pour afficher un cercle/ellipse.
 */
public class Cercle extends Forme {

    /**
     * Constructeur pour initialiser un cercle avec les points de départ et de fin, la couleur et l'épaisseur.
     *
     * @param debut     Le point de départ définissant une extrémité du cadre englobant.
     * @param fin       Le point de fin définissant l'autre extrémité du cadre englobant.
     * @param couleur   La couleur utilisée pour dessiner le cercle.
     * @param epaisseur L'épaisseur du trait pour le dessin.
     */
    public Cercle(Point debut, Point fin, Color couleur, int epaisseur) {
        super(debut, fin, couleur, epaisseur);
    }

    /**
     * Implémente la méthode de dessin pour dessiner un cercle ou une ellipse dans un contexte graphique.
     *
     * @param g Le contexte graphique utilisé pour dessiner la forme.
     */
    @Override
    public void dessiner(Graphics g) {
        // Convertir en Graphics2D pour activer les fonctionnalités avancées comme les traits personnalisés.
        Graphics2D g2d = (Graphics2D) g;

        // Définir la couleur de dessin.
        g.setColor(couleur);

        // Définir l'épaisseur du trait.
        g2d.setStroke(new BasicStroke(epaisseur));

        // Calculer le cadre englobant du cercle.
        Rectangle cadre = calculerCadre();

        // Dessiner un cercle ou une ellipse basé sur le cadre englobant.
        g.drawOval(cadre.x, cadre.y, cadre.width, cadre.height);
    }
}

package Forme;

import java.awt.*;

/**
 * La classe Triangle représente une forme géométrique de type triangle.
 * Elle hérite de la classe abstraite `Forme` et implémente la méthode de dessin
 * pour afficher un triangle défini par deux points.
 */
public class Triangle extends Forme {

    /**
     * Constructeur pour initialiser un triangle avec les points de début et de fin,
     * la couleur et l'épaisseur.
     *
     * @param debut     Le point de départ du triangle (un des sommets).
     * @param fin       Le point de fin utilisé pour déterminer la base et la hauteur du triangle.
     * @param couleur   La couleur utilisée pour dessiner le triangle.
     * @param epaisseur L'épaisseur du trait pour le dessin.
     */
    public Triangle(Point debut, Point fin, Color couleur, int epaisseur) {
        super(debut, fin, couleur, epaisseur);
    }

    /**
     * Implémente la méthode de dessin pour afficher un triangle.
     *
     * @param g Le contexte graphique utilisé pour dessiner le triangle.
     */
    @Override
    public void dessiner(Graphics g) {
        // Convertir en Graphics2D pour utiliser les fonctionnalités avancées.
        Graphics2D g2d = (Graphics2D) g;

        // Définir la couleur de dessin.
        g.setColor(couleur);

        // Définir l'épaisseur du trait.
        g2d.setStroke(new BasicStroke(epaisseur));

        // Calculer les coordonnées des sommets du triangle.
        int[] xPoints = {debut.x, fin.x, debut.x}; // Points x des sommets.
        int[] yPoints = {debut.y, fin.y, fin.y};   // Points y des sommets.

        // Dessiner le contour du triangle.
        g.drawPolygon(xPoints, yPoints, 3);
    }
}

package Forme;

import java.awt.*;
import java.awt.Rectangle;

/**
 * La classe RectangleForme représente une forme géométrique de type rectangle.
 * Elle hérite de la classe abstraite `Forme` et implémente la méthode de dessin
 * pour afficher un rectangle entre deux points définis.
 */
public class RectangleForme extends Forme {

    /**
     * Constructeur pour initialiser un rectangle avec les points de début et de fin,
     * la couleur et l'épaisseur.
     *
     * @param debut     Le point de départ du rectangle (un des coins).
     * @param fin       Le point de fin du rectangle (le coin opposé).
     * @param couleur   La couleur utilisée pour dessiner le rectangle.
     * @param epaisseur L'épaisseur du trait pour le dessin.
     */
    public RectangleForme(Point debut, Point fin, Color couleur, int epaisseur) {
        super(debut, fin, couleur, epaisseur);
    }

    /**
     * Implémente la méthode de dessin pour afficher un rectangle.
     *
     * @param g Le contexte graphique utilisé pour dessiner le rectangle.
     */
    @Override
    public void dessiner(Graphics g) {
        // Convertir en Graphics2D pour activer les fonctionnalités avancées comme les traits personnalisés.
        Graphics2D g2d = (Graphics2D) g;

        // Définir la couleur de dessin.
        g.setColor(couleur);

        // Définir l'épaisseur du trait.
        g2d.setStroke(new BasicStroke(epaisseur));

        // Calculer le rectangle englobant en fonction des points de début et de fin.
        Rectangle cadre = calculerCadre();

        // Dessiner le rectangle à partir des dimensions calculées.
        g.drawRect(cadre.x, cadre.y, cadre.width, cadre.height);
    }
}

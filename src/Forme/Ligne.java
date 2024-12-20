package Forme;

import java.awt.*;

/**
 * La classe Ligne représente une forme géométrique de type ligne droite.
 * Elle hérite de la classe abstraite `Forme` et implémente la méthode de dessin
 * pour afficher une ligne entre deux points.
 */
public class Ligne extends Forme {

    /**
     * Constructeur pour initialiser une ligne avec les points de début et de fin,
     * la couleur et l'épaisseur.
     *
     * @param debut     Le point de départ de la ligne.
     * @param fin       Le point de fin de la ligne.
     * @param couleur   La couleur utilisée pour dessiner la ligne.
     * @param epaisseur L'épaisseur du trait pour le dessin.
     */
    public Ligne(Point debut, Point fin, Color couleur, int epaisseur) {
        super(debut, fin, couleur, epaisseur);
    }

    /**
     * Implémente la méthode de dessin pour dessiner une ligne droite entre deux points.
     *
     * @param g Le contexte graphique utilisé pour dessiner la ligne.
     */
    @Override
    public void dessiner(Graphics g) {
        // Convertir en Graphics2D pour activer les fonctionnalités avancées comme les traits personnalisés.
        Graphics2D g2d = (Graphics2D) g;

        // Définir la couleur de dessin.
        g.setColor(couleur);

        // Définir l'épaisseur du trait.
        g2d.setStroke(new BasicStroke(epaisseur));

        // Dessiner une ligne droite entre le point de début et le point de fin.
        g.drawLine(debut.x, debut.y, fin.x, fin.y);
    }
}

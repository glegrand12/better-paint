package Forme;

import java.awt.*;

/**
 * La classe abstraite Forme représente une forme géométrique générique
 * dans une application graphique. Elle contient des propriétés communes
 * et des méthodes utilitaires pour les formes.
 *
 * Cette classe est destinée à être étendue par des classes concrètes
 * représentant des formes spécifiques, comme des cercles, des rectangles, etc.
 */
public abstract class Forme {
    protected Point debut;      // Point de départ définissant une extrémité de la forme.
    protected Point fin;        // Point de fin définissant l'autre extrémité de la forme.
    protected Color couleur;    // Couleur de la forme.
    protected int epaisseur;    // Épaisseur du trait utilisé pour dessiner la forme.

    /**
     * Constructeur pour initialiser une forme avec ses paramètres de base.
     *
     * @param debut     Le point de départ de la forme.
     * @param fin       Le point de fin de la forme.
     * @param couleur   La couleur de la forme.
     * @param epaisseur L'épaisseur du trait utilisé pour dessiner la forme.
     */
    public Forme(Point debut, Point fin, Color couleur, int epaisseur) {
        this.debut = debut;
        this.fin = fin;
        this.couleur = couleur;
        this.epaisseur = epaisseur;
    }

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour dessiner
     * la forme spécifique sur un contexte graphique.
     *
     * @param g Le contexte graphique utilisé pour dessiner la forme.
     */
    public abstract void dessiner(Graphics g);

    /**
     * Méthode utilitaire pour calculer le cadre englobant de la forme.
     *
     * Le cadre englobant est défini par les points de début et de fin
     * et correspond au plus petit rectangle pouvant contenir la forme.
     *
     * @return Un objet Rectangle représentant le cadre englobant.
     */
    protected Rectangle calculerCadre() {
        // Calculer les coordonnées x et y du coin supérieur gauche.
        int x = Math.min(debut.x, fin.x);
        int y = Math.min(debut.y, fin.y);

        // Calculer la largeur et la hauteur du rectangle englobant.
        int width = Math.abs(debut.x - fin.x);
        int height = Math.abs(debut.y - fin.y);

        return new Rectangle(x, y, width, height);
    }

    /**
     * Accesseur pour obtenir l'épaisseur de la forme.
     *
     * @return L'épaisseur du trait utilisé pour dessiner la forme.
     */
    public int getEpaisseur() {
        return epaisseur;
    }
}

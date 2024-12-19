package Forme;

import java.awt.*;

public abstract class Forme {
    protected Point debut;
    protected Point fin;
    protected Color couleur;
    protected int epaisseur;

    public Forme(Point debut, Point fin, Color couleur, int epaisseur) {
        this.debut = debut;
        this.fin = fin;
        this.couleur = couleur;
        this.epaisseur = epaisseur;
    }

    public abstract void dessiner(Graphics g);

    protected Rectangle calculerCadre() {
        int x = Math.min(debut.x, fin.x);
        int y = Math.min(debut.y, fin.y);
        int width = Math.abs(debut.x - fin.x);
        int height = Math.abs(debut.y - fin.y);
        return new Rectangle(x, y, width, height);
    }

    public int getEpaisseur() {
        return epaisseur;
    }
}

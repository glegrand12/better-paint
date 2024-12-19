package Forme;

import java.awt.*;

public class Ligne extends Forme {
    public Ligne(Point debut, Point fin, Color couleur, int epaisseur) {
        super(debut, fin, couleur, epaisseur);
    }

    @Override
    public void dessiner(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(couleur);
        g2d.setStroke(new BasicStroke(epaisseur));
        g.drawLine(debut.x, debut.y, fin.x, fin.y);
    }
}
package Forme;

import java.awt.*;

public class Triangle extends Forme {
    public Triangle(Point debut, Point fin, Color couleur, int epaisseur) {
        super(debut, fin, couleur, epaisseur);
    }

    @Override
    public void dessiner(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(couleur);
        g2d.setStroke(new BasicStroke(epaisseur));
        int[] xPoints = {debut.x, fin.x, debut.x};
        int[] yPoints = {debut.y, fin.y, fin.y};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}

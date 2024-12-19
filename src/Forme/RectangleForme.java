package Forme;

import java.awt.*;
import java.awt.Rectangle;

public class RectangleForme extends Forme {
    public RectangleForme(Point debut, Point fin, Color couleur, int epaisseur) {
        super(debut, fin, couleur, epaisseur);
    }

    @Override
    public void dessiner(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(couleur);
        g2d.setStroke(new BasicStroke(epaisseur));
        Rectangle cadre = calculerCadre();
        g.drawRect(cadre.x, cadre.y, cadre.width, cadre.height);
    }
}
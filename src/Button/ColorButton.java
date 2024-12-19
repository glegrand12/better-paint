package Button;

import javax.swing.*;
import java.awt.*;

public class ColorButton extends JButton {
    private Color couleur;
    private static final int TAILLE = 20;

    public ColorButton(Color couleur) {
        this.couleur = couleur;

        setIcon(creerIconeCouleur());

        setPreferredSize(new Dimension(30, 30));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    private Icon creerIconeCouleur() {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                // Dessin du cercle de couleur
                g.setColor(couleur);
                g.fillOval(x, y, TAILLE, TAILLE);

                // Contour noir pour la visibilité
                g.setColor(Color.BLACK);
                g.drawOval(x, y, TAILLE, TAILLE);
            }

            @Override
            public int getIconWidth() {
                return TAILLE;
            }

            @Override
            public int getIconHeight() {
                return TAILLE;
            }
        };
    }

    // Getter pour la couleur
    public Color getCouleur() {
        return couleur;
    }
}
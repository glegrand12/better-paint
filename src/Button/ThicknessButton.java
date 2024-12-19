package Button;

import javax.swing.*;
import java.awt.*;

public class ThicknessButton extends JButton {
    private final int epaisseur;
    private static final int LARGEUR_DEFAUT = 30;
    private static final int HAUTEUR_DEFAUT = 30;

    public ThicknessButton(int epaisseur) {
        this.epaisseur = epaisseur;

        // Création de l'icône personnalisée
        setIcon(creerIconeEpaisseur());

        // Style du bouton
        setPreferredSize(new Dimension(LARGEUR_DEFAUT, HAUTEUR_DEFAUT));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    private Icon creerIconeEpaisseur() {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                // Configurer le style de dessin
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dessiner un cercle représentant l'épaisseur
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(1f));

                // Dessiner un cercle rempli dont le diamètre correspond à l'épaisseur
                int diametre = epaisseur * 2;
                g2d.fillOval(x + (LARGEUR_DEFAUT - diametre) / 2,
                        y + (HAUTEUR_DEFAUT - diametre) / 2,
                        diametre,
                        diametre);

                g2d.dispose();
            }

            @Override
            public int getIconWidth() {
                return LARGEUR_DEFAUT;
            }

            @Override
            public int getIconHeight() {
                return HAUTEUR_DEFAUT;
            }
        };
    }

    // Getter pour l'épaisseur
    public int getEpaisseur() {
        return epaisseur;
    }
}
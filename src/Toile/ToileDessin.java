package Toile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Forme.*;
import Forme.RectangleForme;
import Button.ThicknessButton;

public class ToileDessin extends JPanel {
    private final ArrayList<Forme> formes = new ArrayList<>();
    private String outilCourant = "Crayon";
    private Color couleurCourante = Color.BLACK;
    private Point debutDessin = null;
    private Point finDessin = null;
    private int epaisseureTrait = 1;
    private ThicknessButton thicknessButton = new ThicknessButton(epaisseureTrait);


    public ToileDessin() {
        setBackground(Color.WHITE);

        // Gestion des événements de souris
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                debutDessin = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                finDessin = e.getPoint();

                // Création de la forme selon l'outil sélectionné
                Forme nouvelleForme = switch (outilCourant) {
                    case "Ligne" -> new Ligne(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    case "Rectangle" -> new RectangleForme(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    case "Cercle" -> new Cercle(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    case "Triangle" -> new Triangle(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    default -> null;
                };

                if (nouvelleForme != null) {
                    formes.add(nouvelleForme);
                }

                repaint();
            }
        });

        // Gestion du dessin au crayon
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (outilCourant.equals("Crayon")) {
                    Ligne ligneCrayon = new Ligne(debutDessin, e.getPoint(), couleurCourante, epaisseureTrait);
                    formes.add(ligneCrayon);
                    debutDessin = e.getPoint();
                    repaint();
                }
            }
        });
    }

    public void changerOutil(String outil) {
        this.outilCourant = outil;

        // Gestion de l'outil Effacer
        if (outil.equals("Effacer")) {
            formes.clear();
            repaint();
        }
    }

    public void changerCouleur(Color couleur) {
        this.couleurCourante = couleur;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Forme forme : formes) {
            g2.setStroke(new BasicStroke(epaisseureTrait));
            forme.dessiner(g);
        }
    }

    public void changerEpaisseur(int epaisseur) {
        this.epaisseureTrait = epaisseur;
    }


}
package Toile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Forme.*;
import Forme.RectangleForme;
import Button.ThicknessButton;

/**
 * Classe `ToileDessin` qui gère la surface de dessin avec différents outils, couleurs et épaisseurs de traits.
 * Cette classe est responsable de la gestion des événements de souris pour dessiner sur le panneau et de l'affichage des formes dessinées.
 */
public class ToileDessin extends JPanel {
    private final ArrayList<Forme> formes = new ArrayList<>(); // Liste des formes dessinées
    private String outilCourant = "Crayon"; // Outil actuellement sélectionné
    private Color couleurCourante = Color.BLACK; // Couleur actuelle
    private Point debutDessin = null; // Point de départ du dessin
    private Point finDessin = null; // Point final du dessin
    private int epaisseureTrait = 1; // Épaisseur du trait
    private ThicknessButton thicknessButton = new ThicknessButton(epaisseureTrait); // Bouton pour choisir l'épaisseur du trait

    /**
     * Constructeur de la toile de dessin.
     * Initialise les paramètres et gère les événements de souris pour dessiner.
     */
    public ToileDessin() {
        setBackground(Color.WHITE); // Fond de la toile de dessin

        // Gestion des événements de souris (appui et relâchement)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                debutDessin = e.getPoint(); // Enregistrer le point de départ du dessin
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                finDessin = e.getPoint(); // Enregistrer le point final du dessin

                // Création de la forme selon l'outil sélectionné
                Forme nouvelleForme = switch (outilCourant) {
                    case "Ligne" -> new Ligne(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    case "Rectangle" -> new RectangleForme(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    case "Cercle" -> new Cercle(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    case "Triangle" -> new Triangle(debutDessin, finDessin, couleurCourante, epaisseureTrait);
                    default -> null;
                };

                if (nouvelleForme != null) {
                    formes.add(nouvelleForme); // Ajouter la forme à la liste des formes
                }

                repaint(); // Repeindre la toile après avoir ajouté la forme
            }
        });

        // Gestion du dessin au crayon (lors du glissement de la souris)
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (outilCourant.equals("Crayon")) {
                    Ligne ligneCrayon = new Ligne(debutDessin, e.getPoint(), couleurCourante, epaisseureTrait);
                    formes.add(ligneCrayon); // Ajouter la ligne à la liste des formes
                    debutDessin = e.getPoint(); // Mettre à jour le point de départ pour dessiner
                    repaint(); // Repeindre la toile
                }
            }
        });
    }

    /**
     * Change l'outil de dessin actuellement sélectionné.
     * Si l'outil sélectionné est "Effacer", toutes les formes sont supprimées.
     *
     * @param outil L'outil sélectionné (Crayon, Ligne, Rectangle, etc.).
     */
    public void changerOutil(String outil) {
        this.outilCourant = outil;

        // Gestion de l'outil "Effacer"
        if (outil.equals("Effacer")) {
            formes.clear(); // Effacer toutes les formes
            repaint(); // Repeindre la toile
        }
    }

    /**
     * Change la couleur de dessin actuelle.
     *
     * @param couleur La couleur sélectionnée pour le dessin.
     */
    public void changerCouleur(Color couleur) {
        this.couleurCourante = couleur; // Mettre à jour la couleur
    }

    /**
     * Méthode pour dessiner toutes les formes sur la toile.
     * Cette méthode est appelée lors du rafraîchissement de la toile.
     *
     * @param g L'objet Graphics utilisé pour dessiner.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Forme forme : formes) {
            g2.setStroke(new BasicStroke(epaisseureTrait)); // Définir l'épaisseur du trait
            forme.dessiner(g); // Dessiner la forme
        }
    }

    /**
     * Change l'épaisseur du trait de dessin.
     *
     * @param epaisseur La nouvelle épaisseur du trait.
     */
    public void changerEpaisseur(int epaisseur) {
        this.epaisseureTrait = epaisseur; // Mettre à jour l'épaisseur
    }
}

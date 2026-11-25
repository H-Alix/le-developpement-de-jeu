
public class GestionDeplacement {

    // ==============================
    // ATTRIBUTS DE LA CLASSE
    // ==============================

    // Coordonnées de la position choisie par le joueur
    private int selectedCoordQ;
    private int selectedCoordR;
    private int selectedCoordS;


    // ==============================
    // CONSTRUCTEUR
    // ==============================

    // Initialise les coordonnées sélectionnées
    public GestionDeplacement() {

        selectedCoordQ = 0;
        selectedCoordR = 0;
        selectedCoordS = 0;
    }


    // ==============================
    // CHOIX DE LA POSITION
    // ==============================

    // Enregistre les coordonnées de la destination choisie
    public void nextPosChoice(int q, int r, int s) {

        selectedCoordQ = q;
        selectedCoordR = r;
        selectedCoordS = s;

        System.out.println("Position sélectionnée : Q="
                + q + ", R=" + r + ", S=" + s);
    }


    // ==============================
    // VERIFICATION DU DEPLACEMENT
    // ==============================

    // Vérifie si une unité peut atteindre la destination
    public boolean mouvementPossible(
            int currentQ,
            int currentR,
            int currentS,
            int deplacementMax,
            boolean obstacle,
            boolean caseOccupee) {

        // Vérifie si la destination contient un obstacle
        if (obstacle) {
            System.out.println("Déplacement impossible : obstacle.");
            return false;
        }

        // Vérifie si la destination est déjà occupée
        if (caseOccupee) {
            System.out.println("Déplacement impossible : case occupée.");
            return false;
        }

        // Calcul de la distance entre deux cases hexagonales
        int distanceQ = Math.abs(selectedCoordQ - currentQ);
        int distanceR = Math.abs(selectedCoordR - currentR);
        int distanceS = Math.abs(selectedCoordS - currentS);

        // La distance hexagonale correspond à la plus grande différence
        int distance = Math.max(distanceQ,
                Math.max(distanceR, distanceS));

        // Vérifie si la distance respecte la capacité de déplacement
        if (distance > deplacementMax) {
            System.out.println("Déplacement impossible : distance trop grande.");
            return false;
        }

        return true;
    }


    // ==============================
    // MISE A JOUR DE LA POSITION
    // ==============================

    // Actualise les coordonnées sélectionnées après validation
    public void updatePos() {

        System.out.println("Nouvelle position validée : Q="
                + selectedCoordQ
                + ", R=" + selectedCoordR
                + ", S=" + selectedCoordS);
    }


    // ==============================
    // GETTERS
    // ==============================

    // Retourne la coordonnée Q sélectionnée
    public int getSelectedCoordQ() {
        return selectedCoordQ;
    }

    // Retourne la coordonnée R sélectionnée
    public int getSelectedCoordR() {
        return selectedCoordR;
    }

    // Retourne la coordonnée S sélectionnée
    public int getSelectedCoordS() {
        return selectedCoordS;
    }
}

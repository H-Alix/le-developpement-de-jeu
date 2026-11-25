
public class GestionScore {

    // ==============================
    // ATTRIBUTS DE LA CLASSE
    // ==============================

    // Score actuel du joueur 1
    private int scoreJ1;

    // Score actuel du joueur 2
    private int scoreJ2;

    // Score nécessaire pour gagner la partie
    private int scoreFin;


    // ==============================
    // CONSTRUCTEUR
    // ==============================

    // Initialise les scores et définit le score final
    public GestionScore() {

        scoreJ1 = 0;
        scoreJ2 = 0;

        // Un joueur doit atteindre 100 points pour gagner
        scoreFin = 100;
    }


    // ==============================
    // ACTUALISATION DES SCORES
    // ==============================

    // Ajoute des points en fonction du nombre d'objectifs contrôlés
    public void actualiserScore(
            int objectifsJ1,
            int objectifsJ2) {

        // Vérifie que les nombres d'objectifs sont valides
        if (objectifsJ1 < 0 || objectifsJ2 < 0) {
            System.out.println("Nombre d'objectifs invalide.");
            return;
        }

        // Ajoute les points correspondant aux objectifs du joueur 1
        scoreJ1 += objectifsJ1;

        // Ajoute les points correspondant aux objectifs du joueur 2
        scoreJ2 += objectifsJ2;

        // Empêche les scores de dépasser le score final
        scoreJ1 = Math.min(scoreJ1, scoreFin);
        scoreJ2 = Math.min(scoreJ2, scoreFin);

        // Affiche les scores après actualisation
        afficherScores();
    }


    // ==============================
    // AFFICHAGE DES SCORES
    // ==============================

    // Affiche la progression des deux joueurs
    public void afficherScores() {

        System.out.println("========== SCORES ==========");

        System.out.println("Joueur 1 : " + scoreJ1
                + " / " + scoreFin);

        System.out.println("Joueur 2 : " + scoreJ2
                + " / " + scoreFin);

        System.out.println("============================");
    }


    // ==============================
    // VERIFICATION DU VAINQUEUR
    // ==============================

    // Vérifie si un joueur a atteint le score final
    public boolean verifierVainqueur() {

        if (scoreJ1 >= scoreFin) {

            System.out.println("Le joueur 1 a remporté la partie !");
            return true;

        } else if (scoreJ2 >= scoreFin) {

            System.out.println("Le joueur 2 a remporté la partie !");
            return true;
        }

        // Aucun joueur n'a encore gagné
        return false;
    }


    // ==============================
    // GETTERS
    // ==============================

    // Retourne le score du joueur 1
    public int getScoreJ1() {
        return scoreJ1;
    }

    // Retourne le score du joueur 2
    public int getScoreJ2() {
        return scoreJ2;
    }

    // Retourne le score nécessaire pour gagner
    public int getScoreFin() {
        return scoreFin;
    }
}

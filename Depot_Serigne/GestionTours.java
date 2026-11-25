
import java.util.Random;

public class GestionTours {

    // ==============================
    // ATTRIBUTS DE LA CLASSE
    // ==============================

    // Numéro de la manche actuelle
    private int numeroManche;

    // Les deux joueurs qui participent à la partie
    private Joueur joueur1;
    private Joueur joueur2;

    // Joueur qui est actuellement en train de jouer
    private Joueur joueurActuel;


    // ==============================
    // CONSTRUCTEUR
    // ==============================

    // Initialise les deux joueurs et le numéro de la première manche
    public GestionTours(Joueur joueur1, Joueur joueur2) {

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;

        // La partie commence à la première manche
        this.numeroManche = 1;

        // Aucun joueur n'est encore désigné
        this.joueurActuel = null;
    }


    // ==============================
    // TIRAGE AU SORT DU PREMIER JOUEUR
    // ==============================

    // Détermine aléatoirement quel joueur commence la partie
    public void tirageOrdreTour() {

        // Création d'un générateur de nombres aléatoires
        Random random = new Random();

        // Génère un nombre aléatoire : 0 ou 1
        int resultat = random.nextInt(2);

        // Si le résultat est 0, le joueur 1 commence
        if (resultat == 0) {

            joueurActuel = joueur1;

        } else {

            // Sinon, c'est le joueur 2 qui commence
            joueurActuel = joueur2;
        }

        // Affiche le nom du joueur qui commence
        System.out.println("Le premier joueur est : "
                + joueurActuel.getNom());
    }


    // ==============================
    // DÉMARRAGE DE LA PARTIE
    // ==============================

    // Initialisation du déroulement de la partie
    public void demarrerPartie() {

        // Réinitialisation du numéro de manche
        numeroManche = 1;

        // Désignation aléatoire du premier joueur
        tirageOrdreTour();

        // Affichage du début de la partie
        System.out.println("Début de la partie !");
        System.out.println("Manche : " + numeroManche);
    }


    // ==============================
    // PASSAGE AU JOUEUR SUIVANT
    // ==============================

    // Termine le tour du joueur actuel et donne la main à l'autre joueur
    public void passerTour() {

        // Vérifie si la partie a bien été démarrée
        if (joueurActuel == null) {

            System.out.println("La partie n'a pas encore commencé.");
            return;
        }

        // Si le joueur actuel est le joueur 1
        if (joueurActuel == joueur1) {

            // Le joueur 2 prend la main
            joueurActuel = joueur2;

        } else {

            // Sinon, le joueur 1 prend la main
            joueurActuel = joueur1;

            // Une nouvelle manche commence
            numeroManche++;
        }

        // Affiche le numéro de la manche actuelle
        System.out.println("Manche : " + numeroManche);

        // Affiche le joueur qui doit maintenant jouer
        System.out.println("C'est au tour de : "
                + joueurActuel.getNom());
    }


    // ==============================
    // GETTERS
    // ==============================

    // Retourne le joueur qui doit actuellement jouer
    public Joueur getJoueurActuel() {
        return joueurActuel;
    }

    // Retourne le numéro de la manche actuelle
    public int getNumeroManche() {
        return numeroManche;
    }
}

/**
 * Classe principale du jeu TacticalWar.
 * Gère le lancement de l'application, l'initialisation de la fenêtre graphique
 * du plateau de jeu, le tirage au sort de l'ordre de jeu ainsi que le
 * déroulement des tours de la partie.
 *
 * @author Duane Marchais
 */

import java.util.Random;
import javax.swing.JFrame;
public class Main {

    private final String nameGame = "TacticalWar";

     /**
     * Tire au sort quel joueur commence la partie.
     *
     * @return 1 si le Joueur 1 commence, 2 si le Joueur 2 commence.
     */
    public int tirageOrdreTour() {
        Random random = new Random();
        return random.nextInt(2) + 1; // Retourne 1 (Joueur 1) ou 2 (Joueur 2)
    }

     /**
     * Exécute l'ensemble des phases d'un tour complet de jeu.

     * Un tour se compose successivement :

     *De la phase de déplacement puis d'attaque du premier joueur 
     *De la phase de déplacement puis d'attaque du second joueur
     *Du calcul des points de capture des objectifs en fin de tour
     *De l'incrémentation du compteur de tours
     * 
     * @author Duane Marchais
     * @param numeroTour le numéro du tour actuel
     * @param joueurA    l'identifiant du premier joueur à jouer durant ce tour
     * @param joueurB    l'identifiant du second joueur à jouer durant ce tour
     */

    public void deroulementTour(int numeroTour, int joueurA, int joueurB) {
        System.out.println("\n================ TOUR N° " + numeroTour + " ================");
        //Tour du Joueur A
        System.out.println("-> Tour du Joueur " + joueurA + " :");
        
        System.out.println("   [Phase Déplacement - Joueur " + joueurA + "]");
        // Pour chaque unité du Joueur A :
        // gestionDeplacement.MouvementPossible();
        // gestionDeplacement.NextPosChoice();
        // gestionDeplacement.UpdatePos();
        // unite.deplacement(); (vérifier si piege)

        System.out.println("   [Phase Attaque - Joueur " + joueurA + "]");
        // Pour chaque unité vivante du Joueur A :
        // gestionAttaque.SelectTarget();
        // if (gestionAttaque.IsTargetInRange()) {
        //     gestionAttaque.IsTargetArmorPierced();
        //     gestionAttaque.DamageTarget(); // appelle cible.takeDamage tue la cible si hp<0
        // }

        // --- 2. Phase du second joueur (joueurB) ---
        System.out.println("-> Tour du Joueur " + joueurB + " :");
        System.out.println("   [Phase Déplacement - Joueur " + joueurB + "]");
        // gestionDeplacement.MouvementPossible();
        // gestionDeplacement.NextPosChoice();
        // gestionDeplacement.UpdatePos();
        // unite.deplacement();
        System.out.println("   [Phase Attaque - Joueur " + joueurB + "]");
        // gestionAttaque.SelectTarget();
        // if (gestionAttaque.IsTargetInRange()) {
        //     gestionAttaque.IsTargetArmorPierced();
        //     gestionAttaque.DamageTarget();
        // }

        // --- 3. Fin de tour : Capture des Objectifs et mise à jour des Scores ---
        System.out.println("-> [Fin de tour : Calcul des points stratégiques (Objectifs)]");
        // Pour chaque Objectif de la carte :
        // objectifs.CurrentObjectiveState();
        // - Si occupé uniquement par une équipe :(10 points)
        // - Si contesté (les 2 équipes présentes) : (5 points)
        // - Si inoccupé : +0 point
        // gestionScore.progressionCapture();
        // j1.setScore(...);
        // j2.setScore(...);
        // --- 4. Passage au tour suivant ---
        System.out.println("-> [Passage au tour suivant (COUNTER + 1)]");
        // gestionTours.incrementerTour();
    }

     /**
     * Point d'entrée principal de l'application.
     * Initialise le monde et affiche la fenêtre graphique,
     * prépare les joueurs et leurs armées, puis lance la boucle des tours de jeu.
     * @author Duane Marchais
     * @param args 
     */

    public static void main(String[] args) {
        Main game = new Main();
        World monde = new World(10, 20);
        JFrame f = new JFrame("TacticalWar_BETA");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Affichage(monde));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);


        // 1. Création des joueurs et choix des factions
        System.out.println(" Création du Joueur 1 et du Joueur 2...");
        // Joueur j1 = new Joueur(1, "Joueur 1");
        // Joueur j2 = new Joueur(2, "Joueur 2");
        // j1.selectArmee();
        // j2.selectArmee();

         // 2. Composition des armées (budget / nombre d'unités)
        System.out.println("Composition des armées (Création d'armée)...");
        // CreationArmee creationArmee = new CreationArmee();
        // creationArmee.composerArmee(j1);
        // creationArmee.composerArmee(j2);

        // // 4. Tirage au sort du joueur qui commence
        // int premierJoueur = jeu.tirageOrdreTour();

        // if (premierJoueur == 1) {
        //     System.out.println("Le Joueur 1 commence la partie !");
        // } else {
        //     System.out.println("Le Joueur 2 commence la partie !");
        // }

        // // 5. Déroulement des tours
        // int numeroTour = 1;
        // while (numerotour <= numeroTourFin) { 
        //     if (premierJoueur == 1) {
        //         game.deroulementTour(numeroTour, 1, 2);
        //     } else {
        //         game.deroulementTour(numeroTour, 2, 1);
        //     }
        //     numeroTour++;
        // }
       
    }
}


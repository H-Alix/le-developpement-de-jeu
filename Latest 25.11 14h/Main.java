import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;
public class Main {

    private final String nameGame = "TacticalWar";

    public int tirageOrdreTour() {
        Random random = new Random();
        return random.nextInt(2) + 1; // Retourne 1 (Joueur 1) ou 2 (Joueur 2)
    }


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

    public static void main(String[] args) {
        Main game = new Main();
        World monde = new World(10, 20);
        JFrame frame = new JFrame("TacticalWar_BETA");
        Affichage Affi = new Affichage(monde);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(Affi);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Affi.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse){
                Hex HexClicked = Affi.getHexFromCoords(mouse.getX(), mouse.getY());
                if (HexClicked != null){
                    System.out.println("q=" + HexClicked.q + " r = " + HexClicked.r + "s = " + HexClicked.s);
                }
                System.out.println(mouse.getX()+ "," + mouse.getY());
            }
        });
        


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
        Joueur j1 = new Joueur(1, "Joueur 1");
        Joueur j2 = new Joueur(2, "Joueur 2");
        j1.selectArmee(TypeOfArmy.HUMAN);
        j2.selectArmee(TypeOfArmy.ORK);

        // Création de 2 unités de test (attention : q + r + s doit toujours faire 0 !)
        Infantry uniteJ1 = new Infantry("Space Marine", 100, 3, 4, 25, 10, 5, 0, -9, 4, 5, 10, 1, TypeOfArmy.HUMAN, 5);
        Infantry uniteJ2 = new Infantry("Orkiz", 110, 3, 1, 30, 5, 5, 0, 9, -4, -5, 10, 1, TypeOfArmy.ORK, 10);

        j1.addUnit(uniteJ1);
        j2.addUnit(uniteJ2);

        monde.apparitionTroupes(j1, j2);
       
    }
}
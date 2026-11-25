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

        // 1. Création des joueurs et choix des factions
        System.out.println("Création du Joueur 1 et du Joueur 2...");
        Joueur j1 = new Joueur(1, "Joueur 1");
        Joueur j2 = new Joueur(2, "Joueur 2");
        j1.selectArmee(TypeOfArmy.HUMAN);
        j2.selectArmee(TypeOfArmy.ORK);

        // 2. Composition des armées (budget / nombre d'unités)
        System.out.println("Composition des armées (Création d'armée)...");
        // CreationArmee creationArmee = new CreationArmee();
        // creationArmee.composerArmee(j1);
        // creationArmee.composerArmee(j2);

        // Création de 2 unités de test (8e paramètre = spritePath en String, et q + r + s = 0)
        Infantry uniteJ1 = new Infantry("Space Marine", 100, 3, 4, 25, 10, 5, "", -9, 4, 5, 10, 1, TypeOfArmy.HUMAN, 5);
        Infantry uniteJ2 = new Infantry("Orkiz", 110, 3, 1, 30, 5, 5, "", 9, -4, -5, 10, 1, TypeOfArmy.ORK, 10);

        j1.addUnit(uniteJ1);
        j2.addUnit(uniteJ2);

        // 3. Placement des troupes dans le World AVANT d'afficher la fenêtre
        monde.apparitionTroupes(j1, j2);

        // 4. Affichage de la fenêtre et détection des clics souris
        JFrame frame = new JFrame(game.nameGame + "_BETA");
        Affichage Affi = new Affichage(monde);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(Affi);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Decor decor1 = new Decor(" ", monde);
        Decor decor2 = new Decor(" ", monde);
        Decor decor3 = new Decor(" ", monde);
        Decor decor4 = new Decor(" ", monde);
        Decor decor5 = new Decor(" ", monde);
        Decor decor6 = new Decor(" ", monde);

        Affi.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse) {
                Hex HexClicked = Affi.getHexFromCoords(mouse.getX(), mouse.getY());
                if (HexClicked != null) {
                    System.out.println("q=" + HexClicked.q + " r=" + HexClicked.r + " s=" + HexClicked.s);
                }
                System.out.println(mouse.getX() + "," + mouse.getY());
            }
        });

        // 5. Tirage au sort et déroulement des tours (avec GestionTours plus tard)
        // GestionTours gestionTours = new GestionTours(j1, j2);
        // gestionTours.demarrerPartie();
    }
}

import java.util.ArrayList;
/**
 * Classe représentant un joueur dans le jeu ainsi que ses caractéristiques et certaines actions possibles avant le début de la partie.
 * 
 * @author Duane Marchais
 */

public class Joueur {

    private int id;
    private String nom;
    private int score;

    // Placeholders tant que les classes Unite et Faction  sotn pas fini
    private Armee armee;

    public Joueur(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.score = 0;
        this.armee = null;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int p_score) {
        this.score = p_score;
    }

    public Armee getArmee() {
        return armee;
    }

    public ArrayList<Unit> getListUnit() {
        if (armee == null) {
            return new ArrayList<>();
        }

        return armee.getUnites();
    }

    /**
     * Permet au joueur de choisir sa faction (HUMAIN ou ORK).
     */
    public void selectArmee(String p_faction) {

        if (p_faction == null) {
            System.out.println("Aucune faction sélectionnée.");
            return;
        }

        if (p_faction.equalsIgnoreCase("HUMAN")) {
            this.armee = new ArmeeHumaine();

        } else if (p_faction.equalsIgnoreCase("ORK")) {
            this.armee = new ArmeeOrc();

        } else {
            System.out.println("Faction inconnue.");
            return;
        }

        System.out.println(this.nom + " a choisi l'armée : "
                + this.armee.getFaction());
    }
}
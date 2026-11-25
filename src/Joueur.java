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
    
    private ArrayList<Unit> listUnit; 
    private TypeOfArmy armee;

    public Joueur(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.score = 0;
        this.listUnit = new ArrayList<>();
        this.armee = null; // L'armée sera choisie par le joueur avant le début de la partie
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

     public TypeOfArmy getArmee() {
        return armee;
    }

      public ArrayList<Unit> getListUnit() { 
        return listUnit;
    }
      public void addUnit(Unit p_unit) {
        this.listUnit.add(p_unit);
    }

    /**
     * Permet au joueur de choisir sa faction (HUMAIN ou ORK).
     */
    public void selectArmee(TypeOfArmy p_faction) {
        this.armee = p_faction;
        System.out.println(this.nom + " a choisi l'armée : " + this.armee);
    }
}
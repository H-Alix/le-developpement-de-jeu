
import java.util.ArrayList;

public class Armee {

    protected TypeOfArmy faction;
    protected ArrayList<Unit> unites;

    public Armee(TypeOfArmy faction) {
        this.faction = faction;
        this.unites = new ArrayList<>();
    }

    // Retourne la faction de l'armée
    public TypeOfArmy getFaction() {
        return faction;
    }

    // Retourne la liste des unités de l'armée
    public ArrayList<Unit> getUnites() {
        return unites;
    }

    // Ajoute une unité si elle appartient à la bonne faction
    public void ajouterUnite(Unit unite) {

        if (unite == null) {
            System.out.println("Impossible d'ajouter une unité nulle.");
            return;
        }

        if (unite.getFaction() != this.faction) {
            System.out.println("Cette unité n'appartient pas à cette armée.");
            return;
        }

        unites.add(unite);

        System.out.println(unite.getName() + " a rejoint l'armée.");
    }

    // Affiche les informations de l'armée
    public void afficherArmee() {
        System.out.println("Faction : " + faction);
        System.out.println("Nombre d'unités : " + unites.size());
    }
}

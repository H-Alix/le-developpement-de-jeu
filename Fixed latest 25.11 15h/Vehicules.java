/** Classe de base des véhicules, conformément au diagramme UML. */
public class Vehicules extends Unit {

    protected int captureValeur;

    public Vehicules(String name, int healthPoint, int move, int attackRange,
                     int attackDamage, int armor, int penetrationArmor,
                     String spritePath, int currentCoordQ, int currentCoordR,
                     int currentCoordS, int unitCost, int unitHeight,
                     TypeOfArmy faction, int captureValeur) {
        super(name, healthPoint, move, attackRange, attackDamage, armor,
              penetrationArmor, spritePath, currentCoordQ, currentCoordR,
              currentCoordS, unitCost, unitHeight, faction);
        this.captureValeur = captureValeur;
    }

    public int getCaptureValeur() {
        return captureValeur;
    }
}

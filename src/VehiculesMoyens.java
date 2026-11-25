/** Véhicule moyen, doté d'un rayon d'explosion. */
public class VehiculesMoyens extends Vehicules {

    private int BlastRadius;

    public VehiculesMoyens(String name, int healthPoint, int move, int attackRange,
                           int attackDamage, int armor, int penetrationArmor,
                           int spritePath, int currentCoordQ, int currentCoordR,
                           int currentCoordS, int unitCost, int unitHeight,
                           TypeOfArmy faction, int captureValeur, int BlastRadius) {
        super(name, healthPoint, move, attackRange, attackDamage, armor,
              penetrationArmor, spritePath, currentCoordQ, currentCoordR,
              currentCoordS, unitCost, unitHeight, faction, captureValeur);
        this.BlastRadius = BlastRadius;
    }

    public void attaqueImmobile() {
        // Le diagramme ne précise ni cible ni effet pour cette opération.
    }
}

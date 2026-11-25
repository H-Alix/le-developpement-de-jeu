/** Véhicule lourd, spécialisé dans l'attaque des véhicules. */
public class VehiculesLourds extends Vehicules {

    public VehiculesLourds(String name, int healthPoint, int move, int attackRange,
                           int attackDamage, int armor, int penetrationArmor,
                           int spritePath, int currentCoordQ, int currentCoordR,
                           int currentCoordS, int unitCost, int unitHeight,
                           TypeOfArmy faction, int captureValeur) {
        super(name, healthPoint, move, attackRange, attackDamage, armor,
              penetrationArmor, spritePath, currentCoordQ, currentCoordR,
              currentCoordS, unitCost, unitHeight, faction, captureValeur);
    }

    public void attaqueAntiVehicule(Unit p_unit) {
        attack(p_unit);
    }
}

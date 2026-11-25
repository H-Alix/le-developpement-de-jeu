/** Véhicule léger, avec sa capacité d'attaque rapide. */
public class VehiculesLegers extends Vehicules {

    public VehiculesLegers(String name, int healthPoint, int move, int attackRange,
                           int attackDamage, int armor, int penetrationArmor,
                           int spritePath, int currentCoordQ, int currentCoordR,
                           int currentCoordS, int unitCost, int unitHeight,
                           TypeOfArmy faction, int captureValeur) {
        super(name, healthPoint, move, attackRange, attackDamage, armor,
              penetrationArmor, spritePath, currentCoordQ, currentCoordR,
              currentCoordS, unitCost, unitHeight, faction, captureValeur);
    }

    public void attaqueRapide(Unit p_unit) {
        attack(p_unit);
    }
}

package Latest

public class MediumInfantry extends Infantry {

    protected boolean ignoreCouverture;

    public MediumInfantry(String name, int healthPoint, int move, int attackRange, int attackDamage,
                          int armor, int penetrationArmor, int spritePath, int currentCoordQ,
                          int currentCoordR, int currentCoordS, int unitCost, int unitHeight,
                          TypeOfArmy faction, int squadSize, boolean ignoreCouverture) {
        super(name, healthPoint, move, attackRange, attackDamage,
                armor, penetrationArmor, spritePath, currentCoordQ,
                currentCoordR, currentCoordS, unitCost, unitHeight,
                faction, squadSize);
        this.ignoreCouverture = ignoreCouverture;
    }

    // Attaque moyenne : à définir avec le groupe
    public void averageAttack() {
        // exemple : attaque avec les dégâts normaux
    }
}
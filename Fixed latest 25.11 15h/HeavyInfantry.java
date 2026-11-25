public class HeavyInfantry extends Infantry {

    protected int resetCounter;

    public HeavyInfantry(String name, int healthPoint, int move, int attackRange, int attackDamage,
                         int armor, int penetrationArmor, String spritePath, int currentCoordQ,
                         int currentCoordR, int currentCoordS, int unitCost, int unitHeight,
                         TypeOfArmy faction, int squadSize, int resetCounter) {
        super(name, healthPoint, move, attackRange, attackDamage,
                armor, penetrationArmor, spritePath, currentCoordQ,
                currentCoordR, currentCoordS, unitCost, unitHeight,
                faction, squadSize);
        this.resetCounter = resetCounter;
    }

    // Attaque reset : remet le compteur à 0
    public void attaqueReset() {
        this.resetCounter = 0;
    }
}

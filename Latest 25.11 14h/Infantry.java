package Latest

public class Infantry extends Unit {

    protected int squadSize;

    public Infantry(String name, int healthPoint, int move, int attackRange, int attackDamage,
                    int armor, int penetrationArmor, int spritePath, int currentCoordQ,
                    int currentCoordR, int currentCoordS, int unitCost, int unitHeight,
                    TypeOfArmy faction, int squadSize) {
        super(name, healthPoint, move, attackRange, attackDamage,
                armor, penetrationArmor, spritePath, currentCoordQ,
                currentCoordR, currentCoordS, unitCost, unitHeight,
                faction);
        this.squadSize = squadSize;
    }

    public int getSquadSize() {
        return this.squadSize;
    }
}
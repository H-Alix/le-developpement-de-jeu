package Latest

public class LightInfantry extends Infantry {

    public LightInfantry(String name, int healthPoint, int move, int attackRange, int attackDamage,
                         int armor, int penetrationArmor, int spritePath, int currentCoordQ,
                         int currentCoordR, int currentCoordS, int unitCost, int unitHeight,
                         TypeOfArmy faction, int squadSize) {
        super(name, healthPoint, move, attackRange, attackDamage,
                armor, penetrationArmor, spritePath, currentCoordQ,
                currentCoordR, currentCoordS, unitCost, unitHeight,
                faction, squadSize);
    }

    // Sprint : l'unité court et gagne 1 point de déplacement
    public void sprint() {this.move += 1;
    }
}
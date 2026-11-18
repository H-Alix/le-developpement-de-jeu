public class Unit {
    protected String name ;

    protected int healthPoint ;
    protected int move ;
    protected int attackRange ;
    protected int attackDamage ;
    protected int armor ;
    protected int penetrationArmor ;

    protected int spritePath ;
    protected int currentCoordQ ;
    protected int currentCoordR ;
    protected int currentCoordS ;

    protected int unitCost ;
    protected int unitHeight ;

    public enum typeOfArmy ;
 
}

public Unit (String name, int healthPoint, int move, int attackRange, int attackDamage, int armor, int penetrationArmor, 
            int spritePath, int currentCoordQ, int currentCoordR, int currentCoordS, int unitCost, int unitHeight) {
                this.name = name ;
                this.healthPoint = healthPoint ;
                this.move = move ;
                this.attackRange = attackRange ;
                this.attackDamage = attackDamage ;
                this.armor = armor ;
                this.penetrationArmor = penetrationArmor ;
                this.spritePath = spritePath ;
                this.currentCoordQ = currentCoordQ ;
                this.currentCoordR = currentCoordR ;
                this.currentCoordS = currentCoordS ;
                this.unitCost = unitCost ;
                this.unitHeight = unitHeight ;
}

public int getName () {
    return this.name ;
}

public int getHealthPoint () {
    return this.healthPoint ;
}

public int getUnitCost () {
    return this.unitCost ;
}

public int getUnitHeight () {
    return this.unitHeight ;
}

public int TypeOfArmy () {
    return this.typeOfArmy ;
}

public int getCurrentCoordQ () {
    return this.currentCoordQ ;
}

public int getCurrentCoordR () {
    return this.currentCoordR ;
}

public int getCurrentCoordS () {
    return this.currentCoordS ;
}

public int getMove () {
    return this.move ;
}

public void moveUnit (int newCoordQ, int newCoordR, int newCoordS) {
    this.currentCoordQ = newCoordQ ;
    this.currentCoordR = newCoordR ;
    this.currentCoordS = newCoordS ;
}

public void takeDamage (int damage) {
    this.healthPoint -= damage ;
}

public void death () {
    this.healthPoint = 0 ;
}

public void attack (Unit target) {
    int damage = this.attackDamage - target.armor ;
    if (damage < 0) {
        damage = 0 ;
    }
    target.takeDamage(damage) ;
}

public void unitCost (int cost) {
    this.unitCost = cost ;
}

public void unitHeight (int height) {
    this.unitHeight = height ;
}

public void setName (String name) {
    this.name = name ;
}

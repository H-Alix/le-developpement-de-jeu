public class Environment {
    private TypeOfTrap typeOfTrap ;
    private int numberOfTrap ;
    private int damageOfTrap ;
    private String SpritePath ;

    public Environment(TypeOfTrap typeOfTrap, int numberOfTrap, int damageOfTrap, String spritePath) {
        this.typeOfTrap = typeOfTrap;
        this.numberOfTrap = numberOfTrap;
        this.damageOfTrap = damageOfTrap;
        SpritePath = spritePath;
    }

    public TypeOfTrap getTypeOfTrap() {
        return typeOfTrap;
    }

    public int getNumberOfTrap() {
        return numberOfTrap;
    }

    public int getDamageOfTrap() {
        return damageOfTrap;
    }

    public String getSpritePath() {
        return SpritePath;
    }

    public void setTypeOfTrap(TypeOfTrap typeOfTrap) {
        this.typeOfTrap = typeOfTrap;
    }

    // Limite du nombre de pièges dans la map à 3 

    public void setNumberOfTrap(int numberOfTrap) {
        if (numberOfTrap > 3) {
            this.numberOfTrap = 3;
        } else {
            this.numberOfTrap = numberOfTrap;
        }
    }

    // Limite les dégâts d'un piège à 10 HP

    public void setDamageOfTrap(int damageOfTrap) {
        if (damageOfTrap > 10) {
            this.damageOfTrap = 10;
        } else {
            this.damageOfTrap = damageOfTrap;
        }
    }

    public void setSpritePath(String spritePath) {
        SpritePath = spritePath;
    }


}
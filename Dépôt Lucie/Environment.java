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
        // Ici on limite les dégâts en fonction du type de piège (BOMB ou SPIKE).
        if (typeOfTrap == TypeOfTrap.BOMB) {
            this.damageOfTrap = 10;
        } 
        else if (typeOfTrap == TypeOfTrap.SPIKE) {
            this.damageOfTrap = 5;
        }

        // Ici on limite les dégâts pour ne pas tomber en dessous de 0 ou au dessus de 10 HP.
        else if (damageOfTrap < 0) {
            this.damageOfTrap = 0;
        } 
        else if (damageOfTrap > 10) {
            this.damageOfTrap = 10;
        } 
        else {
            this.damageOfTrap = damageOfTrap;
        }
    }

    public void setSpritePath(String spritePath) {
        SpritePath = spritePath;
    }

    public void displayEnvironment() {
        System.out.println("Type of Trap: " + typeOfTrap);
        System.out.println("Number of Trap: " + numberOfTrap);
        System.out.println("Damage of Trap: " + damageOfTrap);
        System.out.println("Sprite Path: " + SpritePath);
    }

    // Si le type de piège est de type "BOMB", alors le piège explosera et infligera des dégâts à tous les ennemis dans un rayon de 2 cases.
    // Si le type de piège est de type "SPIKE", alors le piège ne s'activera que si un ennemi marche dessus, infligeant 5 points de dégâts à l'ennemi.
    // Si aucune activation, alors le piège ne fera rien.
    public void activateTrap(){
        if (typeOfTrap == TypeOfTrap.BOMB) {
            System.out.println("The trap explodes and deals " + damageOfTrap + " damage to all enemies within a radius of 2 tiles.");
        } else if (typeOfTrap == TypeOfTrap.SPIKE) {
            System.out.println("The trap activates only when an enemy steps on it, dealing " + damageOfTrap + " damage to the enemy.");
        } else {
            System.out.println("The trap is inactive.");
        }
    }

    // Ici on fait en sorte que le piège n'apparait pas dans le world au niveau des factions, mais il apparait aléatoirement dans le world.
    // On va chercher à ne pas avoir de pièges dans les décors, car ça ne sert à rien
    public void spawnTrapRandomly() {
        // Ici on génère des coordonnées aléatoires pour le piège dans le world.
        int x = (int) (Math.random() * 10); // Génère un nombre aléatoire entre 0 et 9 pour la coordonnée x
        int y = (int) (Math.random() * 10); // Génère un nombre aléatoire entre 0 et 9 pour la coordonnée y
        System.out.println("The trap has spawned at coordinates (" + x + ", " + y + ").");
    }

    public void nospawnTrapInFaction() {
        System.out.println("The trap will not spawn in faction areas.");
    }

    public void noTrapInDecor() {
        System.out.println("The trap will not spawn in decor areas.");
    }

}

    
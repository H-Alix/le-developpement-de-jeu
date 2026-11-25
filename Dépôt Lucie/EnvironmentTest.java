import org.junit.Test;

public class EnvironmentTest {
    // Ici on teste si la méthode setTypeOfTrap fonctionne correctement
    @Test
    public void testSetTypeOfTrap() {
        Environment env = new Environment(TypeOfTrap.BOMB, 0, 0, "sprite.png");
        env.setTypeOfTrap(TypeOfTrap.SPIKE);
        assert(env.getTypeOfTrap() == TypeOfTrap.SPIKE); // Should be set to TypeOfTrap.SPIKE
    }

    // Ici on teste si la méthode setNumberOfTrap limite correctement le nombre de pièges à 3
    @Test 
    public void testSetNumberOfTrap() {
        Environment env = new Environment(TypeOfTrap.BOMB, 0, 0, "sprite.png");
        env.setNumberOfTrap(5);
        assert(env.getNumberOfTrap() == 3); // Should be limited to 3
    }

    // Ici on teste si la méthode setNumberOfTrap fonctionne correctement pour des valeurs inférieures à 3, car on ne veut pas plus de 3 pièges dans le world
    @Test
    public void testSetNumberOfTrapWithinLimit() {
        Environment env = new Environment(TypeOfTrap.BOMB, 0, 0, "sprite.png");
        env.setNumberOfTrap(2);
        assert(env.getNumberOfTrap() == 2); // Should be set to 2
    }

    // Ici on teste si la méthode setDamageOfTrap limite correctement les dégâts à 10 HP
    @Test
    public void testSetDamageOfTrap() {
        Environment env = new Environment(TypeOfTrap.BOMB, 0, 0, "sprite.png");
        env.setDamageOfTrap(15);
        assert(env.getDamageOfTrap() == 10); // Should be limited to 10
    }

    // Ici on teste si la méthode setDamageOfTrap fonctionne correctement pour des valeurs inférieures à 10 HP
    @Test 
    public void testSetDamageOfTrapWithinLimit() {
        Environment env = new Environment(TypeOfTrap.BOMB, 0, 0, "sprite.png");
        env.setDamageOfTrap(5);
        assert(env.getDamageOfTrap() == 5); // Should be set to 5
    }

    @Test 
    public void testSetSpritePath() {
        Environment env = new Environment(TypeOfTrap.BOMB, 0, 0, "sprite.png");
        env.setSpritePath("newSprite.png");
        assert(env.getSpritePath().equals("newSprite.png")); // Should be set to "newSprite.png"
    }

}

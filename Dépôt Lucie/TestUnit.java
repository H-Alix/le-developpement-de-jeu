import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestUnit {
    @Test
        public void testUnitCreation() {
            TypeOfArmy faction = TypeOfArmy.values()[0];
            Unit unit = new Unit("Soldier", 100, 5, 2, 10, 5, 2, 1, 0, 0, 0, 50, 1, faction);

            assertEquals("Soldier", unit.getName());
            assertEquals(100, unit.getHealthPoint());
            assertEquals(50, unit.getUnitCost());
            assertEquals(1, unit.getUnitHeight());
            assertEquals(faction, unit.getFaction());
        }

    @Test
        public void testUnitMovement() {
        TypeOfArmy faction = TypeOfArmy.values()[0];
        Unit unit = new Unit("Soldier", 100, 5, 2, 10, 5, 2, 1, 0, 0, 0, 50, 1, faction);

        unit.moveUnit(1, -1, 0);
        assertEquals(1, unit.getCurrentCoordQ());
        assertEquals(-1, unit.getCurrentCoordR());
        assertEquals(0, unit.getCurrentCoordS());
        }

    @Test
        public void testUnitTakeDamage() {
            TypeOfArmy faction = TypeOfArmy.values()[0];
            Unit unit = new Unit("Soldier", 100, 5, 2, 10, 5, 2, 1, 0, 0, 0, 50, 1, faction);
            unit.takeDamage(30);
            assertEquals(70, unit.getHealthPoint());
        }

    @Test
        public void testUnitDeath() {
            TypeOfArmy faction = TypeOfArmy.values()[0];
            Unit unit = new Unit("Soldier", 100, 5, 2, 10, 5, 2, 1, 0, 0, 0, 50, 1, faction);
            unit.takeDamage(100);
            assertEquals(0, unit.getHealthPoint());
        }

    @Test
        public void testUnitAttack() {
            TypeOfArmy faction = TypeOfArmy.values()[0];
            Unit attacker = new Unit("Soldier", 100, 5, 2, 10, 5, 2, 1, 0, 0, 0, 50, 1, faction);
            Unit target = new Unit("Enemy", 80, 4, 3, 8, 4, 3, 1, 0, 0, 0, 40, 1, TypeOfArmy.values()[1]);
            attacker.attack(target);
            assertEquals(70, target.getHealthPoint());
        }

    @Test
        public void testUnitAttackKillsTarget() {
            TypeOfArmy faction = TypeOfArmy.values()[0];
            Unit attacker = new Unit("Soldier", 100, 5, 2, 10, 5, 2, 1, 0, 0, 0, 50, 1, faction);
        Unit target = new Unit("Enemy", 10, 4, 3, 8, 4, 3, 1, 0, 0, 0, 40, 1, TypeOfArmy.values()[1]);
        attacker.attack(target);
        assertEquals(0, target.getHealthPoint());
        }

    @Test
        public void testUnitAttackDoesNotAffectOtherUnits() {
            TypeOfArmy faction = TypeOfArmy.values()[0];
            Unit attacker = new Unit("Soldier", 100, 5, 2, 10, 5, 2, 1, 0, 0, 0, 50, 1, faction);
            Unit target = new Unit("Enemy", 80, 4, 3, 8, 4, 3, 1, 0, 0, 0, 40, 1, TypeOfArmy.values()[1]);
            Unit otherUnit = new Unit("Ally", 60, 3, 2, 6, 3, 2, 1, 0, 0, 0, 30, 1, faction);
            attacker.attack(target);
            assertEquals(60, otherUnit.getHealthPoint());
        }
}
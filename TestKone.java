public class TestKone {
    public static void main(String[] args) {
        // Remplace TypeOfArmy.HUMAIN par une valeur qui existe dans ton enum
        Infantry soldat = new Infantry("Soldat", 100, 3, 1, 20,
                5, 2, 0, 0,
                0, 0, 10, 1,
                TypeOfArmy.HUMAN, 8);

        System.out.println(soldat.getName());
        System.out.println(soldat.getSquadSize());
    }
}
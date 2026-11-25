
public class GestionAttaque {

    // ==============================
    // ATTRIBUTS DE LA CLASSE
    // ==============================

    // Unité adverse sélectionnée comme cible
    private Unit target;


    // ==============================
    // CONSTRUCTEUR
    // ==============================

    // Initialise la cible à null car aucune unité n'est sélectionnée
    public GestionAttaque() {

        target = null;
    }


    // ==============================
    // SELECTION DE LA CIBLE
    // ==============================

    // Permet de sélectionner une unité à attaquer
    public void selectTarget(Unit unite) {

        // Vérifie qu'une unité a bien été sélectionnée
        if (unite == null) {
            System.out.println("Aucune cible sélectionnée.");
            return;
        }

        // Enregistre l'unité sélectionnée
        target = unite;

        System.out.println("Cible sélectionnée : "
                + target.getName());
    }


    // ==============================
    // VERIFICATION DE LA PORTEE
    // ==============================

    // Vérifie si la cible se trouve dans la portée de l'attaquant
    public boolean isTargetInRange(int distance, int attackRange) {

        // Vérifie qu'une cible est sélectionnée
        if (target == null) {
            System.out.println("Aucune cible sélectionnée.");
            return false;
        }

        // Vérifie que la distance ne dépasse pas la portée d'attaque
        if (distance <= attackRange) {
            return true;
        }

        System.out.println("Cible hors de portée.");
        return false;
    }


    // ==============================
    // VERIFICATION DE LA PENETRATION
    // ==============================

    // Vérifie si l'attaque peut pénétrer l'armure de la cible
    public boolean isTargetArmorPierced(
            int penetrationArmor,
            int targetArmor) {

        // Une attaque pénètre l'armure si sa pénétration
        // est supérieure ou égale à la valeur de l'armure
        return penetrationArmor >= targetArmor;
    }


    // ==============================
    // CALCUL DES DEGATS
    // ==============================

    // Calcule les dégâts réellement infligés à la cible
    public int calculerDegats(
            int attackDamage,
            int penetrationArmor,
            int targetArmor) {

        // Si l'attaque pénètre l'armure, les dégâts sont complets
        if (isTargetArmorPierced(penetrationArmor, targetArmor)) {
            return attackDamage;
        }

        // Sinon, l'armure réduit les dégâts
        int degats = attackDamage - targetArmor;

        // Les dégâts ne peuvent jamais être négatifs
        return Math.max(0, degats);
    }


    // ==============================
    // APPLICATION DES DEGATS
    // ==============================

    // Applique les dégâts à l'unité sélectionnée
    public void damageTarget(int degats) {

        // Vérifie qu'une cible existe
        if (target == null) {
            System.out.println("Impossible d'attaquer : aucune cible.");
            return;
        }

        // Vérifie que la cible possède encore des points de vie
        if (target.getHealthPoint() <= 0) {
            System.out.println("Cette unité est déjà éliminée.");
            return;
        }

        // Applique les dégâts à la cible
        target.takeDamage(degats);

        System.out.println("Attaque effectuée !");
        System.out.println("Dégâts infligés : " + degats);
        System.out.println("Points de vie restants : "
                + target.getHealthPoint());

        // Vérifie si l'unité est éliminée
        if (target.getHealthPoint() <= 0) {
            System.out.println("L'unité a été éliminée !");
        }
    }


    // ==============================
    // GETTER
    // ==============================

    // Retourne l'unité actuellement sélectionnée
    public Unit getTarget() {
        return target;
    }
}

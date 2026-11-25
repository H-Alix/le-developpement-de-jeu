/**
 * @author Alix Huyghe/Duane Marchais
 * @return Un monde d'hexagones avec des coordonnées axiales et des unités.
 */


import java.util.ArrayList;
import java.util.List;

public class World {
    protected double WorldSize;
    protected final double HexSize;
    public final double WorldWidth;
    public final double WorldHeight;
    private final int radius;
    private final List<Unit> ListUnit = new ArrayList<>();
    private final List<Decor> ListDecor = new ArrayList<>();
    private final List<Hex> ListHex = new ArrayList<>();

    /**
     * @author Alix Huyghe
     * @param p_radius
     * @param p_Hsize
     * @return Un monde d'hexagones avec des coordonnées axiales et des unités.
     */
    public World(int p_radius, double p_Hsize) {
        this.radius = p_radius;
        this.HexSize = p_Hsize;
        this.WorldWidth  = HexSize * (3 * radius + 2);
        this.WorldHeight = Math.sqrt(3) * HexSize * (2 * radius + 1);

          for (int q = -radius; q <= radius; q++) {
            for (int r = Math.max(-radius, -q - radius); r <= Math.min(radius, -q + radius); r++) {
                ListHex.add(new Hex(q, r, -q - r));
            }
        }
    }

    /**
     * 
     * @return
     */
    public int getRadius() { 
        return radius; 
    }

    public List<Decor> getListDecor() {
        return ListDecor;
    }


      public List<Hex> getListHex() {
        return ListHex;
    }


     public Hex getHex(int q, int r) {
        for (Hex h : ListHex) {
            if (h.q == q && h.r == r) {
                return h;
            }
        }
        return null; 
    }


      public void addUnit(Unit p_unit) {
        if (getHex(p_unit.getCurrentCoordQ(), p_unit.getCurrentCoordR()) != null) {
            ListUnit.add(p_unit);
        } else {
            System.out.println("Coordonnées hors carte pour : " + p_unit.getName());
        }
    }


    public void apparitionTroupes(Joueur j1, Joueur j2) {
        for (Unit u : j1.getListUnit()) {
            addUnit(u);
        }
        for (Unit u : j2.getListUnit()) {
            addUnit(u);
        }
    }


    public List<Unit> getListUnit() {
        return ListUnit;
    }

    public void AddDecor(Decor p_decor) {
        ListDecor.add(p_decor);
    }
}


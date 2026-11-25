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

    /**
     * 
     * @param p_radius
     * @param p_Hsize
     */
    public World(int p_radius, double p_Hsize) {
        this.radius = p_radius;
        this.HexSize = p_Hsize;
        this.WorldWidth  = HexSize * (3 * radius + 2);
        this.WorldHeight = Math.sqrt(3) * HexSize * (2 * radius + 1);
    }

    /**
     * 
     * @return
     */
    public int getRadius() { 
        return radius; 
    }
}
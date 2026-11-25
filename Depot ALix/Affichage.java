import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Affichage extends JPanel {
    private final World World;
    private final Layout layout;

    public Affichage(World p_world){
        this.World = p_world;
        this.layout = new Layout(new Point(World.HexSize, World.HexSize),new Point(World.WorldWidth / 2.0+50, World.WorldHeight / 2.0));
        setPreferredSize(new Dimension ((int)Math.round(this.World.WorldWidth)+100, (int)Math.round(this.World.WorldHeight)+100));
        setBackground(Color.BLACK); 
    }

    @Override 
    protected void paintComponent(Graphics p_g){
        super.paintComponent(p_g);
        Graphics2D g2 = (Graphics2D) p_g;
        g2.setColor(Color.WHITE);

        int n = World.getRadius();
        for (int i = -n; i <= n; i++){
            for (int j = Math.max(-n, -i - n); j <= Math.min(n, -i + n); j++){
                Hex h  = new Hex(i, j, -i - j);
                Point[] c = layout.hexCorner(h);
                int[] X = new int[6], Y = new int[6];
                for (int k = 0; k < 6; k++){
                    X[k] = (int) Math.round(c[k].x);
                    Y[k] = (int) Math.round(c[k].y);
                }
                g2.drawPolygon(X, Y, 6);
            }
        }
    }
}

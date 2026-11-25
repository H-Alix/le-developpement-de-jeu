/**
 * @author Alix Huyghe/Duane Marchais
 * @return Le visuel du monde d'hexagones avec affichage des unités et des décors.
 */

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


/**
 * @author Alix Huyghe/Duane Marchais
 * @return Le contour des hexagones du monde 
 * @param p_g
 */
    @Override 
    protected void paintComponent(Graphics p_g){
        super.paintComponent(p_g);
        Graphics2D g2 = (Graphics2D) p_g;
        g2.setColor(Color.WHITE);

        int n = World.getRadius();
        

        for (Hex h : World.getListHex()) {
            Point[] c = layout.hexCorner(h);
            int[] X = new int[6], Y = new int[6];
            for (int k = 0; k < 6; k++){
                X[k] = (int) Math.round(c[k].x);
                Y[k] = (int) Math.round(c[k].y);
            }

            
            g2.setColor(Color.WHITE);
            g2.drawPolygon(X, Y, 6);

              int rayonPion = (int) Math.round(World.HexSize * 0.6);
        for (Unit u : World.getListUnit()) {
            if (u.getHealthPoint() <= 0) {
                continue; 
            }
            Hex posHex = new Hex(u.getCurrentCoordQ(), u.getCurrentCoordR(), u.getCurrentCoordS());
            Point centre = layout.hexToPixel(posHex);
            int cx = (int) Math.round(centre.x);
            int cy = (int) Math.round(centre.y);
            // Bleu si HUMAN, Rouge si ORK
            if (u.getFaction() == TypeOfArmy.HUMAN) {
                g2.setColor(Color.BLUE);
            } else {
                g2.setColor(Color.RED);
            }
            g2.fillOval(cx - rayonPion, cy - rayonPion, rayonPion * 2, rayonPion * 2);
        }
    }
    }


    Layout getlayout() {
        return layout;
    }

    public Hex getHexFromCoords(int x, int y){
        Hex HexAtCoord = layout.pixelToHex(new Point(x, y));
        return World.getHex(HexAtCoord.q, HexAtCoord.r);
    }

}

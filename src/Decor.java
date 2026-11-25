public class Decor {    
    private final String Spritepath;
    private int q = 0;
    private int r = 0;
    private int s = 0 ;
    public Decor(String p_Spritepath, World p_world) {
        this.Spritepath = p_Spritepath;
        do{
        this.q = (int) (Math.random() * ((p_world.getRadius()*2-6) - p_world.getRadius()-3));
        this.r = (int) (Math.random() * ((p_world.getRadius()*2) - p_world.getRadius()));
        this.s = -q -r;
        } while ((s >= p_world.getRadius()-3) || (s <= -p_world.getRadius()+3));
        
    }
}

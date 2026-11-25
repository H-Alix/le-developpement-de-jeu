
public class Decor {    
    private final String Spritepath;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private Hex Hexassocie;
    
    public Decor(String p_Spritepath, World p_world) {
        this.Spritepath = p_Spritepath;
        do{
            int random = (int) (Math.random() * (p_world.getListHex().size()+1));
            this.Hexassocie = p_world.getListHex().get(random);
        } while (Hexassocie.getR() <= -8 || Hexassocie.getR() >= 8);
        p_world.AddDecor(this);
    }
    public int getQ() {
        return q;
    }
    public int getR() {
        return r;
    }
    public int getS() {
        return s;
    }
    public Hex getHexassocie() {
        return Hexassocie;
    }
}




class Layout
{
    public final Point size;
    public final Point origin;
    
            
    public Layout(Point p_size, Point p_origin)
    {
        this.size = p_size;
        this.origin = p_origin;
    }

    public Point hexToPixel(Hex h)
    {
        double x = size.x * (Math.sqrt(3) * h.q + Math.sqrt(3) / 2.0 * h.r);
        double y = size.y * (3.0 / 2.0 * h.r);
        return new Point(x + origin.x, y + origin.y);
        
    }

    public Point[] hexCorner(Hex h){
        Point c = hexToPixel(h);
        Point[] corners = new Point[6];
        for (int i = 0; i < 6; i++){
            double angle = Math.toRadians(60 * i - 30);
            corners[i] = new Point(c.x + size.x * Math.cos(angle), c.y + size.y * Math.sin(angle));
        }
        return corners;
    }

    public Hex pixelToHex(Point p_point){
        double x = (p_point.x - origin.x) / size.x;
        double y = (p_point.y - origin.y) / size.y;

        double qFrac = (Math.sqrt(3.0) / 3.0) * x - (1.0 / 3.0) * y;
        double rFrac = (2.0 / 3.0) * y;
        return hexRound(qFrac,rFrac);
    }

    private Hex hexRound(double p_q, double p_r){
        double sFrac = - p_q - p_r;

        int q = (int) Math.round(p_q);
        int r = (int) Math.round(p_r);
        int s = (int) Math.round(sFrac);

        double qDiff = Math.abs(q - p_q);
        double rDiff = Math.abs(r - p_r);
        double sDiff = Math.abs(s - sFrac);

        if(qDiff > rDiff && qDiff > sDiff){
            q = -r - s;
        } else if (rDiff > sDiff){
            r = -q -s;  
        }

        return new Hex(q,r,-q-r);
    }

}

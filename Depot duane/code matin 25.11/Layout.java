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
}

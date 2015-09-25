package Gameplay.Point;

/**
 * sets the location of the knight coordinates
 *  
 */
public class Pnt 
{
    private double x;
    private double y;

    /**
     * constructor
     * 
     * @param x coordinate x
     * @param y coordinate y
     */
    public Pnt(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * getX - gets x coordinate 
     * @return the x
     */
    public double getX()
    {
        return x;
    }

    /**
     * setX - sets x coordinate 
     */
    public void setX(int x) 
    {
        this.x = x;
    }

    /**
     * getY - gets y coordinate 
     * @return the y
     */
    public double getY() 
    {
        return y;
    }

    /**
     * setY - sets y coordinate 
     */
    public void setY(int y) 
    {
        this.y = y;
    }
}

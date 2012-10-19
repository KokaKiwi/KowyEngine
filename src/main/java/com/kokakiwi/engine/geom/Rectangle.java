package com.kokakiwi.engine.geom;

/**
 * Represents a rectangular zone, defined by {x, y, width, height}.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public class Rectangle implements Geometry2D
{
    private int x;
    private int y;
    private int width;
    private int height;
    
    /**
     * Create a new {@link Rectangle} defined by {x, y, width, height}.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Rectangle(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Get rectangle X coordinate.
     * 
     * @return X coordinate.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Set rectangle X coordinate.
     * 
     * @param x
     *            X coordinate.
     */
    public void setX(int x)
    {
        this.x = x;
    }
    
    /**
     * Get rectangle Y coordinate.
     * 
     * @return Y coordinate.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Set rectangle Y coordinate.
     * 
     * @param y
     *            Y coordinate.
     */
    public void setY(int y)
    {
        this.y = y;
    }
    
    /**
     * Get rectangle width.
     * 
     * @return width.
     */
    public int getWidth()
    {
        return width;
    }
    
    /**
     * Set rectangle width.
     * 
     * @param width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    /**
     * Get rectangle height.
     * 
     * @return height.
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * Set rectangle height.
     * 
     * @param height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public Geometry2D intersect(Geometry2D geom)
    {
        Geometry2D result = null;
        
        if (geom instanceof Rectangle)
        {
            Rectangle rect = (Rectangle) geom;
            int x0 = Math.max(x, rect.x);
            int y0 = Math.max(y, rect.y);
            int x1 = Math.min(x + width, rect.x + rect.width);
            int y1 = Math.min(y + height, rect.y + rect.height);
            
            result = new Rectangle(x0, y0, Math.max(0, x1 - x0), Math.max(0, y1
                    - y0));
        }
        
        return result;
    }
}

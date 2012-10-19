/**
 * This file is part of Kowy Engine.
 *
 * Kowy Engine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kowy Engine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kowy Engine.  If not, see <http://www.gnu.org/licenses/gpl-3.0.txt>.
 */
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

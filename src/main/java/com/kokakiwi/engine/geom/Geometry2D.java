package com.kokakiwi.engine.geom;

/**
 * Define a two-dimensional geometry.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public interface Geometry2D
{
    /**
     * Computes the intersection of this geometry and the specified other.
     * 
     * @param geom
     *            The other geometry.
     * @return The intersection geometry.
     */
    public Geometry2D intersect(Geometry2D geom);
}

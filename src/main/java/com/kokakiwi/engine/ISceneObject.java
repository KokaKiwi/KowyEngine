package com.kokakiwi.engine;

/**
 * Basic scene object, which handle tick and render.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public interface ISceneObject
{
    /**
     * Update the object, for input handling or others modifications.
     * 
     * @param scene
     *            The scene containing this object.
     */
    public void update(IScene scene);
    
    /**
     * Render the object.
     * 
     * @param scene
     *            The scene containing this object.
     */
    public void render(IScene scene);
}

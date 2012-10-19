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
package com.kokakiwi.engine;

import java.util.Collection;

import com.kokakiwi.engine.binding.IOpenGL;
import com.kokakiwi.engine.render.Camera;

/**
 * Engine main class. This class is used for rendering all objects, with
 * cameras, etc...
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public interface IScene
{
    /**
     * Initialize the scene. Should initialize OpenGL configurations.
     */
    public void init();
    
    /**
     * Scene loop. Should be called by a Thread.
     */
    public void loop();
    
    /**
     * Get {@link IOpenGL} implementation linked to this scene.
     * 
     * @return {@link IOpenGL} implementation linked to this scene.
     */
    public IOpenGL getOpenGL();
    
    /**
     * Link an {@link IOpenGL} implementation to this scene.
     * 
     * @param gl
     *            {@link IOpenGL} implementation.
     */
    public void setOpenGL(IOpenGL gl);
    
    /**
     * Add a scene object to this scene.
     * 
     * @param o
     *            Scene object.
     */
    public void addSceneObject(ISceneObject o);
    
    /**
     * Remove a scene object from this scene.
     * 
     * @param o
     *            Scene object.
     */
    public void removeSceneObject(ISceneObject o);
    
    /**
     * Get all scene objects attached to this scene.
     * 
     * @return Scene objects.
     */
    public Collection<ISceneObject> getSceneObjects();
    
    /**
     * Get current camera.
     * 
     * @return current camera.
     */
    public Camera getCamera();
    
    /**
     * Set current camera.
     * 
     * @param camera
     *            new camera.
     */
    public void setCamera(Camera camera);
    
    /**
     * Get last frame time.
     * 
     * @return Last frame time.
     */
    public long last();
    
    /**
     * Get time since the last frame.
     * 
     * @return Time since the last frame
     */
    public long delta();
}

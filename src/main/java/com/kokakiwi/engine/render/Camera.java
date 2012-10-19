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
package com.kokakiwi.engine.render;

import com.kokakiwi.engine.binding.IOpenGL;
import com.kokakiwi.engine.geom.Rectangle;
import com.kokakiwi.engine.utils.maths.Vector3f;

/**
 * Contains the camera state.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public class Camera
{
    private Rectangle viewport;
    
    private Vector3f  position;
    private float     yaw;
    private float     pitch;
    
    /**
     * Create a new camera with default viewport [0, 0, 1024, 768], origin
     * position [0, 0, 0] and yaw/pitch at 0
     */
    public Camera()
    {
        this(Vector3f.ZERO, 0.0f, 0.0f);
    }
    
    /**
     * Create a new camera with a default viewport of [0, 0, 1024, 768] and
     * defined position/yaw/pitch.
     * 
     * @param position
     *            camera's position
     * @param yaw
     *            camera's yaw
     * @param pitch
     *            camera's pitch
     */
    public Camera(Vector3f position, float yaw, float pitch)
    {
        this(new Rectangle(0, 0, 1024, 768), position, yaw, pitch);
    }
    
    /**
     * Create a new camera using a viewport, a position and yaw/pitch
     * 
     * @param viewport
     *            camera's viewport.
     * @param position
     *            camera's position
     * @param yaw
     *            camera's yaw
     * @param pitch
     *            camera's pitch
     */
    public Camera(Rectangle viewport, Vector3f position, float yaw, float pitch)
    {
        this.viewport = viewport;
        this.position = position;
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    /**
     * Get camera's viewport.
     * 
     * @return camera's viewport.
     */
    public Rectangle getViewport()
    {
        return viewport;
    }
    
    /**
     * Set camera's viewport.
     * 
     * @param viewport
     *            camera's viewport.
     */
    public void setViewport(Rectangle viewport)
    {
        this.viewport = viewport;
    }
    
    /**
     * Get camera's position.
     * 
     * @return camera's position.
     */
    public Vector3f getPosition()
    {
        return position;
    }
    
    /**
     * Set camera's position.
     * 
     * @param position
     *            camera's position.
     */
    public void setPosition(Vector3f position)
    {
        this.position = position;
    }
    
    /**
     * Get camera's yaw.
     * 
     * @return camera's yaw.
     */
    public float getYaw()
    {
        return yaw;
    }
    
    /**
     * Set camera's yaw.
     * 
     * @param yaw
     */
    public void setYaw(float yaw)
    {
        this.yaw = yaw;
    }
    
    /**
     * Get camera's pitch.
     * 
     * @return camera's pitch.
     */
    public float getPitch()
    {
        return pitch;
    }
    
    /**
     * Set camera's pitch.
     * 
     * @param pitch
     *            camera's pitch.
     */
    public void setPitch(float pitch)
    {
        this.pitch = pitch;
    }
    
    /**
     * Apply rules to OpenGL (Viewport, position, yaw, pitch, etc...)
     * 
     * @param gl
     *            {@link IOpenGL} interface.
     */
    public void apply(IOpenGL gl)
    {
        gl.viewport(viewport.getX(), viewport.getY(), viewport.getWidth(),
                viewport.getHeight());
        gl.rotate(pitch, 1.0f, 0.0f, 0.0f);
        gl.rotate(yaw, 0.0f, 1.0f, 0.0f);
        gl.translate(position.getX(), position.getY(), position.getZ());
    }
}

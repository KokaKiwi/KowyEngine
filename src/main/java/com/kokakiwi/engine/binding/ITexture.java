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
package com.kokakiwi.engine.binding;

/**
 * Basic definition of an OpenGL Texture. Must be implemented by different
 * OpenGL impl. in Java.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public interface ITexture
{
    /**
     * Bind the texture to OpenGL render.
     */
    public void bind();
    
    /**
     * Get texture width.
     * 
     * @return Texture width. In pixels.
     */
    public int getTextureWidth();
    
    /**
     * Get texture height.
     * 
     * @return Texture height. In pixels.
     */
    public int getTextureHeight();
    
    /**
     * Check if texture has alpha layer.
     * 
     * @return true if texture has alpha layer, false else.
     */
    public boolean hasAlpha();
    
    /**
     * Get texture ID on OpenGL.
     * 
     * @return Texture ID.
     */
    public int getID();
    
    /**
     * Frees the space associated with this resource.
     */
    public void dispose();
}

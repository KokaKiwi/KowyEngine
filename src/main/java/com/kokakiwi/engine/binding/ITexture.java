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

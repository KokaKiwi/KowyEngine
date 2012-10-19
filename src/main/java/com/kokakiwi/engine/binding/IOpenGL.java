package com.kokakiwi.engine.binding;

/**
 * Contains OpenGL functions to control OpenGL. It's used to allow multiples
 * OpenGL implementations in Java (JOGL, LWJGL, etc...).
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public interface IOpenGL
{
    public void rotate(float angle, float x, float y, float z);
    
    public void translate(float x, float y, float z);
    
    public void viewport(int x, int y, int width, int height);
    
    public void loadIdentity();
    
    public void setProjectionMatrixMode();
    
    public void setModelViewMatrixMode();
    
    public void clearColorBuffer();
    
    public void clearDepthBuffer();
}

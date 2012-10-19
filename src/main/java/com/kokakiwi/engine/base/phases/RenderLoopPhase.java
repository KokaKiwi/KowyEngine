package com.kokakiwi.engine.base.phases;

import com.kokakiwi.engine.IScene;
import com.kokakiwi.engine.ISceneObject;
import com.kokakiwi.engine.base.ILoopPhase;
import com.kokakiwi.engine.binding.IOpenGL;

public class RenderLoopPhase implements ILoopPhase
{
    
    public void execute(IScene scene)
    {
        IOpenGL gl = scene.getOpenGL();
        
        gl.clearColorBuffer();
        gl.clearDepthBuffer();
        gl.loadIdentity();
        
        for (ISceneObject obj : scene.getSceneObjects())
        {
            obj.render(scene);
        }
    }
    
}

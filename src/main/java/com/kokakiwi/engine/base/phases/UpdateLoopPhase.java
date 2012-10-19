package com.kokakiwi.engine.base.phases;

import com.kokakiwi.engine.IScene;
import com.kokakiwi.engine.ISceneObject;
import com.kokakiwi.engine.base.ILoopPhase;

public class UpdateLoopPhase implements ILoopPhase
{
    
    public void execute(IScene scene)
    {
        for (ISceneObject obj : scene.getSceneObjects())
        {
            obj.update(scene);
        }
    }
    
}

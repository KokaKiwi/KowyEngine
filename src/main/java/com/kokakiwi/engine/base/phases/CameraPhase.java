package com.kokakiwi.engine.base.phases;

import com.kokakiwi.engine.IScene;
import com.kokakiwi.engine.base.ILoopPhase;

public class CameraPhase implements ILoopPhase
{
    public void execute(IScene scene)
    {
        scene.getCamera().apply(scene.getOpenGL());
    }
}

package com.kokakiwi.engine.base;

import com.kokakiwi.engine.IScene;

/**
 * Scene loop phase, will executed by an {@link IScene} implementation which
 * support loop phases.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public interface ILoopPhase
{
    /**
     * Execute this phase.
     * 
     * @param scene
     *            {@link IScene} implementation.
     */
    public void execute(IScene scene);
}

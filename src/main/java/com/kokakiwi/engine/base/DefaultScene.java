package com.kokakiwi.engine.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kokakiwi.engine.IScene;
import com.kokakiwi.engine.ISceneObject;
import com.kokakiwi.engine.base.phases.*;
import com.kokakiwi.engine.binding.IOpenGL;
import com.kokakiwi.engine.render.Camera;

/**
 * Default implementation of {@link IScene}.
 * 
 * - You can link an {@link IOpenGL} implementation.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public class DefaultScene implements IScene
{
    private IOpenGL                              gl           = null;
    private final Map<Integer, List<ILoopPhase>> phases       = Maps.newTreeMap();
    private final List<ISceneObject>             sceneObjects = Lists.newLinkedList();
    private Camera                               camera       = null;
    private long                                 last         = 0;
    private long                                 current      = System.currentTimeMillis();
    
    /**
     * Create a new scene and binding to {@link gl}.
     * 
     * @param gl
     *            {@link IOpenGL} implementation.
     */
    public DefaultScene(IOpenGL gl)
    {
        this.gl = gl;
    }
    
    public IOpenGL getOpenGL()
    {
        return gl;
    }
    
    public void setOpenGL(IOpenGL gl)
    {
        this.gl = gl;
    }
    
    /**
     * Add loop phase by index ordering.
     * 
     * @param index
     *            Order index.
     * @param phase
     *            Loop phase.
     */
    public void addPhase(int index, ILoopPhase phase)
    {
        getPhases(index).add(phase);
    }
    
    /**
     * Get loop phases linked to an order index.
     * 
     * @param index
     *            Order index.
     * @return Loop phases at this index.
     */
    public List<ILoopPhase> getPhases(int index)
    {
        List<ILoopPhase> phase = phases.get(index);
        if (phase == null)
        {
            phase = Lists.newLinkedList();
            phases.put(index, phase);
        }
        
        return phase;
    }
    
    /**
     * Add default phases:
     */
    public void addDefaultPhases()
    {
        addPhase(10, new UpdateLoopPhase());
        addPhase(20, new CameraPhase());
        addPhase(20, new RenderLoopPhase());
    }
    
    public void init()
    {
        if (gl == null)
        {
            throw new NullPointerException("gl");
        }
    }
    
    public void loop()
    {
        if (gl == null)
        {
            throw new NullPointerException("gl");
        }
        
        last = current;
        current = System.currentTimeMillis();
        
        Set<Integer> keys = phases.keySet();
        List<Integer> indexes = new ArrayList<Integer>(keys.size());
        indexes.addAll(keys);
        Collections.sort(indexes);
        
        for (int index : indexes)
        {
            List<ILoopPhase> loopPhases = phases.get(index);
            for (ILoopPhase phase : loopPhases)
            {
                phase.execute(this);
            }
        }
    }
    
    public void addSceneObject(ISceneObject o)
    {
        sceneObjects.add(o);
    }
    
    public void removeSceneObject(ISceneObject o)
    {
        sceneObjects.remove(o);
    }
    
    public Collection<ISceneObject> getSceneObjects()
    {
        return sceneObjects;
    }
    
    public Camera getCamera()
    {
        return camera;
    }
    
    public void setCamera(Camera camera)
    {
        this.camera = camera;
    }
    
    public long last()
    {
        return last;
    }
    
    public long delta()
    {
        return current - last;
    }
}

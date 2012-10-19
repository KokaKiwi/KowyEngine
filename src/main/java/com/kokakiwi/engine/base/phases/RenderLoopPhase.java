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

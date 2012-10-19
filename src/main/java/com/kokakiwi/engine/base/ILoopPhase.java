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

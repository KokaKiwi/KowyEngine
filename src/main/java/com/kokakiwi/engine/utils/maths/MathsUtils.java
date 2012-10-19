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
package com.kokakiwi.engine.utils.maths;

/**
 * Some utility math functions.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public class MathsUtils
{
    /**
     * Linearly interpolates between va and vb by the parameter t.
     * 
     * @param va
     *            first value.
     * @param vb
     *            second value.
     * @param t
     *            parameter.
     * @return result value.
     */
    public static float lerp(float va, float vb, float t)
    {
        return va + t * (vb - va);
    }
}

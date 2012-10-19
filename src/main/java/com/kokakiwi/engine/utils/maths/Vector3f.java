package com.kokakiwi.engine.utils.maths;

/**
 * A three-dimensional vector with float values.
 * 
 * @author Koka El Kiwi
 * @version 0.1.0
 * 
 */
public class Vector3f
{
    /** A unit vector in the X+ direction. */
    public static final Vector3f UNIT_X     = new Vector3f(1f, 0f, 0f);
    
    /** A unit vector in the Y+ direction. */
    public static final Vector3f UNIT_Y     = new Vector3f(0f, 1f, 0f);
    
    /** A unit vector in the Z+ direction. */
    public static final Vector3f UNIT_Z     = new Vector3f(0f, 0f, 1f);
    
    /** A vector containing unity for all components. */
    public static final Vector3f UNIT_XYZ   = new Vector3f(1f, 1f, 1f);
    
    /** A normalized version of UNIT_XYZ. */
    public static final Vector3f NORMAL_XYZ = UNIT_XYZ.normalize();
    
    /** The zero vector. */
    public static final Vector3f ZERO       = new Vector3f(0f, 0f, 0f);
    
    private float                x;
    private float                y;
    private float                z;
    
    /**
     * Create an empty vector with coordinates [0,0,0]
     */
    public Vector3f()
    {
        this(0, 0, 0);
    }
    
    /**
     * Create a new three-dimensional vector with coordinates [x,y,z]
     * 
     * @param x
     *            X coordinate
     * @param y
     *            Y coordinate
     * @param z
     *            Z coordinate
     */
    public Vector3f(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Get vector X coordinate.
     * 
     * @return Vector X coordinate.
     */
    public float getX()
    {
        return x;
    }
    
    /**
     * Set vector X coordinate.
     * 
     * @param x
     *            Vector X coordinate.
     */
    public void setX(float x)
    {
        this.x = x;
    }
    
    /**
     * Get vector Y coordinate.
     * 
     * @return Vector Y coordinate.
     */
    public float getY()
    {
        return y;
    }
    
    /**
     * Set vector Y coordinate.
     * 
     * @param Y
     *            Vector Y coordinate.
     */
    public void setY(float y)
    {
        this.y = y;
    }
    
    /**
     * Get vector Y coordinate.
     * 
     * @return Vector Y coordinate.
     */
    public float getZ()
    {
        return z;
    }
    
    /**
     * Set vector Z coordinate.
     * 
     * @param z
     *            Vector Z coordinate.
     */
    public void setZ(float z)
    {
        this.z = z;
    }
    
    /**
     * Set vector coordinates.
     * 
     * @param x
     *            Vector X coordinate.
     * @param y
     *            Vector Y coordinate.
     * @param z
     *            Vector Z coordinate.
     */
    public void set(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Translate a vector with an other vector.
     * 
     * @param vec
     *            Vector.
     * @return this
     */
    public Vector3f translate(Vector3f vec)
    {
        return translate(vec.x, vec.y, vec.z);
    }
    
    /**
     * Translate a vector
     * 
     * @param x
     *            The translation in x
     * @param y
     *            the translation in y
     * @param z
     *            the translation in z
     * @return this
     */
    public Vector3f translate(float x, float y, float z)
    {
        this.x += x;
        this.y += y;
        this.z += z;
        
        return this;
    }
    
    /**
     * Adds a vector to this one.
     * 
     * @param vec
     *            The vector.
     * @return this
     */
    public Vector3f add(Vector3f vec)
    {
        return add(vec.x, vec.y, vec.z);
    }
    
    /**
     * Adds a vector to this one.
     * 
     * @param x
     *            X value
     * @param y
     *            Y value
     * @param z
     *            Z value
     * @return this
     */
    public Vector3f add(float x, float y, float z)
    {
        return translate(x, y, z);
    }
    
    /**
     * Subtracts a vector to this one.
     * 
     * @param vec
     *            The vector.
     * @return this
     */
    public Vector3f subtract(Vector3f vec)
    {
        return subtract(vec.x, vec.y, vec.z);
    }
    
    /**
     * Subtracts a vector to this one.
     * 
     * @param x
     *            X value
     * @param y
     *            Y value
     * @param z
     *            Z value
     * @return this
     */
    public Vector3f subtract(float x, float y, float z)
    {
        return translate(-x, -y, -z);
    }
    
    /**
     * Multiplies this vector by another.
     * 
     * @param vec
     *            The vector.
     * @return this
     */
    public Vector3f mult(Vector3f vec)
    {
        return mult(vec.x, vec.y, vec.z);
    }
    
    /**
     * Multiplies this vector by another.
     * 
     * @param x
     *            X value
     * @param y
     *            Y value
     * @param z
     *            Z value
     * @return this
     */
    public Vector3f mult(float x, float y, float z)
    {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        
        return this;
    }
    
    /**
     * Computes and returns the dot product of this and the specified other
     * vector.
     * 
     * @param vec
     *            The vector.
     * @return dot
     */
    public float dot(Vector3f vec)
    {
        return dot(this, vec);
    }
    
    /**
     * Returns the angle between this vector and the specified other vector.
     * 
     * @param vec
     *            The vector.
     * @return angle
     */
    public float angle(Vector3f vec)
    {
        return angle(this, vec);
    }
    
    /**
     * Computes the cross product of this and the specified other vector,
     * placing the result in the object supplied.
     * 
     * @param vec
     *            The vector.
     * @return Crossed vector.
     */
    public Vector3f cross(Vector3f vec)
    {
        return cross(this, vec);
    }
    
    /**
     * Linearly interpolates between this and the specified other vector by the
     * supplied amount.
     * 
     * @param vec
     *            The vector.
     * @param t
     *            amount.
     * @return a new vector containing the result.
     */
    public Vector3f lerp(Vector3f vec, float t)
    {
        return lerp(this, vec, t);
    }
    
    /**
     * @return the length squared of the vector
     */
    public float lengthSquared()
    {
        return x * x + y * y + z * z;
    }
    
    /**
     * @return the length of the vector
     */
    public final float length()
    {
        return (float) Math.sqrt(lengthSquared());
    }
    
    /**
     * Returns the squared distance from this vector to the specified other.
     * 
     * @param vec
     *            The vector
     * @return the squared distance from this vector to the specified other.
     */
    public float distanceSquared(Vector3f vec)
    {
        float dx = vec.x - x;
        float dy = vec.y - y;
        float dz = vec.z - z;
        
        return dx * dx + dy * dy + dz * dz;
    }
    
    /**
     * Returns the distance from this vector to the specified other vector.
     * 
     * @param vec
     *            The vector
     * @return the distance from this vector to the specified other vector.
     */
    public final float distance(Vector3f vec)
    {
        return (float) Math.sqrt(distanceSquared(vec));
    }
    
    /**
     * Returns the Manhattan distance between this vector and the specified
     * other.
     * 
     * @param vec
     *            The vector.
     * @return the Manhattan distance between this vector and the specified
     *         other.
     */
    public float manhattanDistance(Vector3f vec)
    {
        return Math.abs(x - vec.x) + Math.abs(y - vec.y) + Math.abs(z - vec.z);
    }
    
    /**
     * Normalize this vector.
     * 
     * @return the normalized vector
     */
    public Vector3f normalize()
    {
        float length = length();
        
        return new Vector3f(x / length, y / length, z / length);
    }
    
    /**
     * Copy this vector.
     * 
     * @return This vector's copy.
     */
    public Vector3f copy()
    {
        return new Vector3f(x, y, z);
    }
    
    /**
     * Negates this vector.
     * 
     * @return this
     */
    public Vector3f negate()
    {
        return scale(-1.0f);
    }
    
    /**
     * Scale this vector
     * 
     * @param scale
     *            The scale factor
     * @return this
     */
    public Vector3f scale(float scale)
    {
        this.x *= scale;
        this.y *= scale;
        this.z *= scale;
        
        return this;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Vector3f [x=");
        builder.append(x);
        builder.append(", y=");
        builder.append(y);
        builder.append(", z=");
        builder.append(z);
        builder.append("]");
        return builder.toString();
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(x);
        result = prime * result + Float.floatToIntBits(y);
        result = prime * result + Float.floatToIntBits(z);
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector3f other = (Vector3f) obj;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
            return false;
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
            return false;
        if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
            return false;
        return true;
    }
    
    /**
     * The dot product of two vectors is calculated as v1.x * v2.x + v1.y * v2.y
     * + v1.z * v2.z
     * 
     * @param a
     *            The first vector
     * @param b
     *            The second vector
     * @return left dot right
     */
    public final static float dot(Vector3f a, Vector3f b)
    {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
    
    /**
     * Calculate the angle between two vectors, in radians
     * 
     * @param a
     *            A vector
     * @param b
     *            The other vector
     * @return the angle between the two vectors, in radians
     */
    public static float angle(Vector3f a, Vector3f b)
    {
        float dls = dot(a, b) / (a.length() * b.length());
        
        if (dls < -1f)
        {
            dls = -1f;
        }
        else if (dls > 1.0f)
        {
            dls = 1.0f;
        }
        
        return (float) Math.acos(dls);
    }
    
    /**
     * Computes the cross product of two vectors.
     * 
     * @param a
     *            First vector.
     * @param b
     *            Second vector.
     * @return Crossed vector.
     */
    public static Vector3f cross(Vector3f a, Vector3f b)
    {
        return new Vector3f(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x
                * b.y - a.y * b.x);
    }
    
    /**
     * Linearly interpolates between two vectors by the supplied amount.
     * 
     * @param va
     *            first vector.
     * @param vb
     *            second vector.
     * @param t
     *            amount.
     * @return result value.
     */
    public static Vector3f lerp(Vector3f va, Vector3f vb, float t)
    {
        return new Vector3f(MathsUtils.lerp(va.x, vb.x, t), MathsUtils.lerp(
                va.y, vb.y, t), MathsUtils.lerp(va.z, vb.z, t));
    }
}

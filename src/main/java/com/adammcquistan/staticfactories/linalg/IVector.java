
package com.adammcquistan.staticfactories.linalg;

public interface IVector {

    public double dot(IVector v);

    public double get(int idx);

    public int size();

    public double[] toArray();
}

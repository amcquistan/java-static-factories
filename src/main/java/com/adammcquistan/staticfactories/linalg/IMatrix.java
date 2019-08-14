
package com.adammcquistan.staticfactories.linalg;



public interface IMatrix {
    public IVector getRow(int rowIdx);

    public IVector getColumn(int colIdx);

    public int rows();

    public int cols();

    public IMatrix matmul(IMatrix m);

    public IMatrix transpose();
}
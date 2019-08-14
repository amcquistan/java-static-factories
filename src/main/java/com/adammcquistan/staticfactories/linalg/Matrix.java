
package com.adammcquistan.staticfactories.linalg;

public class Matrix implements IMatrix {

    @Override
    public IVector getRow(int rowIdx) {
        return null;
    }

    @Override
    public IVector getColumn(int colIdx) {
        return null;
    }

    @Override
    public int rows() {
        return 0;
    }

    @Override
    public int cols() {
        return 0;
    }

    @Override
    public IMatrix matmul(IMatrix m) {
        return null;
    }

    @Override
    public IMatrix transpose() {
        return null;
    }
}

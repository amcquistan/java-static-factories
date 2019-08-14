package com.adammcquistan.staticfactories.linalg;

import java.util.StringJoiner;

public class Vector implements IVector {
    private static final int INIT_CAPACITY = 100;

    private int currentIdx = -1;
    private double[] data;
    
    public Vector() {
        data = new double[INIT_CAPACITY];
    }
    
    public Vector(int size) {
        data = new double[size];
    }
    
    public Vector(double[] arr) {
        data = new double[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        currentIdx = arr.length - 1;
    }
    
    public double get(int idx) {
        if (idx > currentIdx) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        return this.data[idx];
    }
    
    public int size() {
        return currentIdx + 1;
    }

    @Override
    public double dot(IVector v) {
        checkSizeCompatibility(v);
        
        double product = 0.0d;
        for (int i = 0; i < this.size(); i++) {
            product += (this.data[i] * v.data[i]);
        }
        return product;
    }
    
    /**
     * This is the Euclidean norm
     * @return Euclidean norm
     */
    public double normL2() {
        return Math.sqrt(this.sumOfSquares());
    }
    
    public double sumOfSquares() {
        double ss = 0.0d;
        for (int i = 0; i < this.size(); i++) {
            ss += (this.data[i] * this.data[i]);
        }
        return ss;
    }
    
    private void checkSizeCompatibility(IVector v) throws ArithmeticException {
        if (this.size() != v.size())
            throw new ArithmeticException("Incompatible vector sizes " + v.size() + " and " + this.size());
    }
    
    @Override
    public double[] toArray() {
        double[] result = new double[this.size()];
        for (int i = 0; i < this.size(); i++) {
            result[i] = this.get(i);
        }
        return result;
    }
    
    @Override
    public String toString() {
        String s = "Vector[" + this.size() + "] => ";
        StringJoiner sj = new StringJoiner(",");
        if (this.size() > 8) {
            for (int i = 0; i < 3; i++) {
                sj.add(String.format("%10.4f", this.data[i]));
            }
            sj.add("...");
            for (int i = this.size() - 3; i < this.size(); i++) {
                sj.add(String.format("%10.4f", this.data[i]));
            }
        } else {
            for (int i = 0; i < this.size(); i++) {
                sj.add(String.format("%10.4f", this.data[i]));
            }
        }
        return s + "[" + sj + "]";
    }
}
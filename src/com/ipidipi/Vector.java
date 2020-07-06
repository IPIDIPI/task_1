package com.ipidipi;

public class Vector {

    private double x,y,z;

    public Vector(){}

    public Vector(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x*x + y*y +z*z);
    }

    public double scalarProduct(Vector vector) {
        return x*vector.x + y*vector.y + z*vector.z;
    }

    public Vector crossProduct(Vector vector) {
        return new Vector(
                x * vector.y - y * vector.x,
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z
                );
    }

    public  double cos(Vector vector) {
        return scalarProduct(vector) / (length() + vector.length());
    }

    public Vector add(Vector vector) {
        return new Vector(
                x + vector.x,
                y + vector.y,
                z + vector.z
        );
    }

    public Vector subtract(Vector vector) {
        return new Vector(
                x - vector.x,
                y - vector.y,
                z - vector.z
        );
    }

    public static Vector[] generate(int n){
        Vector[] vectors = new Vector[n];
        for(int i =0; i < n; i++){
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

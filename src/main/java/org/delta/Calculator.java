package org.delta;

public class Calculator implements Calc{

    @Override
    public double add(double x, double y) {
        return x + y;
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public double sub(double x, double y){
        return x-y;
    }

    @Override
    public double mul(double x, double y){
        return x*y;
    }

    @Override
    public double div(double x, double y){
        if(y != 0)
            return x/y;
        else
            throw new ArithmeticException(("Division by zero"));
    }
}

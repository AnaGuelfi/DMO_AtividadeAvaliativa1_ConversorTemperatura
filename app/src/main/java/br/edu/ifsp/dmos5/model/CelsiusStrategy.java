package br.edu.ifsp.dmos5.model;

public class CelsiusStrategy implements ConversorTemperatura{
    private static CelsiusStrategy instance;

    public CelsiusStrategy(){}

    public static CelsiusStrategy getInstance() {
        if (instance == null) {
            instance = new CelsiusStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperature) {
        return (temperature - 32) / 1.8;
    }
}


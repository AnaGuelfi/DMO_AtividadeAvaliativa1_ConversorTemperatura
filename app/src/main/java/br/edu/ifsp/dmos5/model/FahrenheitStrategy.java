package br.edu.ifsp.dmos5.model;

public class FahrenheitStrategy implements ConversorTemperatura{
    private static FahrenheitStrategy instance;
    public FahrenheitStrategy(){}

    public static FahrenheitStrategy getInstance() {
        if (instance == null) {
            instance = new FahrenheitStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperature) {
        return (1.8 * temperature) + 32;
    }
}
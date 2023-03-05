package br.edu.ifsp.dmos5.model;

public class KelvinStrategy implements ConversorTemperatura {
    private static KelvinStrategy instance;
    public KelvinStrategy(){}

    public static KelvinStrategy getInstance() {
        if (instance == null) {
            instance = new KelvinStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperature) {
        return temperature + 273.15;
    }
}

package com.improvemyskills.javaavance.patternmatching;


public enum Day {
    LUNDI("lundi"), MARDI("mardi"), MERCREDI("mercredi"),
    JEUDI("jeudi"), VENDREDI("vendredi"),
    SAMEDI("samedi"), DIMANCHE("dimanche");

    private final String label;

    Day(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

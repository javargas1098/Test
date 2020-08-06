package com.example.demo.documents;

public enum Variables {
    GLOBAL(""), PLANETSGLOBAL("");

    String label;
    int var;

    private Variables(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
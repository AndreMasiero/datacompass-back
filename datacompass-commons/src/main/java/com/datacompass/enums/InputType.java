package com.datacompass.enums;

public enum InputType {

    TEXT("TEXT"),
    NUMBER("NUMBER"),
    BOOLEAN("BOOLEAN");

    private final String inputType;

    InputType(String inputType) {
        this.inputType = inputType;
    }

    public String getInputType() {
        return inputType;
    }

}

package com.datacompass.enums;

public enum ComponentType {

    TEXT("TEXT"),
    COMBOBOX("COMBOBOX"),
    CHECKBOX("CHECKBOX");

    private final String componentType;

    ComponentType(String componenteType) {
        this.componentType = componenteType;
    }

    public String getComponentType() {
        return componentType;
    }

}

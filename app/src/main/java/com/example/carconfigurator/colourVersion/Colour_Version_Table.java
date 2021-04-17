package com.example.carconfigurator.colourVersion;

public enum Colour_Version_Table {
    TABLE_NAME("Colour_Version"),
    ID_COLOUR("id_colour"),
    ID_VERSION("id_version");

    public final String value;
    private Colour_Version_Table(String value){
        this.value = value;
    }
}

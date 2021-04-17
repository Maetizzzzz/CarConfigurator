package com.example.carconfigurator.colour;

public enum Colour_Table {
    TABLE_NAME("Colour"),
    ID("id_colour"),
    COLOUR("colour"),
    PRICE("price"),
    IMAGE("image"),
    STANDARD("standard"),
    ID_BRAND("id_brand");

    public final String value;
    private Colour_Table(String value){
        this.value = value;
    }
}

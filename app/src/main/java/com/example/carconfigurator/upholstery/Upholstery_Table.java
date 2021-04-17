package com.example.carconfigurator.upholstery;

public enum Upholstery_Table {
    TABLE_NAME("Upholstery"),
    ID("id_upholstery"),
    UPHOLSTERY("upholstery"),
    PRICE("price"),
    IMAGE("image"),
    STANDARD("standard"),
    ID_BRAND("id_brand");

    public final String value;
    private Upholstery_Table(String value){
        this.value = value;
    }
}

package com.example.carconfigurator.model;

public enum Model_Table {
    ID("id_model"),
    NAME("name"),
    PRICE("price"),
    IMAGE("image"),
    ID_BRAND("id_brand");

    public final String value;
    private Model_Table(String value){
        this.value = value;
    }
}

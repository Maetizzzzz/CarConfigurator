package com.example.carconfigurator.version;

public enum Version_Table {
    TABLE_NAME("Version"),
    ID("id_version"),
    NAME("name"),
    PRICE("price"),
    IMAGE("image"),
    ID_BRAND("id_brand"),
    ID_MODEL("id_model");

    public final String value;
    private Version_Table(String value){
        this.value = value;
    }
}

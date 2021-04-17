package com.example.carconfigurator.upholsteryVersion;

public enum Upholstery_Version_Table {
    TABLE_NAME("Upholstery_Version"),
    ID_UPHOLSTERY("id_upholstery"),
    ID_VERSION("id_version");

    public final String value;
    private Upholstery_Version_Table(String value){
        this.value = value;
    }
}

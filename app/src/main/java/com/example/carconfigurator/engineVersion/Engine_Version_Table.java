package com.example.carconfigurator.engineVersion;

public enum Engine_Version_Table {
    TABLE_NAME("Engine_Version"),
    ID_ENGINE("id_engine"),
    ID_VERSION("id_version");

    public final String value;
    private Engine_Version_Table(String value){
        this.value = value;
    }
}

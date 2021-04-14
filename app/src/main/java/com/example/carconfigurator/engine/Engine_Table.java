package com.example.carconfigurator.engine;

public enum Engine_Table {
    TABLE_NAME("Engine"),
    ID("id_engine"),
    NAME("name"),
    PRICE("price"),
    NUMBER_GEAR("number_gear"),
    MAX_TORQUE("max_torque"),
    CO2_EMISSION("co2_emission"),
    IN_TOWN("in_town"),
    TOTAL_CONSUMPTION("total_consumption"),
    OUT_OF_TOWN("out_of_town"),
    CO2_EFFICIENCY_CLASS("co2_efficiency_class"),
    GEARBOX("gearbox"),
    FUEL("fuel"),
    IMAGE("image"),
    ID_BRAND("id_brand");

    public final String value;
    private Engine_Table(String value){
        this.value = value;
    }
}

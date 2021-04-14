package com.example.carconfigurator.engine;

import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.database.Connector;
import com.example.carconfigurator.engineVersion.Engine_Version_Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Engine_Querries {
    private static Connection connection;
    public static final String Q_GETALLDATA =
            "SELECT " +
                    Engine_Table.TABLE_NAME.value + "." + Engine_Table.ID.value + ", "+
                    Engine_Table.NAME.value +", "+
                    Engine_Table.PRICE.value +", "+
                    Engine_Table.IMAGE.value +", "+
                    Engine_Table.ID_BRAND.value +", "+
                    Engine_Table.NUMBER_GEAR.value +", "+
                    Engine_Table.MAX_TORQUE.value +", "+
                    Engine_Table.CO2_EMISSION.value +", "+
                    Engine_Table.IN_TOWN.value +", "+
                    Engine_Table.TOTAL_CONSUMPTION.value +", "+
                    Engine_Table.OUT_OF_TOWN.value +", "+
                    Engine_Table.CO2_EFFICIENCY_CLASS.value +", "+
                    Engine_Table.GEARBOX.value +", "+
                    Engine_Table.FUEL.value +" "+
                    "FROM " + Engine_Table.TABLE_NAME.value +" " +
                    "INNER JOIN " + Engine_Version_Table.TABLE_NAME.value + " "+
                    "ON " + Engine_Table.TABLE_NAME.value + "." + Engine_Table.ID.value +
                    "=" + Engine_Version_Table.TABLE_NAME.value + "." + Engine_Version_Table.ID_ENGINE.value + " " +
                    "WHERE "+ Engine_Version_Table.TABLE_NAME.value + "." +Engine_Version_Table.ID_VERSION.value + "= ?";

    public static List<Engine> getAllEnginesForVersion(int id_version) throws ConnectionException {
        checkConnection();
        List<Engine> engineList = null;
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(Q_GETALLDATA);
                statement.setInt(1, id_version);
                ResultSet resultSet = statement.executeQuery();
                engineList = new ArrayList<>();
                while (resultSet.next()) {
                    Engine engine = new Engine(
                            resultSet.getInt(Engine_Table.ID.value)
                            , resultSet.getString(Engine_Table.NAME.value)
                            , resultSet.getDouble(Engine_Table.PRICE.value)
                            , resultSet.getInt(Engine_Table.NUMBER_GEAR.value)
                            , resultSet.getInt(Engine_Table.MAX_TORQUE.value)
                            , resultSet.getString(Engine_Table.CO2_EMISSION.value)
                            , resultSet.getString(Engine_Table.IN_TOWN.value)
                            , resultSet.getString(Engine_Table.TOTAL_CONSUMPTION.value)
                            , resultSet.getString(Engine_Table.OUT_OF_TOWN.value)
                            , resultSet.getString(Engine_Table.CO2_EFFICIENCY_CLASS.value)
                            , resultSet.getString(Engine_Table.GEARBOX.value)
                            , resultSet.getString(Engine_Table.FUEL.value)
                            , resultSet.getInt(Engine_Table.IMAGE.value)
                            , resultSet.getInt(Engine_Table.ID_BRAND.value));
                    engineList.add(engine);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                engineList = new ArrayList<>();
            }
        }
        return engineList;
    }

    private static void checkConnection() throws ConnectionException {
        connection = Connector.getConnection();
        if (connection == null) {
            throw new ConnectionException("Engine Connection");
        }
    }
}

package com.example.carconfigurator.model;

import com.example.carconfigurator.brand.Brand;
import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.database.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Model_Querries {
    private static Connection connection;
    public static final String Q_GETALLDATA =
            "SELECT " +
                    Model_Table.ID.value + ", "+
                    Model_Table.NAME.value +", "+
                    Model_Table.PRICE.value +", "+
                    Model_Table.IMAGE.value +", "+
                    Model_Table.ID_BRAND.value +" "+
                    "FROM Model;";

    public static List<Model> getAllData() throws ConnectionException {
        checkConnection();
        List<Model> modelList = null;
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Q_GETALLDATA);
                modelList = new ArrayList<>();
                while (resultSet.next()) {
                    Model model = new Model(
                            resultSet.getInt(Model_Table.ID.value)
                            , resultSet.getString(Model_Table.NAME.value)
                            , resultSet.getDouble(Model_Table.PRICE.value)
                            , resultSet.getInt(Model_Table.IMAGE.value)
                            , resultSet.getInt(Model_Table.ID_BRAND.value));
                    modelList.add(model);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return modelList;
    }

    private static void checkConnection() throws ConnectionException {
        connection = Connector.getConnection();
        if (connection == null) {
            throw new ConnectionException("Brand - getAllData");
        }
    }
}

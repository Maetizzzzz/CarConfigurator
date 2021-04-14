package com.example.carconfigurator.version;

import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.database.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Version_Querries {
    private static Connection connection;
    public static final String Q_GETALLDATA =
            "SELECT " +
                    Version_Table.ID.value + ", "+
                    Version_Table.NAME.value +", "+
                    Version_Table.PRICE.value +", "+
                    Version_Table.IMAGE.value +", "+
                    Version_Table.ID_BRAND.value +", "+
                    Version_Table.ID_MODEL.value +" "+
                    "FROM " + Version_Table.TABLE_NAME.value +" " +
                    "WHERE "+ Version_Table.ID_BRAND.value + "= ?" +
                    " AND " + Version_Table.ID_MODEL +"= ?;";

    public static List<Version> getAllDataFromModel(int id_brand, int id_model) throws ConnectionException {
        checkConnection();
        List<Version> versionList = null;
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(Q_GETALLDATA);
                statement.setInt(1, id_brand);
                statement.setInt(2, id_model);
                ResultSet resultSet = statement.executeQuery();
                versionList = new ArrayList<>();
                while (resultSet.next()) {
                    Version version = new Version(
                            resultSet.getInt(Version_Table.ID.value)
                            , resultSet.getString(Version_Table.NAME.value)
                            , resultSet.getDouble(Version_Table.PRICE.value)
                            , resultSet.getInt(Version_Table.IMAGE.value)
                            , resultSet.getInt(Version_Table.ID_BRAND.value)
                            , resultSet.getInt(Version_Table.ID_MODEL.value));
                    versionList.add(version);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                versionList = new ArrayList<>();
            }
        }
        return versionList;
    }

    private static void checkConnection() throws ConnectionException {
        connection = Connector.getConnection();
        if (connection == null) {
            throw new ConnectionException("Version Connection");
        }
    }
}

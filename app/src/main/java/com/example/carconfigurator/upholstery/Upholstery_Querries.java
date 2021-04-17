package com.example.carconfigurator.upholstery;

import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.database.Connector;
import com.example.carconfigurator.engineVersion.Engine_Version_Table;
import com.example.carconfigurator.upholsteryVersion.Upholstery_Version_Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Upholstery_Querries {
    private static Connection connection;
    public static final String Q_GETALLDATA =
            "SELECT " +
                    Upholstery_Table.TABLE_NAME.value + "." + Upholstery_Table.ID.value + ", "+
                    Upholstery_Table.UPHOLSTERY.value +", "+
                    Upholstery_Table.PRICE.value +", "+
                    Upholstery_Table.IMAGE.value +", "+
                    Upholstery_Table.STANDARD.value +", "+
                    Upholstery_Table.ID_BRAND.value +" "+
                    "FROM " + Upholstery_Table.TABLE_NAME.value +" " +
                    "INNER JOIN " + Upholstery_Version_Table.TABLE_NAME.value + " "+
                    "ON " + Upholstery_Table.TABLE_NAME.value + "." + Upholstery_Table.ID.value +
                    "=" + Upholstery_Version_Table.TABLE_NAME.value + "." + Upholstery_Version_Table.ID_UPHOLSTERY.value + " " +
                    "WHERE "+ Upholstery_Version_Table.TABLE_NAME.value + "." +Upholstery_Version_Table.ID_VERSION.value + "= ?";

    public static List<Upholstery> getAllUpholsteriesForVersion(int id_version) throws ConnectionException {
        checkConnection();
        List<Upholstery> upholsteryList = null;
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(Q_GETALLDATA);
                statement.setInt(1, id_version);
                ResultSet resultSet = statement.executeQuery();
                upholsteryList = new ArrayList<>();
                while (resultSet.next()) {
                    Upholstery upholstery = new Upholstery(
                            resultSet.getInt(Upholstery_Table.ID.value)
                            , resultSet.getString(Upholstery_Table.UPHOLSTERY.value)
                            , resultSet.getDouble(Upholstery_Table.PRICE.value)
                            , resultSet.getInt(Upholstery_Table.IMAGE.value)
                            , resultSet.getString(Upholstery_Table.STANDARD.value)
                            , resultSet.getInt(Upholstery_Table.ID_BRAND.value));
                    upholsteryList.add(upholstery);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                upholsteryList = new ArrayList<>();
            }
        }
        return upholsteryList;
    }

    private static void checkConnection() throws ConnectionException {
        connection = Connector.getConnection();
        if (connection == null) {
            throw new ConnectionException("Upholstery Connection");
        }
    }
}

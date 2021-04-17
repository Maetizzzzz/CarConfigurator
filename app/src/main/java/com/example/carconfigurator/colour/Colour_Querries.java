package com.example.carconfigurator.colour;

import android.widget.Toast;

import com.example.carconfigurator.colourVersion.Colour_Version_Table;
import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.database.Connector;
import com.example.carconfigurator.engine.Engine_Table;
import com.example.carconfigurator.engineVersion.Engine_Version_Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Colour_Querries {
    private static Connection connection;
    public static final String Q_GETALLDATA =
            "SELECT " +
                    Colour_Table.TABLE_NAME.value +"." + Colour_Table.ID.value + ", "+
                    Colour_Table.COLOUR.value +", "+
                    Colour_Table.PRICE.value +", "+
                    Colour_Table.IMAGE.value +", "+
                    Colour_Table.STANDARD.value +", "+
                    Colour_Table.ID_BRAND.value +" "+
                    "FROM " + Colour_Table.TABLE_NAME.value +" " +
                    "INNER JOIN " + Colour_Version_Table.TABLE_NAME.value + " "+
                    "ON " + Colour_Table.TABLE_NAME.value + "." + Colour_Table.ID.value +
                    "=" + Colour_Version_Table.TABLE_NAME.value + "." + Colour_Version_Table.ID_COLOUR.value + " " +
                    "WHERE "+ Colour_Version_Table.TABLE_NAME.value + "." +Colour_Version_Table.ID_VERSION.value + "= ?";

    public static List<Colour> getAllColoursForBrand(int id_version) throws ConnectionException {
        checkConnection();
        List<Colour> colourList = null;
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(Q_GETALLDATA);
                statement.setInt(1, id_version);
                ResultSet resultSet = statement.executeQuery();
                colourList = new ArrayList<>();
                while (resultSet.next()) {
                    Colour colour = new Colour(
                            resultSet.getInt(Colour_Table.ID.value)
                            , resultSet.getString(Colour_Table.COLOUR.value)
                            , resultSet.getDouble(Colour_Table.PRICE.value)
                            , resultSet.getInt(Colour_Table.IMAGE.value)
                            , resultSet.getString(Colour_Table.STANDARD.value)
                            , resultSet.getInt(Colour_Table.ID_BRAND.value));
                    colourList.add(colour);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                colourList = new ArrayList<>();
            }
        }
        return colourList;
    }

    private static void checkConnection() throws ConnectionException {
        connection = Connector.getConnection();
        if (connection == null) {
            throw new ConnectionException("Engine Connection");
        }
    }
}

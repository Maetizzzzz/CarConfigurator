package com.example.carconfigurator.brand;

import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.database.Connector;
import com.example.carconfigurator.testSpinner.SpinnerItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Brand_Querries {
    private static Connection connection;
    private static final String Q_GETALLDATA = "SELECT id_brand,name,image FROM Brand;";

    public static List<Brand> getAllData() throws ConnectionException {
        checkConnection();
        List<Brand> brandList = null;
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Q_GETALLDATA);
                brandList = new ArrayList<>();
                while (resultSet.next()) {
                    Brand brand = new Brand(
                            resultSet.getInt("id_brand")
                            , resultSet.getString("name")
                            , resultSet.getInt("image"));
                    brandList.add(brand);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return brandList;
    }

    private static void checkConnection() throws ConnectionException {
        connection = Connector.getConnection();
        if (connection == null) {
            throw new ConnectionException("Brand - getAllData");
        }
    }
}

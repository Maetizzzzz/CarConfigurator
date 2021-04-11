package com.example.carconfigurator.database;

import com.example.carconfigurator.testSpinner.SpinnerItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestQuerries {

    public static List<SpinnerItem> getTestData(){
        Connection connection = Connector.getTestConnection();
        List<SpinnerItem> spinnerList = null;
        if (connection!=null){
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from TEST_TABLE;");
                spinnerList = new ArrayList<>();
                while (resultSet.next()){
                    spinnerList.add(new SpinnerItem(resultSet.getString(1)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return spinnerList;
    }
}

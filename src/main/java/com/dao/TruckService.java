package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connectionprovider.Connectiondetails;
import com.entities.Truck;

public class TruckService {
	

    //add truck method
    public static boolean addTruck(Truck truck) throws SQLException {
    	boolean f = false;
        String sql = "INSERT INTO truck (truckName, capacity, truckNumber) VALUES (?, ?, ?)";
        try (Connection connection = Connectiondetails.getconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, truck.getTruckName());
            preparedStatement.setString(2, truck.getCapacity());
            preparedStatement.setString(3, truck.getTruckNumber());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
            	f = true;
                System.out.println("Truck added successfully!");
            } else {
                System.out.println("Failed to add truck.");
            }
        }
        return f;
    }

    //Show trucks
    public  static List<Truck> getAllTruck() throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        String sql = "SELECT * FROM truck";
        try (Connection connection = Connectiondetails.getconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Truck t1 = new Truck();
                t1.setTruckId(resultSet.getInt("truckId"));
                t1.setTruckName(resultSet.getString("truckName"));
                t1.setCapacity(resultSet.getString("capacity"));
                t1.setTruckNumber(resultSet.getString("truckNumber"));
                trucks.add(t1);
            }
        }
        return trucks;
    }


}

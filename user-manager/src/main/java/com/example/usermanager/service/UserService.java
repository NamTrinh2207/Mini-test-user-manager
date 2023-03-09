package com.example.usermanager.service;

import com.example.usermanager.connection.CreateDatabase;
import com.example.usermanager.model.Province;
import com.example.usermanager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUser {
    private final Connection connection;

    {
        try {
            connection = CreateDatabase.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user_manager.user";
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int p_id = resultSet.getInt("province");
                    Province province = selectProvince(p_id);
                    users.add(new User(id, name, province));
                }
                return users;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Province selectProvince(int id) {
        Province province = null;
        String sql = "select * from user_manager.province where id = ?";
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    province = new Province(id, name);
                }
                return province;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

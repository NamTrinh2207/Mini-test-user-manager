package com.example.usermanager.service;

import com.example.usermanager.model.Province;
import com.example.usermanager.model.User;

import java.util.List;

public interface IUser {
    List<User> selectAllUser();
    Province selectProvince(int id);
}

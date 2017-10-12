package com.linder.lab09.DAO;

import java.util.ArrayList;

import com.linder.lab09.bean.User;

public interface UserDAO {
	ArrayList<User> findAll();
}

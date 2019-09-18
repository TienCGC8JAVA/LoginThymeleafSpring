package com.codegym.service;

import com.codegym.model.User;

public interface UserService extends GeneralService<User> {

  Long checkLogin(String email, String password);
}

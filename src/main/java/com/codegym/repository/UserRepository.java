package com.codegym.repository;

import com.codegym.model.User;

public interface UserRepository extends GeneralRepository<User> {

  Long checkLogin(String account, String password);
}

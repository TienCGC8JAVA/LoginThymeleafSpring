package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public void remove(Long id) {
    userRepository.remove(id);
  }

  @Override
  public Long checkLogin(String email, String password) {
    return userRepository.checkLogin(email, password);
  }
}

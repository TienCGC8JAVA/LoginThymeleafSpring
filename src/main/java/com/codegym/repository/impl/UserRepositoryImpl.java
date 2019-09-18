package com.codegym.repository.impl;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRepositoryImpl implements UserRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<User> findAll() {
    TypedQuery<User> query = em.createQuery("select  u from User u", User.class);
    return query.getResultList();
  }

  @Override
  public User findById(Long id) {
    TypedQuery<User> query = em.createQuery("select u from User u where u.id=:id", User.class);
    query.setParameter("id", id);
    try {
      return query.getSingleResult();
    } catch (NoResultException e){
      return null;
    }
  }

  @Override
  public void save(User model) {
    if(model.getId() != null){
      em.merge(model);
    } else {
      em.persist(model);
    }
  }

  @Override
  public void remove(Long id) {
    User user = findById(id);
    if(user != null){
      em.remove(user);
    }
  }

  @Override
  public Long checkLogin(String email, String password){
    List<User> users = findAll();
    for (User user : users) {
      if(user.getEmail().equals(email)){
        if(user.getPassword().equals(password)) return user.getId();
        else return 0L;
      }
    }
    return -1L;
  }
}

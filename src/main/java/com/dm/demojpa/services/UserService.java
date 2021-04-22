package com.dm.demojpa.services;

import com.dm.demojpa.model.Users;
import com.dm.demojpa.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public List<Users> findAll() {
        List<Users> lst=new ArrayList<Users>();
        userJpaRepository.findAll().forEach(lst::add);
        return lst;
    }

    public Users findByname(String name) {
        return userJpaRepository.findByname(name);
    }

    public Users saveUsers(Users users) {
        userJpaRepository.save(users);
        return userJpaRepository.findByname(users.getName());
    }
}

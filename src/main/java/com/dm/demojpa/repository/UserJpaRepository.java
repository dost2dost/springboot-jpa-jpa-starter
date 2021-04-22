package com.dm.demojpa.repository;

import com.dm.demojpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<Users,Long> {

    Users findByname(String name);
}

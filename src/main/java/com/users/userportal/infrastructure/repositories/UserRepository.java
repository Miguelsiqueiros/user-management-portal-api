package com.users.userportal.infrastructure.repositories;

import com.users.userportal.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
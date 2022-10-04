package com.forum.app.api.com.forum.app.api.repository;

import com.forum.app.api.com.forum.app.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

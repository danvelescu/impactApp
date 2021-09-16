package com.impact.impact.app.repositories.user;

import com.impact.impact.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

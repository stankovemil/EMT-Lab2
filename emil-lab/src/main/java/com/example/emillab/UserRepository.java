package com.example.emillab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser save(AppUser entity);
    AppUser findByUsername(String username);
}

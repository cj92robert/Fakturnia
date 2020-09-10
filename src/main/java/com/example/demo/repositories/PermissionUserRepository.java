package com.example.demo.repositories;

import com.example.demo.models.PermissionUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionUserRepository extends JpaRepository<PermissionUser,Long> {
}

package com.inventory.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.users.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
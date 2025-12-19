package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StudentProfile;
public interface StudentProfileRepository extends JpaRepository<StudentProfile,Long>{
    
}
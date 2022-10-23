package com.shefin.stdmgm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shefin.stdmgm.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}

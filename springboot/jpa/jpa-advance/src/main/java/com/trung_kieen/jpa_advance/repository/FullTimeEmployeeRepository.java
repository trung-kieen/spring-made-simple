package com.trung_kieen.jpa_advance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trung_kieen.jpa_advance.entity.Employee;
import com.trung_kieen.jpa_advance.entity.FullTimeEmployee;

import jakarta.transaction.Transactional;

/**
 * FullTimeEmployeeRepository
 */
@Repository
@Transactional
public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee, Long> {

}

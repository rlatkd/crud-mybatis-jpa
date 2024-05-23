package com.emp.empJPA.repository;

import com.emp.empJPA.entity.Emp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmpRepository extends CrudRepository<Emp, Integer> {

    ArrayList<Emp> findAll();
    List<Emp> findByEnameContaining(String ename);
}

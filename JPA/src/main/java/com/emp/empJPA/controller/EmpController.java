package com.emp.empJPA.controller;


import com.emp.empJPA.entity.Emp;
import com.emp.empJPA.repository.EmpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j //로깅을 위한 골뱅이(어노테이션)
public class EmpController {
    @Autowired
    private EmpRepository empRepository;

    //전체조회
    @GetMapping("/emp")
    public String index(Model model){
        List<Emp> empEntityList = empRepository.findAll();
        System.out.println(empEntityList);
//        empEntityList = empEntityList.subList(1, empEntityList.size()-1);
        model.addAttribute("empList", empEntityList);

        return "emp/index";
    }

    // 삽입 폼
    @GetMapping("/emp/new")
    public String newEmpForm(Model model) {
        model.addAttribute("emp", new Emp());
        return "emp/new"; // new.mustache 템플릿을 반환
    }

    // 삽입
    @PostMapping("/test")
    public String createEmp(@ModelAttribute Emp emp) {
        log.info("Creating new employee: {}", emp);  // 로그로 데이터 확인
        empRepository.save(emp);
        return "redirect:/emp"; // 삽입 후 전체 목록으로 리다이렉트
    }

    @GetMapping("/emp/{empno}")
    public String getEmpById(@PathVariable int empno, Model model) {
        Optional<Emp> emp = empRepository.findById(empno);
        if (emp.isPresent()) {
            model.addAttribute("emp", emp.get());
            return "emp/view"; // emp/view.mustache 템플릿으로 이동
        } else {
            return "emp/not-found"; // emp/not-found.mustache 템플릿으로 이동
        }
    }

    // 삭제
    @DeleteMapping("/emp/{empno}")
    public ResponseEntity<Void> deleteEmp(@PathVariable int empno) {
        if (empRepository.existsById(empno)) {
            empRepository.deleteById(empno);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 수정 폼
    @GetMapping("/emp/edit/{empno}")
    public String editEmpForm(@PathVariable int empno, Model model) {
        Optional<Emp> emp = empRepository.findById(empno);
        if (emp.isPresent()) {
            model.addAttribute("emp", emp.get());
            return "emp/update"; // update.mustache 템플릿으로 이동
        } else {
            return "emp/not-found"; // emp/not-found.mustache 템플릿으로 이동
        }
    }

    // 수정
    @PutMapping("/emp/{empno}")
    public ResponseEntity<Emp> updateEmp(@PathVariable int empno, @RequestBody Emp empDetails) {
        Optional<Emp> optionalEmp = empRepository.findById(empno);
        if (optionalEmp.isPresent()) {
            Emp emp = optionalEmp.get();
            emp.setEname(empDetails.getEname());
            emp.setJob(empDetails.getJob());
            emp.setMgr(empDetails.getMgr());
            emp.setHiredate(empDetails.getHiredate());
            emp.setSal(empDetails.getSal());
            emp.setComm(empDetails.getComm());
            emp.setDeptno(empDetails.getDeptno());
            Emp updatedEmp = empRepository.save(emp);
            return ResponseEntity.ok(updatedEmp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 이름 LIKE 검색
    @GetMapping("/emp/search")
    public String searchEmpByName(@RequestParam String ename, Model model) {
        List<Emp> empList = empRepository.findByEnameContaining(ename);
        log.info(empList.toString());
        model.addAttribute("empList", empList);
        return "emp/index";
    }





}

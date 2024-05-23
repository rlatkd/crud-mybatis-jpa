package kr.or.kosa.Emp_1ProjectMybatis.controller;

import kr.or.kosa.Emp_1ProjectMybatis.dto.EmpDto;
import kr.or.kosa.Emp_1ProjectMybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    //전체 데이터 조회
    @GetMapping("/")
    public String findAll(Model model) {
        List<EmpDto> findAll = empService.findAll();
        model.addAttribute("empList", findAll);
        return "/index";
    }

    //사원 디테일 조회
    @GetMapping("/{empno}")
    public String findByEmpno(@PathVariable("empno") int empno, Model model) {
        EmpDto findByEmpno = empService.findByEmpno(empno);
        model.addAttribute("empDetail", findByEmpno);
        return "/detail";
    }

    //사원 등록 페이지
    @GetMapping("/insert")
    public String insert() {
        return "/insert";
    }

    //사원 등록
    @PostMapping("/insert")
    public String insertEmp(@ModelAttribute EmpDto empDto) {
        empService.insert(empDto);
        return "redirect:/";
    }

    //사원 수정
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute EmpDto empDto) {
        empService.update(empDto);
        return "redirect:/";
    }

    //사원 삭제
    @PostMapping("/delete")
    public String deleteEmp(int empno) {
        empService.deleteByEmpno(empno);
        return "redirect:/";
    }

    //사원 이름으로 검색
    @GetMapping("/search")
    public String findByEname(@RequestParam("ename") String ename, Model model) {
        List<EmpDto> empList = empService.findByEname(ename);
        model.addAttribute("empList", empList);
        return "/index";
    }

}


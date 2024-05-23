package kr.or.kosa.Emp_1ProjectMybatis.service;

import kr.or.kosa.Emp_1ProjectMybatis.dto.EmpDto;
import kr.or.kosa.Emp_1ProjectMybatis.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<EmpDto> findAll() {
        return empRepository.findAll();
    }

    public EmpDto findByEmpno(int empno) {
        return empRepository.findByEmpno(empno);
    }

    public void insert(EmpDto empDto) {
        empRepository.insert(empDto);
    }

    public void deleteByEmpno(int empno) {
        empRepository.deleteByEmpno(empno);
    }

    public void update(EmpDto empDto) {
        empRepository.update(empDto);
    }

    public List<EmpDto> findByEname(String ename) {
        return empRepository.findByEname(ename);
    }
}

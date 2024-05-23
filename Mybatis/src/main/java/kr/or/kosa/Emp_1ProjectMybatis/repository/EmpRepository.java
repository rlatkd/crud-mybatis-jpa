package kr.or.kosa.Emp_1ProjectMybatis.repository;

import kr.or.kosa.Emp_1ProjectMybatis.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpRepository {

    List<EmpDto> findAll();
    EmpDto findByEmpno(int empno);
    void insert(EmpDto empDto);
    void deleteByEmpno(int empno);
    void update(EmpDto empDto);
    List<EmpDto> findByEname(String ename);

}

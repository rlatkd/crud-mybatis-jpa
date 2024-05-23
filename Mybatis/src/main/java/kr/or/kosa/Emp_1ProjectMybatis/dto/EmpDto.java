package kr.or.kosa.Emp_1ProjectMybatis.dto;

import lombok.*;

@Getter
@ToString
@Setter
public class EmpDto {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;
    private int deptno;

}

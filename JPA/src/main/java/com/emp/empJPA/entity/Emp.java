package com.emp.empJPA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;

@Entity // DB가 해당 객체를 인식 가능!
@Table(name = "EMP")
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자를 추가
@ToString
@Getter
@Setter
public class Emp {

    @Id
    @Column(name = "EMPNO", nullable = false)
    private int empno;

    @Column(name = "ENAME", length = 10)
    private String ename;

    @Column(name = "JOB", length = 9)
    private String job;

    @Column(name = "MGR")
    private Integer mgr;

    @Column(name = "HIREDATE")
    private java.sql.Date hiredate;

    @Column(name = "SAL")
    private int sal;

    @Column(name = "COMM")
    private Integer comm;

    @Column(name = "DEPTNO")
    private int deptno;
}

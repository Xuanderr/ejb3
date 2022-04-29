package com.example.ejb3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
    @Id
    @Column(name = "empno")
    private Long empNo;

    @Column(name = "ename")
    private String eName;

    @Column(name = "job")
    private String job;

    @Column(name = "mgr")
    private Integer mgr;

    @Column(name = "hiredate")
    private String hireDate;

    @Column(name = "sal")
    private Integer sal;

    @Column(name = "comm")
    private Integer comm;

    @Column(name = "deptno")
    private Integer deptNo;

    public Employee() { }

    public Long getEmpNo() {
        return empNo;
    }

    public String geteName() {
        return eName;
    }

    public String getJob() {
        return job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public String getHireDate() {
        return hireDate;
    }

    public Integer getSal() {
        return sal;
    }

    public Integer getComm() {
        return comm;
    }

    public Integer getDeptNo() {
        return deptNo;
    }
}

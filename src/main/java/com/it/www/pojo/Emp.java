package com.it.www.pojo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable{

    private static final long serialVersionUID = 42L;
    private Integer empno; // 员工编号;自动增长
    private String empname; // 员工姓名
    private Integer empsex; // 员工性别：1、男；2、女
    private Date empbirthday; //员工生日
    private Integer deptid; //所属部门


    private Integer deptnum; //部门编制
    private String deptname; // 所属部门的名称

    public Integer getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(Integer deptnum) {
        this.deptnum = deptnum;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getEmpsex() {
        return empsex;
    }

    public void setEmpsex(Integer empsex) {
        this.empsex = empsex;
    }

    public Date getEmpbirthday() {
        return empbirthday;
    }

    public void setEmpbirthday(Date empbirthday) {
        this.empbirthday = empbirthday;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Emp() {
    }

    public Emp(Integer empno, String empname, Integer empsex, Date empbirthday, Integer deptid) {
        this.empno = empno;
        this.empname = empname;
        this.empsex = empsex;
        this.empbirthday = empbirthday;
        this.deptid = deptid;
    }
}

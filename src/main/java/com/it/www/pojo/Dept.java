package com.it.www.pojo;

import java.io.Serializable;
import java.util.Date;

public class Dept implements Serializable{

    private static final long serialVersionUID = 42L;
    private Integer deptno; // 部门编号;自动增长
    private String deptname; // 部门名称
    private Integer deptnum; // 部门编制
    private String deptdesc; // 部门描述
    private Date deptdate; // 部门创建时间

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(Integer deptnum) {
        this.deptnum = deptnum;
    }

    public String getDeptdesc() {
        return deptdesc;
    }

    public void setDeptdesc(String deptdesc) {
        this.deptdesc = deptdesc;
    }

    public Date getDeptdate() {
        return deptdate;
    }

    public void setDeptdate(Date deptdate) {
        this.deptdate = deptdate;
    }

    public Dept(Integer deptno, String deptname, Integer deptnum, String deptdesc, Date deptdate) {
        this.deptno = deptno;
        this.deptname = deptname;
        this.deptnum = deptnum;
        this.deptdesc = deptdesc;
        this.deptdate = deptdate;
    }

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                ", deptnum=" + deptnum +
                ", deptdesc='" + deptdesc + '\'' +
                ", deptdate=" + deptdate +
                '}';
    }
}

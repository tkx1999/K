package com.it.www.service;

import com.it.www.pojo.Dept;
import com.it.www.pojo.Emp;
import com.it.www.util.Pager;
import com.it.www.util.QueryTool;

import java.util.List;

public interface HrManageService {

    // 获取deptList列表
    public List<Dept> getDeptList();

    // 获取empList列表及页码信息
    public Pager<Emp> getEmpListPager(QueryTool queryTool);

    // 查看部门名称
    public Boolean checkDeptName(String deptname);

    // 新增部门
    public Boolean addDept(Dept dept);

    // 获取员工信息
    public Emp getEmp(Integer empno);

    // 查看员工姓名
    public Boolean checkEmpName(String empname);

    // 新增修改员工
    public Boolean updateEmp(Emp emp);

}

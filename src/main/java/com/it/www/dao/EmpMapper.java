package com.it.www.dao;

import com.it.www.pojo.Emp;
import com.it.www.util.QueryTool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    // 获取empList列表
     public List<Emp> getEmpList(QueryTool queryTool) throws Exception;

    // 获取empList列表记录数
    public Integer getEmpListCount(QueryTool queryTool) throws Exception;

    // 获取员工信息
    public Emp getEmp(@Param("empno") Integer empno) throws Exception;

    // 查看员工姓名
    public Integer checkEmpName(@Param("empname")String empname) throws Exception;

    // 新增员工
    public Integer addEmp(Emp emp) throws Exception;

    // 修改员工
    public Integer updateEmp(Emp emp) throws Exception;

}

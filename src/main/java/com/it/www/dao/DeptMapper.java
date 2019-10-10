package com.it.www.dao;

import com.it.www.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    // 获取deptList列表
    public List<Dept> getDeptList() throws Exception;

    // 查看部门名称
    public Integer checkDeptName(@Param("deptname") String deptname) throws Exception;

    // 新增部门
    public Integer addDept(Dept dept) throws Exception;
}

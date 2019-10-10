package com.it.www.service.imple;

import com.it.www.dao.DeptMapper;
import com.it.www.dao.EmpMapper;
import com.it.www.pojo.Dept;
import com.it.www.pojo.Emp;
import com.it.www.service.HrManageService;
import com.it.www.util.Pager;
import com.it.www.util.QueryTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("hrManageServiceImple")
public class HrManageServiceImple implements HrManageService {
    @Resource
    private EmpMapper empMapper;

    @Resource
    private DeptMapper deptMapper;

    // 获取deptList列表
    public List<Dept> getDeptList(){
        List<Dept> deptList=null;
        try {
            deptList=deptMapper.getDeptList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptList;
    }

    // 获取membersList列表
    public Pager<Emp> getEmpListPager(QueryTool queryTool) {
        Pager<Emp> empListPager = new Pager<Emp>();
        Integer count=null;
        List<Emp> empList=null;
        try {
            empList = empMapper.getEmpList(queryTool);
            count=empMapper.getEmpListCount(queryTool);
            empListPager.setPageList(empList);
            empListPager.setCurrPage(queryTool.getCurrentPage());
            empListPager.setCountSum(count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return empListPager;
    }

    // 查看部门名称
    public Boolean checkDeptName(String deptname) {
        Boolean flag=false;
        Integer res=null;
        try {
            res= deptMapper.checkDeptName(deptname);
            if(res!=null&&res==1){
                flag= true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    // 新增部门
    public Boolean addDept(Dept dept) {
        Boolean flag=false;
        Integer res=null;
        try {
            res= deptMapper.addDept(dept);
            if(res!=null&&res==1){
                flag= true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    // 获取员工信息
    public Emp getEmp(Integer empno){
        Emp emp=null;
        try {
            emp=empMapper.getEmp(empno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }


    // 查看员工姓名
    public Boolean checkEmpName(String empname) {
        Boolean flag=false;
        Integer res=null;
        try {
            res= empMapper.checkEmpName(empname);
            if(res!=null&&res==1){
                flag= true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
    // 新增修改员工
    public Boolean updateEmp(Emp emp){
        Boolean flag=false;
        Integer res=null;
        try {
            if(emp.getEmpno()!=null&&emp.getEmpno()!=0){
                res= empMapper.updateEmp(emp);
            }else{
                res= empMapper.addEmp(emp);
            }
            if(res!=null&&res!=-1&&res!=0){
                flag= true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    };
}
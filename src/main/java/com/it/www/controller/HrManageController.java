package com.it.www.controller;

import com.it.www.pojo.Dept;
import com.it.www.pojo.Emp;
import com.it.www.service.HrManageService;
import com.it.www.util.JsonString;
import com.it.www.util.Pager;
import com.it.www.util.QueryTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author:李渊
 */
@Controller
@RequestMapping("/hrmanage")
public class HrManageController {

    @Resource(name = "hrManageServiceImple")
    private HrManageService hrManageService;


    // 显示deptList列表
    @RequestMapping(value = "/deptlist")
    @ResponseBody
    public List<Dept> getDeptList() {

        // 定义要查询的数据
        List<Dept> deptList=null;
        deptList=hrManageService.getDeptList();
        System.out.println(12321);
        // 传递参数
        return deptList;
    }


    // 显示empList列表及页码信息
    @RequestMapping(value = "/emplist", method = RequestMethod.POST)
    @ResponseBody
    public Pager<Emp> getEmpList(QueryTool queryTool,@RequestParam("currPageNo")Integer currPageNo ) {

        System.out.println(currPageNo);
        // 定义要查询的数据
        Pager<Emp> empListPager = null;
        //queryTool.setMinBirthday(java.sql.Date.valueOf("2011-11-11"));
        if(currPageNo!=null){
            queryTool.setCurrentPage(currPageNo);
        }
        System.out.println(queryTool);
        queryTool.setPageSize(3);
        // 查询empList列表及页码信息
        empListPager = hrManageService.getEmpListPager(queryTool);
        empListPager.setPageUnit(queryTool.getPageSize());
        empListPager.setPageSum((int) Math.ceil((double) empListPager.getCountSum() / queryTool.getPageSize()));
        System.out.println(12321);
        // 传递参数
        return empListPager;
    }

    // 进入新增部门页面
    @RequestMapping(value = "/toadddept")
    public String toAddMember() {
        return "adddept";
    }

    // 查看部门名称
    @RequestMapping(value = "/checkdept")
    @ResponseBody
    public JsonString checkDept(@RequestParam("deptname") String  deptname) {
        //System.out.println(memberNumber);
        JsonString jsonString=new JsonString();
        Boolean flag =false;
        // 查询最新goods
        flag = hrManageService.checkDeptName(deptname);
        // 传递参数
        if (flag) {
            jsonString.setStatus(1);
            jsonString.setMessage("部门名称已存在！");
        } else {
            jsonString.setStatus(-1);
            jsonString.setMessage("可以使用！");
        }
        return jsonString;
    }

    // 新增部门
    @RequestMapping(value = "/adddept")
    @ResponseBody
    public JsonString addMember(@RequestParam("deptname") String  deptname,@RequestParam("deptdesc") String  deptdesc) {
        JsonString jsonString=new JsonString();
        Boolean flag =false;
        Dept dept =new Dept();
        dept.setDeptname(deptname);
        dept.setDeptdesc(deptdesc);
        dept.setDeptdate(new Date());
        // 查询最新goods
        try {
            flag = hrManageService.addDept(dept);
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }finally {
            if (flag) {
                jsonString.setStatus(1);
                jsonString.setMessage("添加成功！");
            } else {
                jsonString.setStatus(-1);
                jsonString.setMessage("添加失败！");
            }
            return jsonString;
        }
    }



    // 进入新增修改员工页面
    @RequestMapping(value = "/toupdateemp/{id}")
    public String toUpdateEmp(@PathVariable Integer  id, Model model) {
        if(id!=null&&id!=0){
            model.addAttribute("eid",id);
        }else {
            model.addAttribute("eid",0);
        }
        return "updateemp";
    }

    // 获取员工信息
    @RequestMapping(value = "/getemp/{empno}")
    @ResponseBody
    public Emp getEmp(@PathVariable Integer  empno) {
        Emp emp=hrManageService.getEmp(empno);
        return emp;
    }

   // 查看员工姓名
    @RequestMapping(value = "/checkempname")
    @ResponseBody
    public JsonString checkEmpName(@RequestParam("empname") String  empname) {
         JsonString jsonString=new JsonString();
        Boolean flag =false;
        // 查询最新goods
        flag = hrManageService.checkEmpName(empname);
        // 传递参数
        if (flag) {
            jsonString.setStatus(1);
            jsonString.setMessage("员工姓名已存在！");
        } else {
            jsonString.setStatus(-1);
            jsonString.setMessage("可以使用！");
        }
        return jsonString;
    }

    // 新增修改员工
    @RequestMapping(value = "/updateemp")
    @ResponseBody
    public JsonString updateEmp(Emp emp) {
        System.out.println(emp);
        JsonString jsonString=new JsonString();
        Boolean flag =false;
        try {
            flag = hrManageService.updateEmp(emp);
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }finally {
            if (flag) {
                jsonString.setStatus(1);
                jsonString.setMessage("更新成功！");
            } else {
                jsonString.setStatus(-1);
                jsonString.setMessage("更新失败！");
            }
            return jsonString;
        }
    }

/*
	// 进入goods详情页
	@RequestMapping(value = "/togoodsview/{gid}")
	public String toGoodsView(@PathVariable("gid") Integer gid, Model model) {
		model.addAttribute("gid", gid);
		//System.out.println(gid);
		// 传递参数
		return "goodsview";
	}

	// 显示goods详情页
	@RequestMapping(value = "/goodsview/{gid}")
	@ResponseBody
	public Emp goodsView(@PathVariable("gid") Integer gid) {
        //System.out.println(gid);
		// 定义要查询的数据
        Emp goods =null;
		// 查询最新goods
        goods = memberService.getGoods(gid);
		// 传递参数
		return goods;
	}

    // 进入新增会员页面
    @RequestMapping(value = "/toaddmember")
    public String toAddMember() {
        return "addmember";
    }

    // 查看会员卡号
    @RequestMapping(value = "/check")
    @ResponseBody
    public JsonString check(@RequestParam("memberNumber") String  memberNumber) {
        //System.out.println(memberNumber);
        JsonString jsonString=new JsonString();
        Boolean flag =false;
        // 查询最新goods
        flag = memberService.checkMemberNumber(memberNumber);
        // 传递参数
        if (flag) {
            jsonString.setStatus(1);
            jsonString.setMessage("会员卡号已存在！");
        } else {
            jsonString.setStatus(-1);
            jsonString.setMessage("可以使用！");
        }
        return jsonString;
    }

    // 新增会员
    @RequestMapping(value = "/addmember")
    @ResponseBody
    public JsonString addMember(@RequestParam("memberNumber") String  memberNumber,@RequestParam("nickName") String  nickName) {
        JsonString jsonString=new JsonString();
        Boolean flag =false;
        Dept members =new Dept();
        members.setMemberNumber(memberNumber);
        members.setNickName(nickName);
        members.setCreateTime(new Date());
        // 查询最新goods
        try {
            flag = memberService.addMembers(members);
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }finally {
            if (flag) {
                jsonString.setStatus(1);
                jsonString.setMessage("添加成功！");
            } else {
                jsonString.setStatus(-1);
                jsonString.setMessage("添加失败！");
            }
            return jsonString;
        }
    }

    // 新增会员
    @RequestMapping(value = "/deletemembers")
    @ResponseBody
    public JsonString deleteMembers(@RequestParam("id") Integer  id) {
        JsonString jsonString=new JsonString();
        Boolean flag =false;
        try {
            flag = memberService.deleteMembers(id);
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }finally {
            if (flag) {
                jsonString.setStatus(1);
                jsonString.setMessage("删除成功！");
            } else {
                jsonString.setStatus(-1);
                jsonString.setMessage("删除失败！");
            }
            return jsonString;
        }
    }
*/

}
function queryDept(){
    //ajax请求数据
    $.ajax({
        url : "/hrmanage/deptlist",
        type : "get",
        success : function(jsonstr) {
            //alert(jsonstr)
            var str = "<option value=''>请选择</option>";
            for (var i = 0; i < jsonstr.length; i++) {
                var str1 =" <option value="+jsonstr[i].deptno+">"+jsonstr[i].deptname+"</option>"
                str += str1;
            }
            //局部刷新页面
            $("#deptList").html(str);

            var empno=$(":input[name=empno]").val();
            if(empno!=null&&empno!=0){
                $.ajax({
                    url : "/hrmanage/getemp/"+empno,
                    type : "get",
                    success : function(jsonstr) {
                        $(":input[name=empname]").val(jsonstr.empname);
                        $(":input[name=empname]").attr("disabled","disabled");
                        $(":input[name=empbirthday]").val(jsonstr.empbirthday);
                        $(":input[value="+jsonstr.empsex+"]").attr("checked","checked");
                        $(":input[name=deptid]").val(jsonstr.deptid);
                    }
                })
            }
        }
    })
}

function checkemp() {
    var empno=$(":input[name=empno]").val();
    var empname=$(":input[name=empname]").val();
    var empbirthday=$(":input[name=empbirthday]").val();
    var deptid=$(":input[name=deptid]").val();
    if (empname == null || empname == "") {
        alert("员工姓名不能为空！");
        return;
    }
    if (empbirthday == null || empbirthday == "") {
        alert("出生日期不能为空！");
        return;
    }
    if (deptid == null || deptid == "") {
        alert("所属部门不能为空！");
        return;
    }
    //alert(empname)
    if(empno!=null&&empno!=0){
        add();
    }else if(empno==0){
        $.ajax({
            url : "/hrmanage/checkempname",
            type : "get",
            data:{empname:empname},
            success : function(jsonstr) {
                //alert(jsonstr.status)
                if (jsonstr.status == 1) {
                    alert(jsonstr.message);
                    return;
                } else {
                    add();
                    return;
                }
            }
        })
    }
}

function show() {
    window.location.href="/";
}

function add() {
    $.ajax({
        url : "/hrmanage/updateemp",
        type : "get",
        data:$("#form2").serialize(),
        success : function(jsonstr) {
            if (jsonstr.status == 1) {
                alert(jsonstr.message);
                window.location.href="/";
                return;
            } else {
                alert(jsonstr.message);
                window.location.reload();
                return;
            }
        }
    })
}
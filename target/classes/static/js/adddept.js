function checkdept() {
    var deptname=$("#deptname").val();
    if (deptname == null || deptname == "") {
        alert("部门名称不能为空！");
        return;
    }
    $.ajax({
        url : "/hrmanage/checkdept",
        type : "get",
        data:{deptname:deptname},
        success : function(jsonstr) {
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

function show() {
    window.location.href="/";
}

function add() {
    var deptname=$("#deptname").val();
    var deptdesc=$("#deptdesc").val();
    $.ajax({
        url : "/hrmanage/adddept",
        type : "get",
        data:{deptname:deptname,deptdesc:deptdesc},
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
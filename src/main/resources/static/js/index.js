function query() {
    queryDept();
    queryEmp();
}

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
        }
    })
}

function queryEmp(currPageNo){
    var currPage=1;
    if(currPageNo!=undefined){
        currPage=currPageNo;
    }
    alert(currPageNo!=undefined)
    var queryTool=$("#form1").serialize()
    //alert(queryTool)
    //ajax请求数据
    $.ajax({
        url : "/hrmanage/emplist",
        type : "post",
        data:queryTool+"&currPageNo="+currPage,
        success : function(jsonstr) {
            //alert(jsonstr)
            var str = "";
            for (var i = 0; i < jsonstr.pageList.length; i++) {
                var sex="";
                if(jsonstr.pageList[i].empsex==1){
                    sex="男";
                }else if(jsonstr.pageList[i].empsex==2){
                    sex="女";
                }
                var str1 = "<tr class='tablecontext'><td>" + jsonstr.pageList[i].empno
                    + "</td><td>" + jsonstr.pageList[i].empname + "</td><td >"
                    + sex + "</td><td >"
                    + jsonstr.pageList[i].empbirthday +"</td><td >"
                    + jsonstr.pageList[i].deptname +"</td><td >"
                    + jsonstr.pageList[i].deptname + "</td><td><a href='/hrmanage/toupdateemp/"
                    + jsonstr.pageList[i].empno + "'>修改"
                    + "</a>&nbsp;&nbsp;<a href='javascript:onclick=deleteemp("+jsonstr.pageList[i].empno+")'>删除</a></td></tr>"
                str += str1;
            }
            //局部刷新页面
            $("#context").html(str);
            //追加样式
            //$(".tablecontext:even").css("background", "rgb(137,208,254)");

            //添加页码信息
            var str2="<a href='javascript:onclick=queryEmp(1)'>首页</a>&nbsp;";
            if(jsonstr.currPage>1){
                str2+="<a href='javascript:onclick=queryEmp("+(jsonstr.currPage-1)+")'>上一页</a>&nbsp;"
            }
            if(jsonstr.currPage>=1&&jsonstr.currPage<jsonstr.pageSum){
                str2+="<a href='javascript:onclick=queryEmp("+(jsonstr.currPage+1)+")'>下一页</a>&nbsp;"
            }
            str2+="<a href='javascript:onclick=queryEmp("+(jsonstr.pageSum)+")'>尾页</a>&nbsp;" +
                "共计"+jsonstr.pageSum+"页，共计"+jsonstr.countSum+"条"
            $("#pager").html(str2);
        }
    })
}

function adddetp() {
    window.location.href="/hrmanage/toadddept";
}

function addemp() {
    window.location.href="/hrmanage/toupdateemp/0";
}
/*
function deleteMembers(id) {
    if(confirm("确认删除该会员吗？")){
        $.ajax({
            url : "/member/deletemembers",
            type : "get",
            data:{id:id},
            success : function(jsonstr) {
                if (jsonstr.status == 1) {
                    alert(jsonstr.message);
                    window.location.reload();
                    //$("#error").text(jsonstr.message)
                    //$("#error").show();
                    return;
                } else {
                    alert(jsonstr.message);
                    window.location.reload();
                    //$("#error").text(jsonstr.message)
                    //$("#error").show();
                    return;
                }
            }
        })
    }
}*/

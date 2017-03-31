<%@ page import="com.sitong.vo.User" %>
<%@ page import="com.sitong.servise.UserServImpl" %><%--
  Created by IntelliJ IDEA.
  User: LiuSitong
  Date: 2017/3/23
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName= request.getParameter("userName");
    String password= request.getParameter("password");

    User user = new User();
    user.setUsername(userName);
    user.setPassword(password);
    UserServImpl userServ = new UserServImpl();

    if (userServ.add(user) == true){
        %>
     <script>
         alert("添加成功");
         window.location="index.jsp";

     </script>

<%
    }else{
        %>
<script>
    alert("添加失败");
    window.location="index.jsp";


</script>
<%
    }
%>

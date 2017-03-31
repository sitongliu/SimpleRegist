<%@ page import="com.sitong.servise.UserServImpl" %><%--
  Created by IntelliJ IDEA.
  User: LiuSitong
  Date: 2017/3/29
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserServImpl ser = new UserServImpl();
    String id =request.getParameter("id");
    if (ser.del(Integer.parseInt(id))==true) {
        %><script>
    alert("成功");
    window.location="index.jsp";
</script><%

    }else {
        %>
<script>
    alert("失败");
    window.location="index.jsp";
</script>

<%
    }


%>


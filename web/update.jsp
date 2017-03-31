<%@ page import="com.sitong.servise.UserServImpl" %>
<%@ page import="com.sitong.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: LiuSitong
  Date: 2017/3/29
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserServImpl service=new UserServImpl();

    User user=new User();
    user.setUser_id(Integer.parseInt(request.getParameter("id")));
    String username=new String(request.getParameter("userName").toString().getBytes("ISO8859-1"),"utf-8");
    System.out.println(username);
    user.setUsername(username);
    user.setPassword(request.getParameter("password"));
    if(service.update(user)){
        request.setAttribute("msg","修改成功！");
%>
<jsp:forward page="index.jsp"/>
<%
}else{
    request.setAttribute("msg","修改失败！");
%>
<jsp:forward page="index.jsp"/>
<%
    }%>

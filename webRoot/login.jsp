<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragram" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache, must-revalidate"/>
<meta http-equiv="expires" content="0"/>
<title>欢迎使用顺丰航空机务维修管理系统</title>

</head>

<body>
  <form action="/login.do" method="post">
    userName:<input name="userName" type="text"/><br />
    password:<input type="password" name="password"/>
    <br /><div> <font color="red" size="2">  ${error} </font></div>
  <button type="submit">提交</button>
  </form>
</body>
</html>

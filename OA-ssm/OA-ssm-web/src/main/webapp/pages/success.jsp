<%--
  Created by IntelliJ IDEA.
  User: zhangkun
  Date: 2020/3/29
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询所有的帐户</h3>
<c:forEach items="${products}" var="product">
    ${product.id}
</c:forEach>

</body>
</html>

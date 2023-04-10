<%--
  Created by IntelliJ IDEA.
  User: liguang
  Date: 2023/4/10
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Json练习</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript">
    //请求是json 输出是json
    function requestJson(){
      $.ajax(
              {
                type:'post',
                url:'${pageContext.request.contextPath}/orders/requestJson',
                data:'{"name":"手机","price":"1999"}',
                contentType:'application/json;charset=utf-8',
                success:function (data){//返回json结果
                  alert(data.name,data.price);
                }
              }
      );
    }

    function requestKV(){
        $.ajax(
            {
                type:'post',
                url:'${pageContext.request.contextPath}/orders/requestKV',
                data:'name=手机&&price=999',
                success:function (data){//返回json结果
                    alert(data.price);
                }

            }
        );
    }

  </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求是json,输出是json"></br>
<input type="button" onclick="requestKV()" value="请求是key-value,输出是json"></br>
</body>
</html>

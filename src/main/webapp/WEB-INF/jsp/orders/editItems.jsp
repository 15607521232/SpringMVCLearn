<%--
  Created by IntelliJ IDEA.
  User: liguang
  Date: 2023/4/2
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>修改商品信息</title>
</head>
<body>
<c:if test="${allErrors!=null}">
  <c:forEach var="error" items="${allErrors}">
    ${error.defaultMessage}
  </c:forEach>
</c:if>


<%--enctype="multipart/form-data" 代表支持上传图片--%>
<form id="itemForm" action="${pageContext.request.contextPath }/orders/editItemsSubmit" method="post">
  <input type="hidden" name="id" value="${itemsCustom.id }"/>
  修改商品信息：
  <table width="100%" border=1>
    <tr>
      <td>商品名称</td>
      <td><input type="text" name="name" value="${itemsCustom.name }"/></td>
    </tr>
    <tr>
      <td>商品价格</td>
      <td><input type="text" name="price" value="${itemsCustom.price }"/></td>
    </tr>
    <tr>
      <td>商品生产日期</td>
      <td><input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
    </tr>
    <tr>
      <td>商品图片</td>
      <td>
        <c:if test="${itemsCustom.pic !=null}">
          <img src="/pic/${itemsCustom.pic}" width=100 height=100/>
          <br/>
        </c:if>
        <input type="file"  name="pic"/>
      </td>
    </tr>
    <tr>
      <td>商品简介</td>
      <td>
        <textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="提交"/>
      </td>
    </tr>
  </table>

</form>
</body>
</html>

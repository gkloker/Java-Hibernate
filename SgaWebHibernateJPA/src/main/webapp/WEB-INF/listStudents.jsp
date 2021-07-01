<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Students</title>
</head>
<body>
  <h1>Students</h1>
  <a href="${pageContext.request.contextPath}/ServletAdd">Add</a>
  <table border="1">
    <tr>
      <th>Student ID</th>
      <th>Name</th>
      <th>Address</th>
      <th>Email</th>
      <th>Phone</th>
    </tr>
    <c:forEach var="student" items="${students}">
      <tr>
        <td>
          <a href="${pageContext.request.contextPath}/ServletUpdate?idStudent=${student.idStudent}">
              ${student.idStudent}
          </a>
        </td>
        <td>${student.firstName} ${student.lastName}</td>
        <td>${student.address.street} ${student.address.numStreet} ${student.address.country}</td>
        <td>${student.contact.email}</td>
        <td>${student.contact.phone}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<form name="form" action="${pageContext.request.contextPath}/ServletUpdate" method="post">
  <input type="hidden" name="idStudent" value="${student.idStudent}" />
  <table>
    <tr>
      <td>First Name</td>
      <td><input type="text" name="firstName" value="${student.firstName}" /></td>
    </tr>
    <tr>
      <td>Last Name</td>
      <td><input type="text" name="lastName" value="${student.lastName}" /></td>
    </tr>
    <tr>
      <td>Street</td>
      <td><input type="text" name="street" value="${student.address.street}" /></td>
    </tr>
    <tr>
      <td>Street Number</td>
      <td><input type="text" name="numStreet" value="${student.address.numStreet}" /></td>
    </tr>
    <tr>
      <td>Country</td>
      <td><input type="text" name="country" value="${student.address.country}" /></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="email" name="email" value="${student.contact.email}" /></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="tel" name="phone" value="${student.contact.phone}" /></td>
    </tr>
  </table>
  <input type="submit" name="Update" value="Update">
  <input type="submit" name="Delete" value="Delete">
</form>
</body>
</html>

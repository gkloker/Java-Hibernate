<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Student</title>
</head>
<body>
  <h1>Add Student</h1>
  <form name="form" action="${pageContext.request.contextPath}/ServletAdd" method="post">
    <table>
      <tr>
        <td>First Name</td>
        <td><input type="text" name="firstName" /></td>
      </tr>
      <tr>
        <td>Last Name</td>
        <td><input type="text" name="lastName" /></td>
      </tr>
      <tr>
        <td>Street</td>
        <td><input type="text" name="street" /></td>
      </tr>
      <tr>
        <td>Street Number</td>
        <td><input type="text" name="numStreet" /></td>
      </tr>
      <tr>
        <td>Country</td>
        <td><input type="text" name="country" /></td>
      </tr>
      <tr>
        <td>Email</td>
        <td><input type="email" name="email" /></td>
      </tr>
      <tr>
        <td>Phone</td>
        <td><input type="tel" name="phone" /></td>
      </tr>
    </table>
    <input type="submit" name="Add" value="Add">
  </form>
</body>
</html>

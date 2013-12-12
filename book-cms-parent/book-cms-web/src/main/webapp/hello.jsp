<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head><title>Hello World</title></head>
<body>
  <h1>Hello World!</h1>
  <p>Today is ${info}</p>
  <p>Application has run for ${lifeTime} minute(s)</p>
  <p/>
  <table border="1">
    <c:forEach var="book" items="${books}">
      <tr>
        <td>${book.title}</td>
        <td>${book.genre}</td>
        <td>
          <c:forEach var="author" items="${book.authors}">
            ${author.firstName} ${author.lastName} ${author.middleName} 
            <fmt:formatDate pattern="dd-MM-yyyy" value="${author.birthDate}" /><br/>
          </c:forEach>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>

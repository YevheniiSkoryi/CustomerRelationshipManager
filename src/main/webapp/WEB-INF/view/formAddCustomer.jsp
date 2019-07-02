<%--
  Created by IntelliJ IDEA.
  User: evghenii
  Date: 9/8/18
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<!DOCKTYPE html>
<html>

<head>
    <title>Customer's form</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">

        <%--need to assosiate this data with customer id--%>
        <form:hidden path="id"/>
        <table>
            <tbody>

            <tr>
                <td><label>First name: </label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name: </label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email: </label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/> </td>
            </tr>

            </tbody>
        </table>
    </form:form>
    <div style="clear: both;">
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
        </p>
    </div>
</div>

</body>
</html>

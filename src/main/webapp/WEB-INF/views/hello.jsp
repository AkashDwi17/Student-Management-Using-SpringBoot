<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>

<h2>Register User</h2>
<form action="/register" method="post">
    Name: <input type="text" name="name" /><br><br>
    Email: <input type="email" name="email" /><br><br>
    Password: <input type="password" name="password" /><br><br>
    <button type="submit">Register</button>
</form>

<hr>

<h2>All Users</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Action</th>
    </tr>

    <c:forEach var="u" items="${users}">
        <tr>
            <form action="/update" method="post">
                <td>
                    ${u.id}
                    <input type="hidden" name="id" value="${u.id}" />
                </td>
                <td><input type="text" name="name" value="${u.name}" /></td>
                <td><input type="email" name="email" value="${u.email}" /></td>
                <td><input type="text" name="password" value="${u.password}" /></td>
                <td>
                    <button type="submit">Update</button>
                    <a href="/delete/${u.id}">Delete</a>
                </td>
            </form>
        </tr>
    </c:forEach>

</table>

</body>
</html>

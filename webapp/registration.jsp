<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
    <h2>Register</h2>
    <form action="RegistrationServlet" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required /></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><input type="text" name="phoneNumber" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Register" />
                </td>
            </tr>
        </table>
    </form>
    <p><a href="index.html">Already have an account? Login here.</a></p>
</body>
</html>
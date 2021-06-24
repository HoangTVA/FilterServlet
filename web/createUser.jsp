<%-- 
    Document   : createUser
    Created on : Feb 27, 2021, 2:24:36 PM
    Author     : phath
--%>

<%@page import="sample.dtos.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <%
            UserError userError = (UserError)request.getAttribute("ERROR");
            if(userError == null){
                userError = new UserError("", "", "", "", "");
            }
        %>        
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID"required="true"/></br>
            <%= userError.getUserIDError() %></br>
            Full Name<input type="text" name="fullName"required="true"/></br>
             <%= userError.getFullNameError()%></br>
            Role ID<input type="text" name="roleID"required="true"/></br>
             <%= userError.getRoleIDError() %></br>
            Password<input type="password" name="password"required="true"/></br>
             <%= userError.getPasswordError() %></br>
            Confirm<input type="password" name="confirm"required="true"/></br>
             <%= userError.getConfirmError() %></br>
             
            <input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>

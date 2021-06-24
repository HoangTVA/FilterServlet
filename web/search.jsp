<%-- 
    Document   : search
    Created on : Jan 21, 2021, 1:41:28 PM
    Author     : phath
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
//            if (user == null) {
//                response.sendRedirect("login.html");
//                return;
//            }
            String searchValue = request.getParameter("search");
            if (searchValue == null) {
                searchValue = "";
            }
        %>
        <h1>Welcome:<%=user.getFullName()%> </h1>
        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <form action="MainController">
            Search <input type="text" name="search" value="<%= searchValue%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO dto : list) {

                %>
            <form action="MainController">

                <tr>
                    <td><%= count++%></td>
                    <td><%= dto.getUserID()%></td>
                    <td><%=dto.getFullName()%></td>
                    <td><%=dto.getRole()%></td>
                    <td><%=dto.getPassword()%></td>
                    <td>
                        <a href="MainController?search=<%= request.getParameter("search")%>&action=Delete&userID=<%=dto.getUserID()%>" >Delete</a>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="userID" value="<%=dto.getUserID() %>"/>
                        <input type="hidden" name="fullName" value="<%=dto.getFullName() %>"/>
                        <input type="hidden" name="roleID" value="<%=dto.getRole() %>"/>
                        <input type="hidden" name="search" value="<%=request.getParameter("search") %>"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        }
    %>
</body>
</html>

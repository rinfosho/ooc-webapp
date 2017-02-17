<%@ page import="io.muic.ooc.webapp.service.DatabaseService" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Welcome to the user page. The users registered on this website are:</h2>

<%
    Connection conn;
    final String SQL_URL = "jdbc:mysql://127.0.0.1:3306/User_Database";
    conn = DriverManager.getConnection(SQL_URL, "rinfosho", "ggwellplayed55");
    PreparedStatement preS = conn.prepareStatement("select * from User_Database.User_data;");
    ResultSet rsltst = preS.executeQuery();
%>
<table>
    <th>First Name</th>
    <th>Username</th>
    <th>-Edit </th>
    <th>Account-</th>


    <%
        while(rsltst.next()){
    %>
    <tr>
        <td><%=rsltst.getString("FirstName") %></td>
        <td><%=rsltst.getString("Username") %></td>
        <form action = "/delete" method = "get">
        <%--<td><input type="button" value="Edit"></td>--%>
            <td><input type="button" value="Delete"></td>
        </form>


    </tr>
    <%
        }
        rsltst.close();
    %>
</table>

</body>
</html>

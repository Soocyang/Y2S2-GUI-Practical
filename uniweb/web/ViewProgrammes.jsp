<%-- ViewProgrammes.jsp --%>
<%@page import="entity.Programme"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>List of Programmes</title>
    </head>
    <body>
        <h1>List of Programmes</h1>
        <% List list = (List<Programme>)request.getAttribute("programmeList");
       for (int i = 0; i < list.size(); ++i) { %>
         <%= (i + 1) + "." + list.get(i) %><br/>
    <% } %>
    </body>
</html>

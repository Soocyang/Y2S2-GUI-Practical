<%-- View component: PassengerListView --%>
<%@page import="entity.Passenger"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <title>Passenger List</title>
  </head>
  <body>
    <h2>Updated Passenger List</h2>
    <% List list = (List<Passenger>)request.getAttribute("passengerList");
       for (int i = 0; i < list.size(); ++i) { %>
         <%= (i + 1) + ". " + list.get(i) %><br />
    <% } %>
  </body>
</html>

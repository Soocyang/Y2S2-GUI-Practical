<%-- GetCountryDetails.jsp --%>
<%@page import="domain.Country" %>
<jsp:useBean id="country" 
             class="domain.Country" 
             scope="session"></jsp:useBean>
<jsp:setProperty name="country" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <title>Get Country Detail</title>
    </head>
    <body>

        <%
            if (country.getName() == null || country.getFullName() == null || country.getCapital() == null) {
                out.println("Country name, official name and capital are required");
                return;
            }
        %>
        <h1>Add Country Detail</h1>
        <p>You entered the following data</p>
        <p>Name : <%= country.getName()%></p>
        <p>Official Name : <%= country.getFullName()%></p>
        <p>Capital : <%= country.getCapital()%></p>

        <form method="post" action="SaveCountryDetails.jsp">
            <input type="submit" value="Confirm" />
        </form>
    </body>
</html>

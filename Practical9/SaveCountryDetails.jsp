<%-- SaveCountryDetails.jsp --%>
<%@page import="domain.Country" %>
<jsp:useBean id="country"
             class="domain.Country" scope="session">
</jsp:useBean>
<jsp:useBean id="countriesDAId"
             class="da.CountriesDA" scope="application">
</jsp:useBean>
<!DOCTYPE html>
<html>
    <body>
        <%
            countriesDAId.addRecord(country);

            out.println(country.getName() + " " + " has been stored in the database");

            out.close();

        %>


    </body>
</html>

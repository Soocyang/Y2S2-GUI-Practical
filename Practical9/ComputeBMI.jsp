<%-- 
    Document   : ComputeBMI
    Created on : Dec 19, 2018, 3:59:53 PM
    Author     : User
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI Calculation</title>
    </head>
    <body>
        <h1>BMI Calculation</h1>
        <%@page import="domain.BMI"%>
        <% 
            double height = Double.parseDouble(request.getParameter("meters"));
            double weight = Double.parseDouble(request.getParameter("kilograms"));            
            BMI bmi = new BMI(weight, height);
            

            %>
        Height : <%= String.format("%.2f", weight) %> m<br />
        Weight : <%= String.format("%.2f", height) %> kg<br />
        BMI : <%= String.format("%.2f", bmi.getBMI()) %><br />
        Category : <%= String.format("%s", bmi.getStatus()) %><br />
            
    </body>
</html>
